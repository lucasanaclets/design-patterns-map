package test;

import entity.Sanduiche;
import factory.SanduicheFrancesFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SanduicheFrancesFactoryTest {

    @Test
    public void testeCriarSanduicheFrances() {
        SanduicheFrancesFactory factory = new SanduicheFrancesFactory();
        Sanduiche sanduiche = factory.preparar();

        assertNotNull(sanduiche);
        assertEquals("Pão Francês, Queijo Cheddar, Presunto de Frango, Ovo de Capoeira, Tomate", sanduiche.toString());
    }
}
