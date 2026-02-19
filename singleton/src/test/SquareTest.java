package test;

import entities.Square;
import exceptions.ExceptionInstance;
import factory.GeometricShapesFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class SquareTest {

    @Test
    public void deveCriarMultiplosQuadrados() throws ExceptionInstance {
        Square q1 = GeometricShapesFactory.createSquare(4);
        Square q2 = GeometricShapesFactory.createSquare(6);

        assertNotSame(q1, q2);
        assertEquals(4, q1.getLado());
        assertEquals(6, q2.getLado());
    }

    @Test
    public void naoDeveCriarQuadradoComLadoInvalido() {
        assertThrows(ExceptionInstance.class,
                () -> GeometricShapesFactory.createSquare(0));
    }
}