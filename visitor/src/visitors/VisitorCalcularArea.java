package visitors;

import entities.*;
import interfaces.IVisitor;

public class VisitorCalcularArea implements IVisitor {

    public double visitaRetangulo(Rectangle r){
        return r.getAltura() * r.getLargura();
    }

    public double visitaTriangulo (Triangle t) {
        return (t.getBase() * t.getAltura())/2;
    }
    public double visitaCirculo (Circle c){
        return 3.14 * Math.pow(c.getRaio() , 2);
    }

    public double visitaTrapezio (Trapezoid t) {
        return ( ( t.getBaseMaior() + t.getBaseMenor() ) * t.getAltura() ) /2;
    }
}