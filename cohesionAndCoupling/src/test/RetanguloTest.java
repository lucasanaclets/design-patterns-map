package test;
import static org.junit.Assert.*;
import org.junit.Test;

import entities.Retangulo;
import exceptions.FiguraException;

public class RetanguloTest {

    @Test
    public void testCalcularArea() throws FiguraException {
        Retangulo retangulo = new Retangulo(4, 5);
        assertEquals(Double.valueOf(20), retangulo.calcularArea());
    }

    @Test
    public void testCalcularPerimetro() throws FiguraException {
        Retangulo retangulo = new Retangulo(3, 6);
        assertEquals(Double.valueOf(18), retangulo.calcularPerimetro());
    }

    @Test(expected = FiguraException.class)
    public void testAlturaNegativa() throws FiguraException {
        new Retangulo(-1, 5);
    }

    @Test(expected = FiguraException.class)
    public void testLarguraNegativa() throws FiguraException {
        new Retangulo(4, -2);
    }

    @Test(expected = FiguraException.class)
    public void testAlturaZero() throws FiguraException {
        new Retangulo(0, 5);
    }

    @Test(expected = FiguraException.class)
    public void testLarguraZero() throws FiguraException {
        new Retangulo(4, 0);
    }

}