package view;

import model.entities.Assento;
import model.event.AssentoEvent;
import model.event.AssentoListener;

public class Quiosque implements AssentoListener {

    private String nome;

    public Quiosque(String nome) {
        this.nome = nome;
    }

    @Override
    public void atualizarAssento(AssentoEvent event) {

        Assento assento = event.getAssento();

        System.out.println("QUIOSQUE " + nome
                + " -> Assento "
                + assento.getNumero()
                + " está "
                + assento.getStatus());
    }
}
