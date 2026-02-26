package tests;

import entities.*;

import visitors.VisitorCalcularPerimetro;
import exceptions.ExceptionEntity;
import interfaces.IVisitor;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class VisitorCalcularPerimetroTest {

    IVisitor cp;
    Rectangle r;
    Circle c;
    Trapezoid t;
    Triangle tr;

    @Before
    public void setup() throws ExceptionEntity {
        cp = new VisitorCalcularPerimetro();
        r = new Rectangle(2, 4);
        c = new Circle(2);
        t = new Trapezoid(2, 4, 3, 2, 2);
        tr = new Triangle(3, 4, 2, 2);
    }

    @Test
    public void testPerimetroRetangulo() {
        assertEquals(12, cp.visitaRetangulo(r), 0.1);
    }

    @Test
    public void testPerimetroCirculo() {
        assertEquals(12.56, cp.visitaCirculo(c), 0.01);
    }

    @Test
    public void testPerimetroTrapezio() {
        assertEquals(10, cp.visitaTrapezio(t), 0.1);
    }

    @Test
    public void testPerimetroTriangulo() {
        assertEquals(7, cp.visitaTriangulo(tr), 0.1);
    }

}
