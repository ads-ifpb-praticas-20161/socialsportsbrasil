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
import java.util.List;
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

    @Override
    public List<Grupo> buscarPorNome(String nome) {
        return (List<Grupo>) dao.findByNomeContaining(nome);
    }

    @Override
    public Usuario seguirGrupo(Long idGrupo, Usuario u) {
        Grupo group = dao.findOne(idGrupo);
        u.addGrupo(group);
        daoUsuario.save(group.getDono());
        
        return daoUsuario.save(u);
    }

    @Override
    public Usuario deixarDeSeguirGrupo(Long idGrupo, Usuario u) {
        Grupo group = dao.findOne(idGrupo);
        u.removeGrupo(group);
        daoUsuario.save(group.getDono());
        
        return daoUsuario.save(u);
    }
    
}
