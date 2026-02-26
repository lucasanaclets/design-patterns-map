package entities;

import exceptions.ExceptionEntity;
import interfaces.IElementoConcreto;
import interfaces.IVisitor;

public class Rectangle implements IElementoConcreto {
    private int largura;
    private int altura;

    public Rectangle(int largura, int altura) throws ExceptionEntity {
        if ( largura < 1 || altura < 1) throw new ExceptionEntity("Largura ou Altura inválidas");
        this.largura = largura;
        this.altura = altura;
    }

    public void aceitaVisita(IVisitor v) {
        v.visitaRetangulo(this);
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
