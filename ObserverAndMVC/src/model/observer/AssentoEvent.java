package model.observer;

import model.entities.Assento;

public class AssentoEvent {

    private Assento assento;

    public AssentoEvent(Assento assento) {
        this.assento = assento;
    }

    public Assento getAssento() {
        return assento;
    }

}
