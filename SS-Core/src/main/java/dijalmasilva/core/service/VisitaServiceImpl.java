/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.core.service;

import dijalmasilva.core.repository.VisitaRepository;
import dijalmasilva.entidades.Visita;
import java.time.LocalDate;
import java.util.List;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Named
public class VisitaServiceImpl implements VisitaService {

    @Autowired
    private VisitaRepository dao;

    @Override
    public List<Visita> visitasDeHoje(Long id) {
        return dao.findDistinctByVisitadoAndData(id, LocalDate.now());
    }

    @Override
    public void visitou(Long visitante, Long visitado) {
        Visita v = new Visita(visitante, visitado, LocalDate.now());
        dao.save(v);
    }

}
