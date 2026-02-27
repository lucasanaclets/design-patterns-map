package entities;

import exceptions.ExceptionEntity;
import interfaces.IConcreteElement;
import interfaces.IVisitor;

public class Triangle implements IConcreteElement {
    private int base;
    private int altura;
    private int lado1;
    private int lado2;

    public Triangle(int base, int altura, int lado1, int lado2) throws ExceptionEntity {
        if (base <= 0 || lado1 <= 0 || lado2 <= 0) {
            throw new ExceptionEntity("Lado do triãngulo inválido");
        }
        if (lado1 >= lado2 + base || lado2 >= lado1 + base || base >= lado1 + lado2) {
            throw new ExceptionEntity("Medidas fornecidas não formam um triângulo válido.");
        }

        this.base = base;
        this.altura = altura;
        this.lado1 = lado1;
        this.lado2 = lado2;
    }

    public double aceitaVisita(IVisitor v) {
       return v.visitaTriangulo(this);
    }

    public int getLado1() {
        return lado1;
    }

    public int getLado2() {
        return lado2;
    }

    public int getBase() {
        return base;
    }

    public int getAltura() {
        return altura;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public void setLado1(int lado1) {
        this.lado1 = lado1;
    }

    public void setLado2(int lado2) {
        this.lado2 = lado2;
    }
}
