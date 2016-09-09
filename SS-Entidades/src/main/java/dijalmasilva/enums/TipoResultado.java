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
public enum TipoResultado {

    VITORIA("Vitória"), DERROTA("Derrota"), EMPATE("Empate"), MEDALHA_DE_OURO("Medalha de ouro"), MEDALHA_DE_PRATA("Medalha de prata"), 
    MEDALHA_DE_BRONZE("Medalha de Bronze"), PRIMEIRO("Primeiro"), SEGUNDO ("Segundo"), TERCEIRO("Terceiro");

    private final String nome;

    private TipoResultado(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

}
