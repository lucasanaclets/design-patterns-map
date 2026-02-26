package tests;

import entities.*;

import visitors.VisitorMaximizarFigura;
import exceptions.ExceptionEntity;
import interfaces.IVisitor;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class VisitorMaximizarFiguraTest {
    IVisitor vmf;
    Rectangle r;
    Circle c;
    Trapezoid t;
    Triangle tr;

    @Before
    public void setup() throws ExceptionEntity {
        vmf = new VisitorMaximizarFigura();
        r = new Rectangle(2, 4);
        c = new Circle(2);
        t = new Trapezoid(2, 4, 3, 2, 2);
        tr = new Triangle(3, 4, 2, 2);
    }

    @Test
    public void testMaximizarRetangulo() {
        vmf.visitaRetangulo(r);
        assertEquals(8, r.getAltura(), 0.1);
        assertEquals(4, r.getLargura(), 0.1);
    }

    @Test
    public void testMaximizarCirculo() {
        vmf.visitaCirculo(c);
        assertEquals(4, c.getRaio(), 0.1);
    }

    @Test
    public void testMaximizarTrapezio() {
        vmf.visitaTrapezio(t);
        assertEquals(6, t.getAltura(), 0.1);
        assertEquals(8, t.getBaseMaior(), 0.1);
        assertEquals(4, t.getBaseMenor(), 0.1);
        assertEquals(4, t.getLado1(), 0.1);
        assertEquals(4, t.getLado2(), 0.1);
    }

    @Test
    public void testMaximizarTriangulo() {
        vmf.visitaTriangulo(tr);
        assertEquals(8, tr.getAltura(), 0.1);
        assertEquals(6, tr.getBase(), 0.1);
        assertEquals(4, tr.getLado1(), 0.1);
        assertEquals(4, tr.getLado2(), 0.1);
    }
}
