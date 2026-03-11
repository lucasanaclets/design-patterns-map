package model.entities;

public class Assento {

    private int numero;
    private StatusAssento status;

    public Assento(int numero) {
        this.numero = numero;
        this.status = StatusAssento.DISPONIVEL;
    }

    public int getNumero() {
        return numero;
    }

    public StatusAssento getStatus() {
        return status;
    }

    public void setStatus(StatusAssento status) {
        this.status = status;
    }
}
