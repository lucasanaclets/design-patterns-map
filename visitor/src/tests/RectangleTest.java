package tests;

import entities.Rectangle;
import exceptions.ExceptionEntity;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class RectangleTest {

    @Test
    public void testCriarRetanguloLargura() throws ExceptionEntity {
        Rectangle retangulo = new Rectangle(5, 4);
        assertEquals(5, retangulo.getLargura(), 0.1);
    }

    @Test
    public void testCriarRetanguloAltura() throws ExceptionEntity {
        Rectangle retangulo = new Rectangle(5, 4);
        assertEquals(4, retangulo.getAltura(), 0.1);
    }

    @Test (expected = ExceptionEntity.class)
    public void criarRetanguloLarguraInvalidaTest() throws ExceptionEntity {
        new Rectangle(-1,7);
    }

    @Test (expected = ExceptionEntity.class)
    public void criarRetanguloAlturaInvalidaTest() throws ExceptionEntity {
        new Rectangle(5,0);
    }

}
