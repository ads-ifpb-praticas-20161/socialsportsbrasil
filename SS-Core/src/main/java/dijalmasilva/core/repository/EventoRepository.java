/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.core.repository;

import dijalmasilva.entidades.Evento;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
@Repository
public interface EventoRepository extends CrudRepository<Evento, Long>{
    
    @Query("SELECT e FROM Evento e WHERE e.grupo.id = :id_grupo")
    List<Evento> findByIdOfGroup (@Param("id_grupo") Long id_grupo);
}
