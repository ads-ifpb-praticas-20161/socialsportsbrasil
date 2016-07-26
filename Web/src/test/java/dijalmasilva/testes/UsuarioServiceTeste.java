/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.testes;

import dijalmasilva.Loader;
import dijalmasilva.core.service.UsuarioService;
import dijalmasilva.entidades.Usuario;
import java.time.LocalDate;
import java.util.List;
import javax.inject.Inject;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 *
 * @author dijalma
 */
@RunWith(SpringJUnit4ClassRunner.class)   // 1
@SpringApplicationConfiguration(classes = Loader.class)   // 2
@WebAppConfiguration   // 3
@IntegrationTest("server.port:0") 
public class UsuarioServiceTeste {

    @Inject
    private UsuarioService service;
    
    @After
    public void close(){
        service = null;
    }
    
//    @Test
    public void testLogin() {
        System.out.println("login");
        String emailOuUsername = "dijalma";
        String password = "manoeldj20";
        Usuario expResult = new Usuario();
        expResult.setEmail("dijalmacz@gmail.com");
        Usuario result = service.login(emailOuUsername, password);
        assertEquals(expResult.getEmail(), result.getEmail());
    }

    @Test
    public void testSalvarUsuario() {
        System.out.println("salvarUsuario");
        Usuario u = new Usuario();
        u.setConta("ATIVADA");
        u.setEmail("teste@gmail.com");
        u.setUsername("teste");
        u.setFoto(null);
        u.setDataDeNascimento(LocalDate.now());
        u.setNome("Teste");
        u.setSenha("teste");
        u.setSobrenome("Salvar");
        Usuario expResult = u;
        Usuario result = service.salvarUsuario(u);
        assertEquals(expResult.getEmail(), result.getEmail());
    }

//    @Test
    public void testDesativarConta() {
        System.out.println("desativarConta");
        Long id = 3L;
        service.desativarConta(id);
        Usuario u = service.findById(id);
        assertEquals("DESATIVADA", u.getConta());
    }

//    @Test
    public void testAtualizarPerfil() {
        System.out.println("atualizarPerfil");
        Usuario u = service.findById(7L);
        u.setNome("Teste2000");
        Usuario result = service.atualizarPerfil(u);
        assertEquals(u.getNome(), result.getNome());
    }

//    @Test
    public void testAdicionarAmigo() {
        System.out.println("adicionarAmigo");
        
        Usuario result = service.adicionarAmigo(3L, 4L);
        assertTrue(result.getAmigos().size() == 1);
    }

//    @Test
    public void testRemoverAmigo() {
        System.out.println("removerAmigo");
        
        Usuario result = service.removerAmigo(3L, 4L);
        assertTrue(result.getAmigos().isEmpty());
    }

//    @Test
    public void testBuscarUsuarios() {
        System.out.println("buscarUsuarios");
        String nome = "dijalma";
        List<Usuario> result = service.buscarUsuarios(nome);
        assertTrue(result.size() == 1);
    }

//    @Test
    public void testListarTodos() {
        System.out.println("listarTodos");
        List<Usuario> result = service.listarTodos();
        assertTrue(result.size() == 4);
    }

//    @Test
    public void testFindById() {
        System.out.println("findById");
        Long id = 3L;
        Usuario result = service.findById(id);
        assertEquals("Dijalma", result.getNome());
    }

}
