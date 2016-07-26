/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.form;

/**
 *
 * @author dijalma
 */
public class UsuarioForm {

    private String nome;
    private String sobrenome;
    private String username;
    private String email;
    private String senha;
    private String conta;

    public UsuarioForm() {
    }

    public UsuarioForm(String nome, String sobrenome, String username, String email, String senha) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.username = username;
        this.email = email;
        this.senha = senha;
        this.conta = "ATIVADA";
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

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
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
        final UsuarioForm other = (UsuarioForm) obj;
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        if ((this.sobrenome == null) ? (other.sobrenome != null) : !this.sobrenome.equals(other.sobrenome)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UsuarioForm{" + "nome=" + nome + ", sobrenome=" + sobrenome + ", username=" + username + ", email=" + email + ", senha=" + senha + ", conta=" + conta + '}';
    }

}
