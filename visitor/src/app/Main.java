package app;

import exceptions.ExceptionEntity;
import interfaces.IVisitor;
import entities.*;
import visitors.*;

public class Main {
    public static void main(String[] args) throws ExceptionEntity {

        IVisitor visitorCA  = new VisitorCalcularArea();
        IVisitor visitorCP  = new VisitorCalcularPerimetro();
        IVisitor visitorDes = new VisitorDesenhar();
        IVisitor visitorMax = new VisitorMaximizarFigura();

        Circle circulo        = new Circle(4);
        Rectangle retangulo   = new Rectangle(5, 7);
        Trapezoid trapezio    = new Trapezoid(5, 10, 4, 6, 6);
        Triangle triangulo    = new Triangle(12, 8, 10, 10);

        // ===== ÁREAS =====
        System.out.println("Área do Círculo: "   + circulo.aceitaVisita(visitorCA));
        System.out.println("Área do Trapézio: "  + trapezio.aceitaVisita(visitorCA));
        System.out.println("Área do Triângulo: " + triangulo.aceitaVisita(visitorCA));
        System.out.println("Área do Retângulo: " + retangulo.aceitaVisita(visitorCA));

        System.out.println();

        // ===== PERÍMETROS =====
        System.out.println("Perímetro do Círculo: "   + circulo.aceitaVisita(visitorCP));
        System.out.println("Perímetro do Trapézio: "  + trapezio.aceitaVisita(visitorCP));
        System.out.println("Perímetro do Triângulo: " + triangulo.aceitaVisita(visitorCP));
        System.out.println("Perímetro do Retângulo: " + retangulo.aceitaVisita(visitorCP));

        System.out.println();

        // ===== DESENHAR =====
        circulo.aceitaVisita(visitorDes);
        trapezio.aceitaVisita(visitorDes);
        triangulo.aceitaVisita(visitorDes);
        retangulo.aceitaVisita(visitorDes);

        System.out.println();

        // ===== MAXIMIZAR =====
        circulo.aceitaVisita(visitorMax);
        System.out.println("Raio do Círculo após ser maximizado: " + circulo.getRaio());

        retangulo.aceitaVisita(visitorMax);
        System.out.println("Largura e Altura do Retângulo após ser maximizado: "
                + retangulo.getLargura() + " ; " + retangulo.getAltura());

        triangulo.aceitaVisita(visitorMax);
        System.out.println("Base, Altura e Lados do Triângulo após ser maximizado: "
                + triangulo.getBase() + " ; " + triangulo.getAltura() + " ; "
                + triangulo.getLado1() + " ; " + triangulo.getLado2());

        trapezio.aceitaVisita(visitorMax);
        System.out.println("Bases, Altura e Lados do Trapézio após ser maximizado: "
                + trapezio.getBaseMenor() + " ; " + trapezio.getBaseMaior() + " ; "
                + trapezio.getAltura() + " ; " + trapezio.getLado1() + " ; " + trapezio.getLado2());
    }
}