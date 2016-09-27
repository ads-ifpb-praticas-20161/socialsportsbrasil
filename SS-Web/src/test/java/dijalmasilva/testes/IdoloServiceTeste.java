/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.testes;

import dijalmasilva.Loader;
import dijalmasilva.core.service.IdoloService;
import dijalmasilva.entidades.Idolo;
import dijalmasilva.enums.Esporte;
import dijalmasilva.enums.TipoIdolo;
import java.util.ArrayList;
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
public class IdoloServiceTeste {

    @Inject
    private IdoloService service;
    

    @After
    public void close() {
        service = null;
    }

    @Test
    public void testeSalvarIdolo() {
        Idolo i = new Idolo();
        i.setEsporte(Esporte.FUTEBOL);
        i.setNome("Neymar");
        i.setTipo(TipoIdolo.JOGADOR);
        Idolo resultado = service.salvar(i);

        assertEquals(i.getNome(), resultado.getNome());
    }
    
    @Test
    public void testeBuscarIdolo(){
        Idolo i = service.buscar(12L);
        assertEquals("Neymar", i.getNome());
    }
    
    @Test
    public void testeAtualizarGrupo(){
        Idolo i = service.buscar(12L);
        i.setNome("NeymarFIL");
        Idolo novo = service.atualizar(i);
        
        assertEquals(i.getNome(), novo.getNome());
    }
}
