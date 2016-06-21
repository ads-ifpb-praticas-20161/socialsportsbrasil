/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.ssb.web.forms;

import java.util.Date;

/**
 *
 * @author dijalma
 */
public class UsuarioForm{

    private Long id;
    private String nome;
    private String sobrenome;
    private String username;
    private String email;
    private String senha;
    private Date dataNascimento;

    private String conta;
    private byte[] foto;

    public UsuarioForm() {
    }

    public UsuarioForm(String nome, String sobrenome, String username, String email, String senha, Date dataNascimento, String conta, byte[] foto) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.username = username;
        this.email = email;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.conta = conta;
        this.foto = foto;
    }

    public UsuarioForm(Long id, String nome, String sobrenome, String username, String email, String senha, Date dataNascimento, int idade, String conta, byte[] foto) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.username = username;
        this.email = email;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
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
