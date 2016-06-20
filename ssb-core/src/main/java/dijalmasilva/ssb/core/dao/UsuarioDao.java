/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.ssb.core.dao;

import dijalmasilva.ssb.entidades.Usuario;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author dijalma
 */
public interface UsuarioDao extends CrudRepository<Usuario, Long>{
    
}
