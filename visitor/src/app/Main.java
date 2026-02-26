package app;

import exceptions.ExceptionEntity;
import interfaces.IVisitor;
import entities.*;
import visitors.*;

public class Main {
    public static void main(String[] args) throws ExceptionEntity {

        IVisitor visitorCA = new VisitorCalcularArea();
        IVisitor visitorCP = new VisitorCalcularPerimetro();
        IVisitor visitorDes = new VisitorDesenhar();
        IVisitor visitorMax = new VisitorMaximizarFigura();

        Circle circulo = new Circle(4);
        Rectangle retangulo = new Rectangle(5,7);
        Trapezoid trapezio = new Trapezoid(5,10,4,6,6);
        Triangle triangulo = new Triangle(12,8,10,10);

        System.out.println("Área do Círculo: " + visitorCA.visitaCirculo(circulo));
        System.out.println("Área do Trapézio: " + visitorCA.visitaTrapezio(trapezio));
        System.out.println("Área do Triângulo: " + visitorCA.visitaTriangulo(triangulo));
        System.out.println("Área do Retângulo: " + visitorCA.visitaRetangulo(retangulo));

        System.out.println();

        System.out.println("Perímetro do Círculo: " + visitorCP.visitaCirculo(circulo));
        System.out.println("Perímetro do Trapézio: " + visitorCP.visitaTrapezio(trapezio));
        System.out.println("Perímetro do Triângulo: " + visitorCP.visitaTriangulo(triangulo));
        System.out.println("Perímetro do Retângulo: " + visitorCP.visitaRetangulo(retangulo));

        System.out.println();

        visitorDes.visitaCirculo(circulo);
        visitorDes.visitaTrapezio(trapezio);
        visitorDes.visitaTriangulo(triangulo);
        visitorDes.visitaRetangulo(retangulo);

        System.out.println();

        visitorMax.visitaCirculo(circulo);
        System.out.println("Raio do Círculo após ser maximizado: " + circulo.getRaio());

        visitorMax.visitaRetangulo(retangulo);
        System.out.println("Largura e Altura do Retângulo após ser maximizado: " + retangulo.getLargura() + " ; " + retangulo.getAltura());

        visitorMax.visitaTriangulo(triangulo);
        System.out.println("Base, Altura e Lados do Triângulo após ser maximizado: " +
                triangulo.getBase() + " ; " + triangulo.getAltura() + " ; " + triangulo.getLado1() + " ; " + triangulo.getLado2());

        visitorMax.visitaTrapezio(trapezio);
        System.out.println("Bases, Altura e Lados do Trapézio após ser maximizado: " +
                trapezio.getBaseMenor() + " ; " + trapezio.getBaseMaior() + " ; " + trapezio.getAltura() +
                " ; " + trapezio.getLado1() + " ; " + trapezio.getLado2());

    }
}