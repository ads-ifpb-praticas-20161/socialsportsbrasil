/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dijalmasilva.core.service;

import dijalmasilva.core.repository.EventoRepository;
import dijalmasilva.entidades.Evento;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class EventoServiceImpl implements EventoService {

    @Inject
    private EventoRepository dao;
    
    @Override
    public Evento save(Evento e) {
        return dao.save(e);
    }

    @Override
    public Evento update(Evento e) {
        return dao.save(e);
    }

    @Override
    public void remove(Evento e) {
        dao.delete(e);
    }

    @Override
    public void remove(Long id) {
        dao.delete(id);
    }

    @Override
    public Evento findById(Long id) {
        return dao.findOne(id);
    }

    @Override
    public List<Evento> all() {
        return (List<Evento>) dao.findAll();
    }

    @Override
    public List<Evento> findByIdOfGroup(Long id_grupo) {
        return dao.findByIdOfGroup(id_grupo);
    }

}
