/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.core.service;

import dijalmasilva.core.repository.ResultadoRepository;
import dijalmasilva.entidades.Resultado;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class ResultadoServiceImpl implements ResultadoService {

    @Inject
    private ResultadoRepository dao;
    
    @Override
    public Resultado salvar(Resultado r) {
        return dao.save(r);
    }

    @Override
    public Resultado atualizar(Resultado r) {
        return dao.save(r);
    }

    @Override
    public void remover(Resultado r) {
        dao.delete(r);
    }

    @Override
    public void remover(Long id) {
        dao.delete(id);
    }
    
}
