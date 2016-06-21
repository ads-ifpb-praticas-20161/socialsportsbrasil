/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.ssb.core.services;

import dijalmasilva.ssb.entidades.Usuario;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author dijalma
 */
@Service
public interface ServiceUser {

    public Usuario loginEmail(String email, String password);

    public Usuario loginUsername(String username, String password);

    public Usuario salvarUsuario(Usuario u);

    public void desativarConta(Long id);

    public Usuario atualizarPerfil(Usuario u);

    public Usuario adicionarAmigo(Long id, Long amigo);

    public Usuario removerAmigo(Long id, Long amigo);

    public List<Usuario> buscarUsuariosPorEmail(String email);

    public List<Usuario> buscarUsuariosPorUsername(String username);

    public List<Usuario> listarTodos();

    public Usuario findById(Long id);
}
