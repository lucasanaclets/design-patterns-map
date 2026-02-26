package tests;

import entities.Circle;
import exceptions.ExceptionEntity;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CircleTest {

    @Test
    public void criarCirculoTest() throws ExceptionEntity {
        Circle c = new Circle(5);
        assertEquals(5, c.getRaio(),0.1);
    }

    @Test (expected = ExceptionEntity.class)
    public void criarCirculoInvalidoTest() throws ExceptionEntity {
        new Circle(-1);
    }

}
