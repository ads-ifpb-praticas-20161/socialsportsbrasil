/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.core.service;

import dijalmasilva.entidades.Grupo;
import dijalmasilva.entidades.Usuario;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author dijalma
 */
@Service
public interface GrupoService {

    Grupo buscar(Long id);
    
    Grupo salvar(Usuario u, Grupo g);
    
    Grupo atualizar(Grupo g);
    
    void remover(Usuario u, Grupo g);
    
    void remover(Long id);
    
    List<Grupo> buscarPorNome(String nome);

}
