/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.core.repository;

import dijalmasilva.entidades.Idolo;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dijalma
 */
@Repository
public interface IdoloRepository extends CrudRepository<Idolo, Long>{
 
    List<Idolo> findByNomeContaining(String nome);
    
    Idolo findByNome(String nome);
}
