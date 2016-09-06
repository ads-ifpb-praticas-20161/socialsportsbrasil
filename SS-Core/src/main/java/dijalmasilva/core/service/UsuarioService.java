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
public interface UsuarioService {
    
    Usuario login(String emailOuUsername, String password);

    Usuario salvarUsuario(Usuario u);

    void desativarConta(Long id);

    Usuario atualizarPerfil(Usuario u);

    Usuario seguirAmigo(Long id, Long amigo);

    Usuario deixarDeSeguirAmigo(Long id, Long amigo);
    
    Usuario seguirGrupo(Usuario u, Grupo grupo);
    
    Usuario deixarDeSeguirGrupo(Usuario u, Grupo g);

    List<Usuario> buscarUsuarios(String nome);
    
    List<Usuario> listarTodos();

    Usuario findById(Long id);
    
    List<Usuario> buscarUsuariosComIdDiferenteAndNaoDesativada(String nome, Long id);
    
    boolean isFollow(Long id, Long seguindo);
}
