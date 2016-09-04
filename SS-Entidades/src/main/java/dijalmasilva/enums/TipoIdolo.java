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
public enum TipoIdolo {

    JOGADOR("Jogador"), ATLETA("Atleta"), GINASTA("Ginasta"), CORREDOR("Corredor"), PILOTO("Piloto"), TIME("Time"), TENISTA("Tenista"), EQUIPE("Equipe");
    
    private String tipo;

    private TipoIdolo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
