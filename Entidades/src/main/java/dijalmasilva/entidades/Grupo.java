/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
    @Basic(fetch = FetchType.LAZY)
    private byte[] foto;
    
    public Grupo(){
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

    public Idolo getIdolo() {
        return idolo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

}
