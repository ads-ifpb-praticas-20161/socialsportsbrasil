/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.ssb.core.dao;

import dijalmasilva.ssb.entidades.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dijalma
 */
@Repository
public interface UsuarioDao extends CrudRepository<Usuario, Long>{
    
    public Usuario findByEmail(String email);
    
    public Usuario findByUsername (String username);
    
    @Query("Select * from Usuario where email ilike :email")
    public List<Usuario> allByEmail(@Param("email") String email);
    
    @Query("Select * from Usuario where username ilike :username")
    public List<Usuario> allByUsername(@Param("username") String username);
}
