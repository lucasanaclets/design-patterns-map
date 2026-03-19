package test;

import entity.Sanduiche;
import factory.SanduicheIntegralFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SanduicheIntegralFactoryTest {

    @Test
    public void testeCriarSanduicheIntegral() {
        SanduicheIntegralFactory factory = new SanduicheIntegralFactory();
        Sanduiche sanduiche = factory.preparar();

        assertNotNull(sanduiche);
        assertEquals("Pão Integral, Queijo Mussarela, Presunto de Peru, Ovo de Capoeira, Tomate", sanduiche.toString());
    }
}
