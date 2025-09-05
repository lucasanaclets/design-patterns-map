package app;

import entities.FigurasGeometricas;
import exceptions.FiguraException;

public class BrincandoComAsFigurasGeometricas {

    public static void main(String[] args) {
        try {
            FigurasGeometricas fig = FigurasGeometricas.criarFiguras(10, 5, 7, 25);

            System.out.println("< Perimetro de todas as figuras >");
            System.out.println(fig.getTodosPerimetros());

            System.out.println("Area do Retangulo: " + fig.areaDaFigura(FigurasGeometricas.tiposDeFigura.RETANGULO));
            System.out.println("Area do Quadrado: " + fig.areaDaFigura(FigurasGeometricas.tiposDeFigura.QUADRADO));
            System.out.println("Area do Circulo: " + fig.areaDaFigura(FigurasGeometricas.tiposDeFigura.CIRCULO) + "\n");

            System.out.println("< Area de todas as figuras >");
            System.out.println(fig.areaDaFigura(FigurasGeometricas.tiposDeFigura.TODOS));

            System.out.println("Figura 1: " + fig.toStringDaFigura(FigurasGeometricas.tiposDeFigura.RETANGULO));
            System.out.println("Figura 2: " + fig.toStringDaFigura(FigurasGeometricas.tiposDeFigura.QUADRADO));
            System.out.println("Figura 3: " + fig.toStringDaFigura(FigurasGeometricas.tiposDeFigura.CIRCULO));

            System.out.println("\n< Todas as Figuras > \n" + fig.toStringDaFigura(FigurasGeometricas.tiposDeFigura.TODOS));

        } catch (FiguraException e) {
            System.out.println("Erro ao criar figura: " + e.getMessage());
        }
    }
}