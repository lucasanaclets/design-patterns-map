package test;

import entities.Circle;
import exceptions.ExceptionInstance;
import factory.GeometricShapesFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CircleTest {

    @Before
    public void setUp() {
        Circle.reset();
    }

    @Test
    public void deveCriarUmCirculo() throws ExceptionInstance {
        Circle c = GeometricShapesFactory.createCircle(5);
        assertEquals(5, c.getRaio());
    }

    @Test
    public void naoDeveCriarDoisCirculos() throws ExceptionInstance {
        GeometricShapesFactory.createCircle(5);

        assertThrows(ExceptionInstance.class,
                () -> GeometricShapesFactory.createCircle(3));
    }

    @Test
    public void naoDeveCriarCirculoComRaioInvalido() {
        assertThrows(ExceptionInstance.class,
                () -> GeometricShapesFactory.createCircle(0));
    }
}