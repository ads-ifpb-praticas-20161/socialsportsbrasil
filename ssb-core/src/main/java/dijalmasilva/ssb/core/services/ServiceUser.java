/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.ssb.core.services;

import dijalmasilva.ssb.core.dao.UsuarioDao;
import dijalmasilva.ssb.entidades.Usuario;
import dijalmasilva.ssb.enums.Status;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author dijalma
 */
public class ServiceUser {
    
    @Inject
    private UsuarioDao dao;
    
    public Usuario loginEmail(String email){
        return dao.findByEmail(email);
    }
    
    public Usuario loginUsername(String username){
        return dao.findByUsername(username);
    }
    
    public Usuario salvarUsuario(Usuario u){
        return dao.save(u);
    }
    
    public void desativarConta(Long id){
        Usuario u = dao.findOne(id);
        u.setConta(Status.DESATIVADA);
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
}
