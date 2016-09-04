/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.core.service;

import dijalmasilva.entidades.Resultado;
import org.springframework.stereotype.Service;

/**
 *
 * @author dijalma
 */
@Service
public interface ResultadoService {
    
    Resultado salvar(Resultado r);
    
    Resultado atualizar(Resultado r);
    
    void remover(Resultado r);
    
    void remover(Long id);
}
