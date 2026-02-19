package entities;

import exceptions.ExceptionInstance;

public class Circle {
    private static Circle instance;
    private int raio;

    private Circle(int raio){
        this.raio = raio;
    }

    public static void reset() {
        instance = null;
    }

    public static Circle getInstance(int raio) throws ExceptionInstance {
        if (raio<1) throw new ExceptionInstance("Raio inválido");

        if (instance == null) {
            instance = new Circle(raio);
            return instance;

        } else {
            throw new ExceptionInstance("Já existe uma instância de Círculo");
        }
    }

    public int getRaio() {
        return raio;
    }

    @Override
    public String toString() {
        return "Círculo criado de raio: " + raio;
    }
}
