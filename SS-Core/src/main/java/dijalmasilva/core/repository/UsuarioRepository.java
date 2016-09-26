/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.core.repository;

import dijalmasilva.entidades.Usuario;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dijalma
 */
@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{

    public Usuario findByEmail(String email);
    
    public Usuario findByUsername (String username);
    
    public List<Usuario> findByEmailContaining(String email);
    
    public List<Usuario> findByUsernameContaining(String username);
    
    public List<Usuario> findByNomeContainingAndIdNotAndContaNotLikeIgnoreCase(String nome, Long id, String conta);
    
    public List<Usuario> findBySobrenomeContainingAndIdNotAndContaNotLikeIgnoreCase(String sobrenome, Long id, String conta);
}
