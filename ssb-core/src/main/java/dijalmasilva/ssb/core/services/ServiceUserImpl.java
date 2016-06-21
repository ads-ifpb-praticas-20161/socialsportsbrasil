/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.ssb.core.services;

import dijalmasilva.ssb.core.dao.UsuarioDao;
import dijalmasilva.ssb.entidades.Usuario;
import java.util.List;
import javax.inject.Named;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author dijalma
 */
@Named
public class ServiceUserImpl implements ServiceUser{
    
    @Autowired
    private UsuarioDao dao;
    
    @Override
    public Usuario loginEmail(String email, String password){
        Usuario user = dao.findByEmail(email);
        if (user.getSenha().equals(password))
            return user;
        else {
            return null;
        }
    }
    
    @Override
    public Usuario loginUsername(String username, String password){
        Usuario user = dao.findByUsername(username);
        if (user.getSenha().equals(password))
            return user;
        else {
            return null;
        }
    }
    
    @Override
    public Usuario salvarUsuario(Usuario u){
        System.out.println(u.getEmail());
        return dao.save(u);
    }
    
    @Override
    public void desativarConta(Long id){
        Usuario u = dao.findOne(id);
        u.setConta("DESATIVADA");
        dao.save(u);
    }
    
    @Override
    public Usuario atualizarPerfil(Usuario u){
        return dao.save(u);
    }
    
    @Override
    public Usuario adicionarAmigo(Long id, Long amigo){
        Usuario user = dao.findOne(id);
        Usuario friend = dao.findOne(amigo);
        user.addAmigo(friend);
        return dao.save(user);
    }
    
    @Override
    public Usuario removerAmigo(Long id, Long amigo){
        Usuario user = dao.findOne(id);
        Usuario friend = dao.findOne(amigo);
        user.removeAmigo(friend);
        return dao.save(user);
    }
    
    @Override
    public List<Usuario> buscarUsuariosPorEmail(String email){
        return dao.allByEmail(email);
    }
    
    @Override
    public List<Usuario> buscarUsuariosPorUsername(String username){
        return dao.allByUsername(username);
    }
    
    @Override
    public List<Usuario> listarTodos(){
        return (List<Usuario>) dao.findAll();
    }
    
    @Override
    public Usuario findById(Long id){
        return dao.findOne(id);
    }
}
