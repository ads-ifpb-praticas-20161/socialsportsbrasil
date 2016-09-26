/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.core.repository;

import dijalmasilva.entidades.Visita;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
@Repository
public interface VisitaRepository extends MongoRepository<Visita, Long>{
    
    public List<Visita> findDistinctByVisitadoAndData(Long visitado, LocalDate data);
}
