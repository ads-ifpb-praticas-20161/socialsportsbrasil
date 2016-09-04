/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.entidades;

import dijalmasilva.enums.Esporte;
import dijalmasilva.enums.TipoIdolo;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author dijalma
 */
@Entity
public class Idolo implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    @Enumerated(EnumType.STRING)
    private TipoIdolo tipo;
    @Enumerated(EnumType.STRING)
    private Esporte esporte;
    @Column(unique = true)
    private String nome;
    @Basic(fetch = FetchType.LAZY)
    private byte[] foto;
    @OneToMany(mappedBy = "idolo", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Resultado> resultados;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoIdolo getTipo() {
        return tipo;
    }

    public void setTipo(TipoIdolo tipo) {
        this.tipo = tipo;
    }

    public Esporte getEsporte() {
        return esporte;
    }

    public void setEsporte(Esporte esporte) {
        this.esporte = esporte;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Resultado> getResultados() {
        return resultados;
    }

    public void setResultados(List<Resultado> resultados) {
        this.resultados = resultados;
    }

    public void addResultado(Resultado r) {
        this.resultados.add(r);
    }

    public void removeResultado(Resultado r) {
        this.resultados.remove(r);
    }
    
    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Idolo other = (Idolo) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Idolo{" + "id=" + id + ", tipo=" + tipo + ", esporte=" + esporte + ", nome=" + nome + ", resultados=" + resultados + '}';
    }

}
