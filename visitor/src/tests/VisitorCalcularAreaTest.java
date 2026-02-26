package tests;

import entities.*;

import visitors.VisitorCalcularArea;
import exceptions.ExceptionEntity;
import interfaces.IVisitor;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class VisitorCalcularAreaTest {

    IVisitor ca;
    Rectangle r;
    Circle c;
    Trapezoid t;
    Triangle tr;

    @Before
    public void setup() throws ExceptionEntity {
        ca = new VisitorCalcularArea();
        r = new Rectangle(2, 4);
        c = new Circle(2);
        t = new Trapezoid(2, 4, 3, 2, 2);
        tr = new Triangle(3, 4, 2, 2);
    }

    @Test
    public void testAreaRetangulo() {
        assertEquals(8, ca.visitaRetangulo(r), 0.1);
    }

    @Test
    public void testAreaCirculo() {
        assertEquals(12.56, ca.visitaCirculo(c), 0.01);
    }

    @Test
    public void testAreaTrapezio() {
        assertEquals(9.0, ca.visitaTrapezio(t), 0.1);
    }

    @Test
    public void testAreaTriangulo() {
        assertEquals(6.0, ca.visitaTriangulo(tr), 0.1);
    }

}
