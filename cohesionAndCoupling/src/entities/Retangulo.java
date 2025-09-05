package entities;

import exceptions.FiguraException;
import interfaces.FigurasInterface;

public class Retangulo implements FigurasInterface {
    private double altura;
    private double largura;

    public Retangulo(double altura, double largura) throws FiguraException {
        if (altura <= 0 || largura <= 0) {
            throw new FiguraException("Altura e largura do Retangulo devem ser maiores que zero.");
        }
        this.altura = altura;
        this.largura = largura;
    }

    @Override
    public Double calcularArea() {
        return this.altura * this.largura;
    }

    @Override
    public Double calcularPerimetro() {
        return 2 * (this.altura + this.largura);
    }

    @Override
    public String toString() {
        return "Retângulo de altura " + altura + " e largura " + largura;
    }
}