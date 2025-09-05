
package test;

import entities.Circulo;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import exceptions.FiguraException;

public class CirculoTest {

    private Circulo circulo;

    @Before
    public void setUp() throws FiguraException {
        circulo = new Circulo(5);
    }

    @Test
    public void testCalcularArea() {
        assertEquals( 78.5, circulo.calcularArea(),0.1);
    }

    @Test
    public void testCalcularPerimetro() {
        assertEquals(31.4, circulo.calcularPerimetro(), 0.1);
    }

    @Test(expected = FiguraException.class)
    public void testCriarCirculoComRaioNegativo() throws FiguraException {
        new Circulo(-1);
    }

    @Test(expected = FiguraException.class)
    public void testCriarCirculoComRaioZero() throws FiguraException {
        new Circulo(0);
    }

}
