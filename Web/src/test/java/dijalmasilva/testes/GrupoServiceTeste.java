/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.testes;

import dijalmasilva.Loader;
import dijalmasilva.core.service.GrupoService;
import dijalmasilva.core.service.UsuarioService;
import dijalmasilva.entidades.Grupo;
import dijalmasilva.entidades.Idolo;
import dijalmasilva.entidades.Resultado;
import dijalmasilva.entidades.Usuario;
import dijalmasilva.enums.Esporte;
import dijalmasilva.enums.TipoIdolo;
import java.time.LocalDate;
import java.util.ArrayList;
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
public class GrupoServiceTeste {

    @Inject
    private GrupoService service;
    @Inject
    private UsuarioService serviceUsuario;

    @After
    public void close() {
        service = null;
    }

//    @Test
    public void testeSalvarGrupo() {
        Usuario dono = serviceUsuario.findById(9L);
        Idolo idolo = new Idolo();
        idolo.setEsporte(Esporte.BASQUETE);
        idolo.setTipo(TipoIdolo.JOGADOR);
        idolo.setNome("Michael Jordan");
        idolo.setResultados(new ArrayList<Resultado>());
        Grupo esperado = new Grupo(dono, idolo);
        esperado.setNome("O basquete de Jordan");
        esperado.setDescricao("OIjasdoijasodijaosdjioasjdoiasjdoijasdoijasoidjsaoi");
        Grupo resultado = service.salvar(esperado);

        assertEquals(esperado.getNome(), resultado.getNome());
    }
    
//    @Test
    public void testeBuscarGrupo(){
        Grupo result = service.buscar(10L);
        assertEquals("O basquete de Jordan", result.getNome());
    }
    
//    @Test
    public void testeAtualizarGrupo(){
        Grupo esperado = service.buscar(10L);
        esperado.setDescricao("Novo basquete Brasil");
        Grupo resultado = service.salvar(esperado);
        
        assertEquals(esperado.getDescricao(), resultado.getDescricao());
    }
}
