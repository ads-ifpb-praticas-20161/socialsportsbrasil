/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.core.service;

import dijalmasilva.entidades.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import javax.inject.Named;
import dijalmasilva.core.repository.UsuarioRepository;

@Named
public class UsuarioServiceImpl implements UsuarioService {

    @Inject
    private UsuarioRepository dao;

    @Override
    public Usuario login(String emailOuUsername, String password) {
        if (emailOuUsername.contains("@")) {
            return loginEmail(emailOuUsername, password);
        } else {
            return loginUsername(emailOuUsername, password);
        }
    }

    private Usuario loginEmail(String email, String password) {
        Usuario user = dao.findByEmail(email);
        if (user != null && user.getSenha().equals(password)) {
            return user;
        } else {
            return null;
        }
    }

    private Usuario loginUsername(String username, String password) {
        Usuario user = dao.findByUsername(username);
        if (user != null && user.getSenha().equals(password)) {
            return user;
        } else {
            return null;
        }
    }

    @Override
    public Usuario salvarUsuario(Usuario u) {
        return dao.save(u);
    }

    @Override
    public void desativarConta(Long id) {
        Usuario u = dao.findOne(id);
        u.setConta("DESATIVADA");
        dao.save(u);
    }

    @Override
    public Usuario atualizarPerfil(Usuario u) {
        return dao.save(u);
    }

    @Override
    public Usuario adicionarAmigo(Long id, Long amigo) {
        Usuario user = dao.findOne(id);
        Usuario friend = dao.findOne(amigo);
        user.addAmigo(friend);
        dao.save(friend);
        return dao.save(user);
    }

    @Override
    public Usuario removerAmigo(Long id, Long amigo) {
        Usuario user = dao.findOne(id);
        Usuario friend = dao.findOne(amigo);
        user.removeAmigo(friend);
        dao.save(friend);
        return dao.save(user);
    }

    private List<Usuario> buscarPorUsername(String username) {

        List<Usuario> usuarios = dao.findByUsernameContaining(username);
        return usuarios;
    }

    private List<Usuario> buscarPorEmail(String email) {

        List<Usuario> usuarios = dao.findByEmailContaining(email);
        return usuarios;
    }

    @Override
    public List<Usuario> listarTodos() {
        return (List<Usuario>) dao.findAll();
    }

    @Override
    public Usuario findById(Long id) {
        return dao.findOne(id);
    }

    @Override
    public List<Usuario> buscarUsuarios(String nome) {
        List<Usuario> usuarios;

        if (nome.contains("@")) {
            usuarios = buscarPorEmail(nome);
        } else {
            usuarios = buscarPorUsername(nome);
        }

        return usuarios;
    }

    @Override
    public boolean isFollow(Long id, Long seguindo) {
        Usuario user = dao.findOne(id);
        return user.isFollowing(seguindo);
    }

    @Override
    public List<Usuario> buscarUsuariosComIdDiferenteAndNaoDesativada(String nome, Long id) {
        List<Usuario> usuariosEncontrados;
        String[] nomes = nome.split(" ");
        List<Usuario> usuariosEncontradosPorNome;
        List<Usuario> usuariosEncontradosSobrenome;
        if (nomes != null && nomes.length > 1) {
            System.out.println("Buscando por " + nomes[0]);
            usuariosEncontradosPorNome = dao.findByNomeContainingAndIdNotAndContaNotLike(nomes[0], id, "Desativada");
            System.out.println("------------------------------");
            System.out.println("Encontrou " + usuariosEncontradosPorNome.size() + " usuários");
            System.out.println("------------------------------");
            System.out.println("Buscando por " + nomes[1]);
            usuariosEncontradosSobrenome = dao.findBySobrenomeContainingAndIdNotAndContaNotLike(nomes[1], id, "Desativada");
            System.out.println("------------------------------");
            System.out.println("Encontrou " + usuariosEncontradosSobrenome.size() + " usuários");
            System.out.println("------------------------------");

        } else {
            System.out.println("Buscando por " + nome + " em nome");
            usuariosEncontradosPorNome = dao.findByNomeContainingAndIdNotAndContaNotLike(nome, id, "Desativada");
            System.out.println("------------------------------");
            System.out.println("Encontrou " + usuariosEncontradosPorNome.size() + " usuários");
            System.out.println("------------------------------");
            System.out.println("Buscando por " + nome + " em sobrenome");
            usuariosEncontradosSobrenome = dao.findBySobrenomeContainingAndIdNotAndContaNotLike(nome, id, "Desativada");
            System.out.println("------------------------------");
            System.out.println("Encontrou " + usuariosEncontradosSobrenome.size() + " usuários");
            System.out.println("------------------------------");
        }

        usuariosEncontrados = usuariosEncontradosPorNome;

        for (Usuario u1 : usuariosEncontrados) {
            for (Usuario u2 : usuariosEncontradosSobrenome) {
                if (!Objects.equals(u1.getId(), u2.getId())) {
                    System.out.println("------------------------");
                    usuariosEncontrados.add(u2);
                    System.out.println("Adicionando " + u2.getNome() + u2.getSobrenome());
                    System.out.println("------------------------");
                }
            }
            
            System.out.println(u1.getNome() + " " + u1.getSobrenome());
        }
        
        return usuariosEncontrados;
    }

}
