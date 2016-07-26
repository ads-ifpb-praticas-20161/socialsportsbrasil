/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.core.service;

import dijalmasilva.entidades.Idolo;
import org.springframework.stereotype.Service;

/**
 *
 * @author dijalma
 */
@Service
public interface IdoloService {
    
    Idolo salvar(Idolo i);
    
    Idolo atualizar(Idolo i);
    
    void remover(Idolo i);
    
    void remover(Long id);
    
    Idolo buscar(Long id);
}
