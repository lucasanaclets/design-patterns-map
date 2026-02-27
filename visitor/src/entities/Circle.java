package entities;

import exceptions.ExceptionEntity;
import interfaces.IConcreteElement;
import interfaces.IVisitor;

public class Circle implements IConcreteElement {

    private double raio;

    public Circle(double r) throws ExceptionEntity {
        if (r < 1) throw new ExceptionEntity("Raio inválido");
        this.raio = r;
    }

    public double aceitaVisita(IVisitor v) {
        return v.visitaCirculo(this);
    }

    public double getRaio() {
        return this.raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }
}