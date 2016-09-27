/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.testes;

import dijalmasilva.Loader;
import dijalmasilva.core.repository.GrupoRepository;
import dijalmasilva.core.repository.IdoloRepository;
import dijalmasilva.core.repository.UsuarioRepository;
import dijalmasilva.entidades.Grupo;
import dijalmasilva.entidades.Idolo;
import dijalmasilva.entidades.Usuario;
import dijalmasilva.enums.Esporte;
import dijalmasilva.enums.TipoIdolo;
import java.time.LocalDate;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author dijalma
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@SpringApplicationConfiguration(Loader.class)
@DataJpaTest
public class GrupoServiceTeste {

    @Autowired
    private TestEntityManager em;
    
    @Autowired
    private GrupoRepository groupRepository;
    @Autowired
    private UsuarioRepository userRepository;
    @Autowired
    private IdoloRepository idoloRepository;
    

    @Before
    public void init(){
        Usuario u = new Usuario();
        u.setAmigos(null);
        u.setConta("ATIVADA");
        u.setDataDeNascimento(LocalDate.now());
        u.setEmail("teste@gmail.com");
        u.setNome("teste");
        u.setSobrenome("sobreteste");
        u.setSenha("123");
        u.setGrupos(null);
        u.setPontos(0);
        u.setFoto(null);
        Idolo i = new Idolo();
        i.setEsporte(Esporte.BASQUETE);
        i.setFoto(null);
        i.setNome("Michael Jordan");
        i.setTipo(TipoIdolo.JOGADOR);
        Usuario us = em.persist(u);
        Idolo ido = em.persist(i);
    }
    

    @Test
    public void testeSalvarGrupo() {
        Usuario dono = userRepository.findByEmail("teste@gmail.com");
        Idolo idolo = idoloRepository.findByNome("Michael Jordan");
        Grupo esperado = new Grupo();
        esperado.setDescricao("Teste grupo");
        esperado.setDono(dono);
        esperado.setIdolo(idolo);
        esperado.setNome("O basquete de Jordan");
        esperado.setDescricao("OIjasdoijasodijaosdjioasjdoiasjdoijasdoijasoidjsaoi");
        Grupo resultado = em.persist(esperado);

        assertEquals(esperado.getNome(), resultado.getNome());
    }
    
    @Test
    public void testeBuscarGrupo(){
        Usuario dono = userRepository.findByEmail("teste@gmail.com");
        Idolo idolo = idoloRepository.findByNome("Michael Jordan");
        Grupo esperado = new Grupo();
        esperado.setDescricao("Grupo 2");
        esperado.setDono(dono);
        esperado.setIdolo(idolo);
        esperado.setNome("Grupo 2 teste");
        esperado.setDescricao("OIjasdoijasodijaosdjioasjdoiasjdoijasdoijasoidjsaoi");
        em.persist(esperado);
        Grupo result = groupRepository.findByNomeContaining("Grupo 2 teste").get(0);
        assertEquals("Grupo 2 teste", result.getNome());
    }
    
    @Test
    public void testeAtualizarGrupo(){
        Usuario dono = userRepository.findByEmail("teste@gmail.com");
        Idolo idolo = idoloRepository.findByNome("Michael Jordan");
        Grupo esperado = new Grupo();
        esperado.setDescricao("Grupo 3");
        esperado.setDono(dono);
        esperado.setIdolo(idolo);
        esperado.setNome("Grupo 3 teste");
        esperado.setDescricao("OIjasdoijasodijaosdjioasjdoiasjdoijasdoijasoidjsaoi");
        Grupo gg = em.persist(esperado);
        gg.setNome("Teste atualizado");
        Grupo save = groupRepository.save(gg);
        assertEquals("Teste atualizado", save.getNome());
    }
}
