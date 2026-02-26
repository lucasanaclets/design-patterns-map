package visitors;

import entities.*;
import interfaces.IVisitor;

public class VisitorCalcularPerimetro implements IVisitor {

    public double visitaRetangulo(Rectangle r){
        return (r.getAltura() * 2 ) + ( r.getLargura() * 2 );
    }

    public double visitaTriangulo (Triangle t) {
        return (t.getBase() + t.getLado1() + t.getLado2());
    }

    public double visitaCirculo (Circle c){
        return (2 * 3.14 * c.getRaio());
    }

    public double visitaTrapezio (Trapezoid tz) {
        return (tz.getBaseMenor() + tz.getBaseMaior() + tz.getLado1() + tz.getLado2());
    }
}
