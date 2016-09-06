/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.entidades;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author dijalma
 */
@Entity
public class Grupo implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    private Usuario dono;
    @Column(unique = true)
    private String nome;
    @OneToOne(cascade = {CascadeType.PERSIST})
    private Idolo idolo;
    @Column(columnDefinition = "TEXT")
    private String descricao;

    @ManyToMany
    private List<Usuario> seguidores;

    public Grupo() {
    }

    public Grupo(Usuario dono, Idolo idolo) {
        this.dono = dono;
        this.idolo = idolo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getDono() {
        return dono;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDono(Usuario dono) {
        this.dono = dono;
    }

    public void setIdolo(Idolo idolo) {
        this.idolo = idolo;
    }

    public Idolo getIdolo() {
        return idolo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void addSeguidor(Usuario us) {
        this.seguidores.add(us);
    }

    public void removeSeguidor(Usuario us) {
        this.seguidores.remove(us);
    }

    public List<Usuario> getSeguidores() {
        return seguidores;
    }

    public void setSeguidores(List<Usuario> seguidores) {
        this.seguidores = seguidores;
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
        final Grupo other = (Grupo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.dono, other.dono)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Grupo{" + "id=" + id + ", dono=" + dono + ", nome=" + nome + ", idolo=" + idolo + ", descricao=" + descricao + '}';
    }

}
