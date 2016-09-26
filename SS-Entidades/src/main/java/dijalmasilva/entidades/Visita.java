/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.entidades;

import java.time.LocalDate;
import org.springframework.data.annotation.Id;

/**
 *
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
public class Visita {

    @Id
    private String id;

    private Long visitante;
    private Long visitado;
    private LocalDate data;

    public Visita() {

    }

    public Visita(Long visitante, Long visitado, LocalDate data) {
        this.visitante = visitante;
        this.visitado = visitado;
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Long getVisitante() {
        return visitante;
    }

    public void setVisitante(Long visitante) {
        this.visitante = visitante;
    }

    public Long getVisitado() {
        return visitado;
    }

    public void setVisitado(Long visitado) {
        this.visitado = visitado;
    }

}
