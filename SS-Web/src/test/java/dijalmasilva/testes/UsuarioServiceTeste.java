/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.testes;

import dijalmasilva.core.service.UsuarioService;
import dijalmasilva.entidades.Usuario;
import java.time.LocalDate;
import java.util.List;
import javax.inject.Inject;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author dijalma
 */
@RunWith(SpringJUnit4ClassRunner.class)   // 1
@ContextConfiguration
public class UsuarioServiceTeste {

    private EmbeddedDatabaseBuilder builder;
    private EmbeddedDatabase db;
    
    @Before
    private void init(){
        this.builder = new EmbeddedDatabaseBuilder();
        this.db = builder.setType(EmbeddedDatabaseType.H2).addScript("db/schema.sql").addScript("db/test-data.sql").build();
    }
    
    @Inject
    private UsuarioService service;
    
    @After
    public void close(){
        db.shutdown();
        service = null;
    }
    
    @Test
    public void testLogin() {
        String emailOuUsername = "dijalma";
        String password = "manoeldj20";
        Usuario expResult = new Usuario();
        expResult.setEmail("dijalmacz@gmail.com");
        Usuario result = service.login(emailOuUsername, password);
        assertEquals(expResult.getEmail(), result.getEmail());
    }

    @Test
    public void testSalvarUsuario() {
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

    @Test
    public void testDesativarConta() {
        Long id = 3L;
        service.desativarConta(id);
        Usuario u = service.findById(id);
        assertEquals("DESATIVADA", u.getConta());
    }

    @Test
    public void testAtualizarPerfil() {
        Usuario u = service.findById(7L);
        u.setNome("Teste2000");
        Usuario result = service.atualizarPerfil(u);
        assertEquals(u.getNome(), result.getNome());
    }

    @Test
    public void testAdicionarAmigo() {
        Usuario result = service.seguirAmigo(3L, 4L);
        assertTrue(result.getAmigos().size() == 1);
    }

    @Test
    public void testRemoverAmigo() {
        Usuario result = service.deixarDeSeguirAmigo(3L, 4L);
        assertTrue(result.getAmigos().isEmpty());
    }

    @Test
    public void testBuscarUsuarios() {
        String nome = "dijalma";
        List<Usuario> result = service.buscarUsuarios(nome);
        assertTrue(result.size() == 1);
    }

    @Test
    public void testListarTodos() {
        List<Usuario> result = service.listarTodos();
        assertTrue(result.size() == 4);
    }

    @Test
    public void testFindById() {
        Long id = 3L;
        Usuario result = service.findById(id);
        assertEquals("Dijalma", result.getNome());
    }

}
