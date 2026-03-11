package controller;

import model.entities.Onibus;
import model.entities.StatusAssento;

public class GuicheController {

    private Onibus onibus;

    public GuicheController(Onibus onibus) {
        this.onibus = onibus;
    }

    public void reservarAssento(int numero) {

        System.out.println("\nCliente RESERVOU assento " + numero);

        onibus.alterarStatusAssento(numero, StatusAssento.RESERVADO);
    }

    public void comprarAssento(int numero) {

        System.out.println("\nCliente COMPROU assento " + numero);

        onibus.alterarStatusAssento(numero, StatusAssento.INDISPONIVEL);
    }

}