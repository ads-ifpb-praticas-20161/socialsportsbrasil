/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.ssb.core.services;

import dijalmasilva.ssb.core.dao.UsuarioDao;
import dijalmasilva.ssb.entidades.Usuario;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author dijalma
 */
public class ServiceUser {
    
    @Inject
    private UsuarioDao dao;
    
    public Usuario loginEmail(String email, String password){
        Usuario user = dao.findByEmail(email);
        if (user.getSenha().equals(password))
            return user;
        else {
            return null;
        }
    }
    
    public Usuario loginUsername(String username, String password){
        Usuario user = dao.findByUsername(username);
        if (user.getSenha().equals(password))
            return user;
        else {
            return null;
        }
    }
    
    public Usuario salvarUsuario(Usuario u){
        return dao.save(u);
    }
    
    public void desativarConta(Long id){
        Usuario u = dao.findOne(id);
        u.setConta("DESATIVADA");
        dao.save(u);
    }
    
    public Usuario atualizarPerfil(Usuario u){
        return dao.save(u);
    }
    
    public Usuario adicionarAmigo(Long id, Long amigo){
        Usuario user = dao.findOne(id);
        Usuario friend = dao.findOne(amigo);
        user.addAmigo(friend);
        return dao.save(user);
    }
    
    public Usuario removerAmigo(Long id, Long amigo){
        Usuario user = dao.findOne(id);
        Usuario friend = dao.findOne(amigo);
        user.removeAmigo(friend);
        return dao.save(user);
    }
    
    public List<Usuario> buscarUsuariosPorEmail(String email){
        return dao.allByEmail(email);
    }
    
    public List<Usuario> buscarUsuariosPorUsername(String username){
        return dao.allByUsername(username);
    }
    
    public List<Usuario> listarTodos(){
        return (List<Usuario>) dao.findAll();
    }
    
    public Usuario findById(Long id){
        return dao.findOne(id);
    }
}
