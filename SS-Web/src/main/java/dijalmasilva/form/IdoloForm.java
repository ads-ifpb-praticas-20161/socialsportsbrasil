/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.form;

import dijalmasilva.enums.Esporte;
import dijalmasilva.enums.TipoIdolo;

/**
 *
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
public class IdoloForm {

    private TipoIdolo tipo;
    private Esporte esporte;
    private String nome;

    public IdoloForm() {
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

}
