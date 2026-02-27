package entities;

import exceptions.ExceptionEntity;
import interfaces.IConcreteElement;
import interfaces.IVisitor;

public class Rectangle implements IConcreteElement {
    private int largura;
    private int altura;

    public Rectangle(int largura, int altura) throws ExceptionEntity {
        if ( largura < 1 || altura < 1) throw new ExceptionEntity("Largura ou Altura inválidas");
        this.largura = largura;
        this.altura = altura;
    }

    public double aceitaVisita(IVisitor v) {
        return v.visitaRetangulo(this);
    }

    public int getLargura() {
        return largura;
    }

    public int getAltura() {
        return altura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
}
