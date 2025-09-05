package test;

import entities.FigurasGeometricas;
import exceptions.FiguraException;
import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.Before;

public class FigurasGeometricasTest {
    FigurasGeometricas fig;

    @Before
    public void setup() throws FiguraException  {
        fig = new FigurasGeometricas(10, 5, 7, 25);
    }

    @Test
    public void testAreaDaFiguraRetangulo() throws FiguraException {
        assertEquals("50.0", fig.areaDaFigura(FigurasGeometricas.tiposDeFigura.RETANGULO));
    }

    @Test
    public void testAreaDaFiguraQuadrado() throws FiguraException {
        assertEquals("49.0", fig.areaDaFigura(FigurasGeometricas.tiposDeFigura.QUADRADO));
    }

    @Test
    public void testAreaDaFiguraCirculo() throws FiguraException {
        assertEquals("1963.4954084936207", fig.areaDaFigura(FigurasGeometricas.tiposDeFigura.CIRCULO));
    }

    @Test
    public void testPerimetroDaFiguraRetangulo() throws FiguraException {
        assertEquals("30.0", fig.perimetroDaFigura(FigurasGeometricas.tiposDeFigura.RETANGULO));
    }

    @Test
    public void testPerimetroDaFiguraQuadrado() throws FiguraException {
        assertEquals("28.0", fig.perimetroDaFigura(FigurasGeometricas.tiposDeFigura.QUADRADO));
    }

    @Test
    public void testPerimetroDaFiguraCirculo() throws FiguraException {
        assertEquals("157.07963267948966", fig.perimetroDaFigura(FigurasGeometricas.tiposDeFigura.CIRCULO));
    }

}