/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.core.service;

import dijalmasilva.entidades.Evento;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
@Service
public interface EventoService {
    
    Evento save(Evento e);
    
    Evento update(Evento e);
    
    void remove(Evento e);
    
    void remove(Long id);
    
    Evento findById(Long id);
    
    List<Evento> all();
    
    List<Evento> findByIdOfGroup(Long id_grupo);
}
