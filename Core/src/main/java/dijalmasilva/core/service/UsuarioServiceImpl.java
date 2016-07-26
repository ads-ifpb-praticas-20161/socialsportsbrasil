/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.core.service;

import dijalmasilva.core.repository.UsuarioDao;
import dijalmasilva.entidades.Usuario;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class UsuarioServiceImpl implements UsuarioService {

    @Inject
    private UsuarioDao dao;

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
        System.out.println(u.getEmail());
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
        return dao.save(user);
    }

    @Override
    public Usuario removerAmigo(Long id, Long amigo) {
        Usuario user = dao.findOne(id);
        Usuario friend = dao.findOne(amigo);
        user.removeAmigo(friend);
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

}
