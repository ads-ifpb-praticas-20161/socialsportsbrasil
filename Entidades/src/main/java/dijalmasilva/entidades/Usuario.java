/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author dijalma
 */
@Entity
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String sobrenome;
    @Column(unique = true)
    private String username;
    @Column(unique = true)
    private String email;
    private String senha;
    @Convert(converter = ConvertDate.class)
    private LocalDate dataDeNascimento;
    private String conta;
    @Basic(fetch = FetchType.LAZY)
    private byte[] foto;
    private int pontos;

    @OneToMany
    private List<Grupo> grupos;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Usuario> amigos;

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public Long getId() {
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

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public List<Usuario> getAmigos() {
        return amigos;
    }

    public void setAmigos(List<Usuario> amigos) {
        this.amigos = amigos;
    }

    public void addAmigo(Usuario u) {
        if (amigos == null) {
            amigos = new ArrayList<>();
        }
        this.amigos.add(u);
        this.pontos += 2;
        u.setPontos(u.getPontos()+5);
    }

    public void removeAmigo(Usuario u) {
        if (amigos != null) {
            this.amigos.remove(u);
        }
        this.pontos -= 2;
        u.setPontos(u.getPontos()-5);
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

    public List<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }

    public void addGrupo(Grupo g) {
        this.grupos.add(g);
    }

    public void removeGrupo(Grupo g) {
        this.grupos.remove(g);
    }

    public int qtdeSeguindo(){
        return this.amigos.size();
    }
    
    public int qtdeGrupos(){
        if (grupos == null){
            this.grupos = new ArrayList<>();
        }
        return this.grupos.size();
    }
    
    public boolean isFollowing(Long seguindo) {
        for (Usuario amigo : amigos) {
            if (Objects.equals(amigo.getId(), seguindo)) {
                return true;
            }
        }

        return false;
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", username=" + username + ", email=" + email + ", senha=" + senha + ", dataDeNascimento=" + dataDeNascimento + ", conta=" + conta + ", foto=" + foto + ", pontos=" + pontos + ", grupos=" + grupos + ", amigos=" + amigos + '}';
    }

}
