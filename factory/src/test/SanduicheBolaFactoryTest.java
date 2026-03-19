package test;

import entity.Sanduiche;
import factory.SanduicheBolaFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SanduicheBolaFactoryTest {

    @Test
    public void testeCriarSanduicheBola() {
        SanduicheBolaFactory factory = new SanduicheBolaFactory();
        Sanduiche sanduiche = factory.preparar();

        assertNotNull(sanduiche);
        assertEquals("Pão Bola, Queijo Prato, Presunto de Peru, Ovo de Granja, Tomate", sanduiche.toString());
    }
}
