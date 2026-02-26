package tests;

import exceptions.ExceptionEntity;
import entities.Trapezoid;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TrapezoidTest {

    @Test (expected = ExceptionEntity.class)
    public void criarTrapezioLadoInvalidoTest() throws ExceptionEntity {
        new Trapezoid(-1,5,7,6,6);
    }

    @Test (expected = ExceptionEntity.class)
    public void criarTrapezioInvalidoTest() throws ExceptionEntity {
        new Trapezoid(6,6,8,3,2);
    }

    @Test
    public void testCriarTrapezioBaseMenor() throws ExceptionEntity {
        Trapezoid trapezio = new Trapezoid(3, 5, 7, 6, 6);
        assertEquals(3, trapezio.getBaseMenor(), 0.1);
    }

    @Test
    public void testCriarTrapezioBaseMaior() throws ExceptionEntity {
        Trapezoid trapezio = new Trapezoid(3, 5, 7, 6, 6);
        assertEquals(5, trapezio.getBaseMaior(), 0.1);
    }

    @Test
    public void testCriarTrapezioAltura() throws ExceptionEntity {
        Trapezoid trapezio = new Trapezoid(3, 5, 7, 6, 6);
        assertEquals(7, trapezio.getAltura(), 0.1);
    }

    @Test
    public void testCriarTrapezioLado1() throws ExceptionEntity {
        Trapezoid trapezio = new Trapezoid(3, 5, 7, 6, 6);
        assertEquals(6, trapezio.getLado1(), 0.1);
    }

    @Test
    public void testCriarTrapezioLado2() throws ExceptionEntity {
        Trapezoid trapezio = new Trapezoid(3, 5, 7, 6, 6);
        assertEquals(6, trapezio.getLado2(), 0.1);
    }

}
