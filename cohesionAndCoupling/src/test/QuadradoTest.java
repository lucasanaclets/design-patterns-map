package test;

import static org.junit.Assert.*;
import org.junit.Test;

import entities.Quadrado;
import exceptions.FiguraException;

public class QuadradoTest {

    @Test
    public void testCalcularArea() throws FiguraException {
        Quadrado quadrado = new Quadrado(4);
        assertEquals(Double.valueOf(16), quadrado.calcularArea());
    }

    @Test
    public void testCalcularPerimetro() throws FiguraException {
        Quadrado quadrado = new Quadrado(3);
        assertEquals(Double.valueOf(12), quadrado.calcularPerimetro());
    }

    @Test(expected = FiguraException.class)
    public void testLadoNegativo() throws FiguraException {
        new Quadrado(-1);
    }

    @Test(expected = FiguraException.class)
    public void testLadoZero() throws FiguraException {
        new Quadrado(0);

    }

}