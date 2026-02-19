package entities;

import exceptions.ExceptionInstance;

public class Square {
    private int lado;

    private Square(int lado) {
        this.lado=lado;
    }

    public static Square getInstance(int lado) throws ExceptionInstance {
        if (lado < 1) throw new ExceptionInstance("Lado inválido");
        else return new Square(lado);
    }

    public int getLado() {
        return lado;
    }


    @Override
    public String toString() {
        return "Quadrado criado de lado: " + lado;
    }
}
