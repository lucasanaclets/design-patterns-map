package tests;

import exceptions.ExceptionEntity;
import entities.Triangle;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TriangleTest {

    @Test (expected = ExceptionEntity.class)
    public void criarTrianguloLadoInvalidoTest() throws ExceptionEntity {
        new Triangle(-1,3,6,4);
    }

    @Test (expected = ExceptionEntity.class)
    public void criarTrianguloInvalidoTest() throws ExceptionEntity {
        new Triangle(2,5,8,3);
    }

    @Test
    public void testCriarTrianguloBase() throws ExceptionEntity {
        Triangle triangulo = new Triangle(5, 4, 3, 3);
        assertEquals(5, triangulo.getBase(), 0.1);
    }

    @Test
    public void testCriarTrianguloAltura() throws ExceptionEntity {
        Triangle triangulo = new Triangle(5, 4, 3, 3);
        assertEquals(4, triangulo.getAltura(), 0.1);
    }

    @Test
    public void testCriarTrianguloLado1() throws ExceptionEntity {
        Triangle triangulo = new Triangle(5, 4, 3, 3);
        assertEquals(3, triangulo.getLado1(), 0.1);
    }

    @Test
    public void testCriarTrianguloLado2() throws ExceptionEntity {
        Triangle triangulo = new Triangle(5, 4, 3, 3);
        assertEquals(3, triangulo.getLado2(), 0.1);
    }

}
