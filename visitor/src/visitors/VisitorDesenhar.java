package visitors;

import entities.*;
import interfaces.IVisitor;

public class VisitorDesenhar implements IVisitor {
    public double visitaRetangulo(Rectangle r) {
        System.out.println("Retângulo desenhado");
        return 0;
    }

    public double visitaTriangulo(Triangle t) {
        System.out.println("Triângulo desenhado");
        return 0;
    }

    public double visitaCirculo(Circle c) {
        System.out.println("Círculo desenhado");
        return 0;
    }

    public double visitaTrapezio(Trapezoid tz) {
        System.out.println("Trapezio desenhado");
        return 0;
    }
}
