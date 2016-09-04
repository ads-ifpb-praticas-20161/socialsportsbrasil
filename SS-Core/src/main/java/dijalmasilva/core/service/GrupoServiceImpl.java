/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.core.service;

import dijalmasilva.core.repository.GrupoRepository;
import dijalmasilva.core.repository.UsuarioRepository;
import dijalmasilva.entidades.Grupo;
import dijalmasilva.entidades.Usuario;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class GrupoServiceImpl implements GrupoService {

    @Inject
    private GrupoRepository dao;
    @Inject 
    private UsuarioRepository daoUsuario;
    
    @Override
    public Grupo salvar(Usuario u, Grupo g) {
        g.setDono(u);
        Grupo grupo = dao.save(g);
        u.addGrupo(grupo);
        daoUsuario.save(u);
        
        return grupo;
    }

    @Override
    public Grupo atualizar(Grupo g) {
        return dao.save(g);
    }

    @Override
    public void remover(Usuario u, Grupo g) {
        u.removeGrupo(g);
        daoUsuario.save(u);
        dao.delete(g);
    }

    @Override
    public void remover(Long id) {
        dao.delete(id);
    }

    @Override
    public Grupo buscar(Long id) {
        return dao.findOne(id);
    }
    
}
