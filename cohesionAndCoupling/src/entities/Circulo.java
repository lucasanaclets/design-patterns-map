package entities;

import exceptions.FiguraException;
import interfaces.FigurasInterface;

public class Circulo implements FigurasInterface {
    private double raio;

    public Circulo(double raio) throws FiguraException {
        if (raio <= 0) {
            throw new FiguraException("Raio não pode ser negativo ou zero.");
        }
        this.raio = raio;
    }

    @Override
    public Double calcularArea() {
        return Math.PI * (Math.pow(raio, 2));
    }

    @Override
    public Double calcularPerimetro() {
        return 2 * Math.PI * this.raio;
    }

    @Override
    public String toString() {
        return "Círculo de raio " + raio;
    }
}