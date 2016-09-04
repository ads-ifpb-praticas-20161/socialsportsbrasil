/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.entidades;

import dijalmasilva.enums.TipoResultado;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author dijalma
 */
@Entity
public class Resultado implements Serializable {

    @ManyToOne
    private Idolo idolo;

    @Id
    private Long id;
    @Enumerated(EnumType.STRING)
    private TipoResultado tipoDoResultado;
    @Convert(converter = ConvertDate.class)
    private LocalDate dataDoResultado;

    public Resultado() {
    }
    
    public Resultado(Idolo idolo) {
        this.idolo = idolo;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoResultado getTipoDoResultado() {
        return tipoDoResultado;
    }

    public void setTipoDoResultado(TipoResultado tipoDoResultado) {
        this.tipoDoResultado = tipoDoResultado;
    }

    public LocalDate getDataDoResultado() {
        return dataDoResultado;
    }

    public void setDataDoResultado(LocalDate dataDoResultado) {
        this.dataDoResultado = dataDoResultado;
    }

    public Idolo getIdolo() {
        return idolo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Resultado other = (Resultado) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (this.tipoDoResultado != other.tipoDoResultado) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Resultados{" + "id=" + id + ", tipoDoResultado=" + tipoDoResultado + ", dataDoResultado=" + dataDoResultado + '}';
    }

}
