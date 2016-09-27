/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.entidades;

import dijalmasilva.enums.TipoResultado;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
@Entity
public class Evento implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Grupo grupo;

    private LocalDate dataDoEvento;
    private LocalDateTime horaInicio;
    private LocalDateTime horaFim;
    @Enumerated
    private List<TipoResultado> tiposDeResultados;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public LocalDate getDataDoEvento() {
        return dataDoEvento;
    }

    public void setDataDoEvento(LocalDate dataDoEvento) {
        this.dataDoEvento = dataDoEvento;
    }

    public LocalDateTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalDateTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalDateTime getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(LocalDateTime horaFim) {
        this.horaFim = horaFim;
    }

    public List<TipoResultado> getTiposDeResultados() {
        return tiposDeResultados;
    }

    public void setTiposDeResultados(List<TipoResultado> tiposDeResultados) {
        this.tiposDeResultados = tiposDeResultados;
    }

    public void addTipoDeResultado(TipoResultado tipo) {
        this.tiposDeResultados.add(tipo);
    }

    public void removeTipoDeResultado(TipoResultado tipo) {
        this.tiposDeResultados.remove(tipo);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Evento other = (Evento) obj;
        if (!Objects.equals(this.dataDoEvento, other.dataDoEvento)) {
            return false;
        }
        if (!Objects.equals(this.horaInicio, other.horaInicio)) {
            return false;
        }
        if (!Objects.equals(this.horaFim, other.horaFim)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Evento{" + "id=" + id + ", grupo=" + grupo + ", dataDoEvento=" + dataDoEvento + ", horaInicio=" + horaInicio + ", horaFim=" + horaFim + ", tiposDeResultados=" + tiposDeResultados + '}';
    }

}
