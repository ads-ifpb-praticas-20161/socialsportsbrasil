/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.core.service;

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

    Usuario adicionarAmigo(Long id, Long amigo);

    Usuario removerAmigo(Long id, Long amigo);

    List<Usuario> buscarUsuarios(String nome);
    
    List<Usuario> listarTodos();

    Usuario findById(Long id);
    
    List<Usuario> buscarUsuariosComIdDiferente(String nome, Long id);
}
