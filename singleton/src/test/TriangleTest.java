package test;

import entities.Triangle;
import exceptions.ExceptionInstance;
import factory.GeometricShapesFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TriangleTest {

    @Before
    public void setUp() {
        Triangle.reset();
    }

    @Test
    public void deveCriarUmDeCadaTipo() throws ExceptionInstance {
        Triangle t1 = GeometricShapesFactory.createRectangleTriangle();
        Triangle t2 = GeometricShapesFactory.createIsoscelesTriangle();
        Triangle t3 = GeometricShapesFactory.createEquilateralTriangle();

        assertNotNull(t1);
        assertNotNull(t2);
        assertNotNull(t3);
    }

    @Test
    public void naoDeveCriarDoisRetangulos() throws ExceptionInstance {
        GeometricShapesFactory.createRectangleTriangle();

        assertThrows(ExceptionInstance.class,
                () -> GeometricShapesFactory.createRectangleTriangle());
    }

    @Test
    public void naoDeveCriarDoisIsosceles() throws ExceptionInstance {
        GeometricShapesFactory.createIsoscelesTriangle();

        assertThrows(ExceptionInstance.class,
                () -> GeometricShapesFactory.createIsoscelesTriangle());
    }

    @Test
    public void naoDeveCriarDoisEquilateros() throws ExceptionInstance {
        GeometricShapesFactory.createEquilateralTriangle();

        assertThrows(ExceptionInstance.class,
                () -> GeometricShapesFactory.createEquilateralTriangle());
    }
}