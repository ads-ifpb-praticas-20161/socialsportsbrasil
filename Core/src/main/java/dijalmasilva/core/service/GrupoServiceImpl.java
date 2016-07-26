/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.core.service;

import dijalmasilva.core.repository.GrupoRepository;
import dijalmasilva.entidades.Grupo;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class GrupoServiceImpl implements GrupoService {

    @Inject
    private GrupoRepository dao;
    
    @Override
    public Grupo salvar(Grupo g) {
        return dao.save(g);
    }

    @Override
    public Grupo atualizar(Grupo g) {
        return dao.save(g);
    }

    @Override
    public void remover(Grupo g) {
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
