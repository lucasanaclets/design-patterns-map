package view;

import model.entities.Assento;
import model.observer.AssentoEvent;
import model.observer.AssentoListener;

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
