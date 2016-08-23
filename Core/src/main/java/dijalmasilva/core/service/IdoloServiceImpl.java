/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.core.service;

import dijalmasilva.core.repository.IdoloRepository;
import dijalmasilva.entidades.Idolo;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class IdoloServiceImpl implements IdoloService {

    @Inject
    private IdoloRepository dao;
    
    @Override
    public Idolo salvar(Idolo i) {
        return dao.save(i);
    }

    @Override
    public Idolo atualizar(Idolo i) {
        return dao.save(i);
    }

    @Override
    public void remover(Idolo i) {
        dao.delete(i);
    }

    @Override
    public void remover(Long id) {
        dao.delete(id);
    }

    @Override
    public Idolo buscar(Long id) {
        return dao.findOne(id);
    }

    @Override
    public List<Idolo> buscarPorNome(String nome) {
        return dao.findByNomeContaining(nome);
    }
    
}
