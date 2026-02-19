package entities;

import enums.TypeTriangle;
import exceptions.ExceptionInstance;

public class Triangle {

    private static Triangle isosceles = null;
    private static Triangle equilatero = null;
    private static Triangle retangulo = null;

    private TypeTriangle tipo;

    private Triangle(TypeTriangle tipo) {
        this.tipo = tipo;
    }

    public static void reset() {
        retangulo = null;
        isosceles = null;
        equilatero = null;
    }

    public static Triangle getInstance(TypeTriangle tipo) throws ExceptionInstance {

        if (tipo == TypeTriangle.RETANGULO) {

            if (retangulo == null) {
                retangulo = new Triangle(tipo);
                return retangulo;
            } else {
                throw new ExceptionInstance("Já existe uma instância de Triângulo Retângulo");
            }

        } else if (tipo == TypeTriangle.ISOSCELES) {

            if (isosceles == null) {
                isosceles = new Triangle(tipo);
                return isosceles;
            } else {
                throw new ExceptionInstance("Já existe uma instância de Triângulo Isósceles");
            }

        } else if (tipo == TypeTriangle.EQUILATERO) {

            if (equilatero == null) {
                equilatero = new Triangle(tipo);
                return equilatero;
            } else {
                throw new ExceptionInstance("Já existe uma instância de Triângulo Equilátero");
            }

        } else {
            throw new ExceptionInstance("Tipo inválido de instância");
        }
    }

    @Override
    public String toString() {
        return "Triângulo do tipo " + this.tipo + " criado";
    }
}