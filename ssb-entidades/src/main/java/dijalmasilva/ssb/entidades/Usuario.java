/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.ssb.entidades;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author dijalma
 */
@Entity
public class Usuario implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String sobrenome;
    private String username;
    private String email;
    private String senha;
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    private String conta;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] foto;

    @ManyToMany
    private List<Usuario> amigos;

    public Usuario() {
    }

    public Usuario(String nome, String sobrenome, String username, String email, String senha, Date dataNascimento, String conta, byte[] foto) {
        this(nome, sobrenome, username, email, senha, dataNascimento, new ArrayList<>(), conta, foto);
    }

    public Usuario(String nome, String sobrenome, String username, String email, String senha, Date dataNascimento, List<Usuario> amigos, String conta, byte[] foto) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.username = username;
        this.email = email;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.amigos = amigos;
        this.conta = conta;
        this.foto = foto;
    }

    public Usuario(Long id, String nome, String sobrenome, String username, String email, String senha, Date dataNascimento, String conta, byte[] foto) {
        this(id, nome, sobrenome, username, email, senha, dataNascimento, new ArrayList<>(), conta, foto);
    }

    public Usuario(Long id, String nome, String sobrenome, String username, String email, String senha, Date dataNascimento, List<Usuario> amigos, String conta, byte[] foto) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.username = username;
        this.email = email;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.amigos = amigos;
        this.conta = conta;
        this.foto = foto;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<Usuario> getAmigos() {
        return amigos;
    }

    public void setAmigos(List<Usuario> amigos) {
        this.amigos = amigos;
    }

    public void addAmigo(Usuario u) {
        this.amigos.add(u);
    }

    public void removeAmigo(Usuario u) {
        this.amigos.remove(u);
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
}
