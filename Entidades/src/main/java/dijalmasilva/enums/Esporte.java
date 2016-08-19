/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.enums;

/**
 *
 * @author dijalma
 */
public enum Esporte {

    FUTEBOL("Futebol"), NATACAO("Natação"), BASQUETE("Basquete"), VOLEI("Vôlei"), TENIS("Tênis"), HANDEBOL("Handebol"), BOXE("Boxe"), CORRIDA("Corrida"), GINASTICA("Ginástica"), ATLETISMO("Atletismo");

    private String tipo;

    private Esporte(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
