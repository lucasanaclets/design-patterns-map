package entities;

import exceptions.ExceptionEntity;
import interfaces.IConcreteElement;
import interfaces.IVisitor;

public class Trapezoid implements IConcreteElement {
    private int baseMenor;
    private int baseMaior;
    private int altura;
    private int lado1;
    private int lado2;

    public Trapezoid(int baseMenor, int baseMaior, int altura, int lado1, int lado2) throws ExceptionEntity {

        if (baseMenor < 1 || baseMaior < 1 || altura < 1 || lado1 < 1 || lado2 < 1 ) {
            throw new ExceptionEntity("Medidas inválidas");
        }
        if (baseMenor == baseMaior) {
            throw new ExceptionEntity("Medidas formam trapézio inválido");
        }

        this.baseMenor = baseMenor;
        this.baseMaior = baseMaior;
        this.altura = altura;
        this.lado1=lado1;
        this.lado2=lado2;
    }

    public void aceitaVisita(IVisitor v) {
        v.visitaTrapezio(this);
    }

    public int getLado1() {
        return lado1;
    }

    public int getLado2() {
        return lado2;
    }

    public int getBaseMenor() {
        return baseMenor;
    }

    public int getBaseMaior() {
        return baseMaior;
    }

    public int getAltura() {
        return altura;
    }

    public void setBaseMenor(int baseMenor) {
        this.baseMenor = baseMenor;
    }

    public void setBaseMaior(int baseMaior) {
        this.baseMaior = baseMaior;
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
