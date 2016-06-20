/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.ssb.entidades;

import dijalmasilva.ssb.enums.Status;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

/**
 *
 * @author dijalma
 */
@Entity
public class Usuario implements Serializable{
    
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String sobrenome;
    private String username;
    private String email;
    private String senha;
    private LocalDate dataNascimento;
    @Transient
    private int idade;
    @Enumerated(EnumType.STRING)
    private Status conta;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] foto;
    
    @ManyToMany
    private List<Usuario> amigos;

    public Usuario() {
    }

    public Usuario(String nome, String sobrenome, String username, String email, String senha, LocalDate dataNascimento, int idade, Status conta, byte[] foto) {
        this(nome, sobrenome, username, email, senha, dataNascimento, idade, new ArrayList<>(), conta, foto);
    }

    public Usuario(String nome, String sobrenome, String username, String email, String senha, LocalDate dataNascimento, int idade, List<Usuario> amigos, Status conta, byte[] foto) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.username = username;
        this.email = email;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.idade = idade;
        this.amigos = amigos;
        this.conta = conta;
        this.foto = foto;
    }

    public Usuario(Long id, String nome, String sobrenome, String username, String email, String senha, LocalDate dataNascimento, int idade, Status conta, byte[] foto) {
        this(id, nome, sobrenome, username, email, senha, dataNascimento, idade, new ArrayList<>(), conta, foto);
    }

    public Usuario(Long id, String nome, String sobrenome, String username, String email, String senha, LocalDate dataNascimento, int idade, List<Usuario> amigos, Status conta, byte[] foto) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.username = username;
        this.email = email;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.idade = idade;
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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public List<Usuario> getAmigos() {
        return amigos;
    }

    public void setAmigos(List<Usuario> amigos) {
        this.amigos = amigos;
    }
    
    public void addAmigo(Usuario u){
        this.amigos.add(u);
    }
    
    public void removeAmigo(Usuario u){
        this.amigos.remove(u);
    }

    public Status getConta() {
        return conta;
    }

    public void setConta(Status conta) {
        this.conta = conta;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
}
