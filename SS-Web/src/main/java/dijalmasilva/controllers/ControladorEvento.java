/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.controllers;

import dijalmasilva.core.service.EventoService;
import dijalmasilva.core.service.GrupoService;
import dijalmasilva.entidades.Evento;
import dijalmasilva.entidades.Grupo;
import dijalmasilva.enums.TipoIdolo;
import dijalmasilva.enums.TipoResultado;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
@Controller
@RequestMapping("/event")
public class ControladorEvento {

    @Inject
    private EventoService service;
    @Inject
    private GrupoService grupoService;

    @RequestMapping(method = RequestMethod.POST)
    public String save(Long id_group, Date data, HttpServletRequest req, String descricao) {
        LocalDate dataEvento = data.toLocalDate();
        Grupo grupo = grupoService.buscar(id_group);
        List<TipoResultado> resultados = retornaPossíveisResultados(grupo.getIdolo().getTipo());
        Evento e = new Evento();
        e.setDataDoEvento(dataEvento);
        e.setGrupo(grupo);
        e.setDescricao(descricao);
        e.setTiposDeResultados(resultados);
        Evento eve = service.save(e);

        if (eve != null) {
            req.setAttribute("result", "Evento cadastrado com sucesso!");
        } else {
            req.setAttribute("result", "Erro ao cadastrar evento");
        }

        List<Evento> eventos = service.findByIdOfGroup(grupo.getId());
        req.setAttribute("eventos", eventos);
        req.setAttribute("group", grupo);

        return "otherGroup";
    }

    private List<TipoResultado> retornaPossíveisResultados(TipoIdolo tipo) {
        List<TipoResultado> resultados = new ArrayList<TipoResultado>();
        switch (tipo) {
            case ATLETA: {
                resultados.add(TipoResultado.MEDALHA_DE_BRONZE);
                resultados.add(TipoResultado.MEDALHA_DE_PRATA);
                resultados.add(TipoResultado.MEDALHA_DE_OURO);
            }
            break;
            case EQUIPE: {
                resultados.add(TipoResultado.TERCEIRO);
                resultados.add(TipoResultado.SEGUNDO);
                resultados.add(TipoResultado.PRIMEIRO);
            }
            break;
            case CORREDOR: {
                resultados.add(TipoResultado.TERCEIRO);
                resultados.add(TipoResultado.SEGUNDO);
                resultados.add(TipoResultado.PRIMEIRO);
            }
            break;
            case GINASTA: {
                resultados.add(TipoResultado.MEDALHA_DE_BRONZE);
                resultados.add(TipoResultado.MEDALHA_DE_PRATA);
                resultados.add(TipoResultado.MEDALHA_DE_OURO);
            }
            break;
            case JOGADOR: {
                resultados.add(TipoResultado.VITORIA);
                resultados.add(TipoResultado.EMPATE);
                resultados.add(TipoResultado.DERROTA);
            }
            break;
            case PILOTO: {
                resultados.add(TipoResultado.TERCEIRO);
                resultados.add(TipoResultado.SEGUNDO);
                resultados.add(TipoResultado.PRIMEIRO);
            }
            break;
            case TENISTA: {
                resultados.add(TipoResultado.VITORIA);
                resultados.add(TipoResultado.DERROTA);
            }
            break;
            case TIME: {
                resultados.add(TipoResultado.VITORIA);
                resultados.add(TipoResultado.EMPATE);
                resultados.add(TipoResultado.DERROTA);
            }
            break;
            default: {
                resultados.add(TipoResultado.TERCEIRO);
                resultados.add(TipoResultado.SEGUNDO);
                resultados.add(TipoResultado.PRIMEIRO);
                resultados.add(TipoResultado.VITORIA);
                resultados.add(TipoResultado.EMPATE);
                resultados.add(TipoResultado.DERROTA);
                resultados.add(TipoResultado.MEDALHA_DE_BRONZE);
                resultados.add(TipoResultado.MEDALHA_DE_PRATA);
                resultados.add(TipoResultado.MEDALHA_DE_OURO);
            }
        }

        return resultados;
    }
}
