package interfaces;

import entities.*;

public interface IVisitor {

    public double visitaRetangulo(Rectangle r);
    public double visitaTriangulo (Triangle t);
    public double visitaCirculo (Circle c);
    public double visitaTrapezio (Trapezoid tz);

}
