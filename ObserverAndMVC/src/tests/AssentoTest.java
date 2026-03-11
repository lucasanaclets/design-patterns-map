package tests;

import model.entities.Assento;
import model.entities.StatusAssento;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AssentoTest {

    @Test
    public void deveCriarAssentoDisponivel() {

        Assento assento = new Assento(1);

        assertEquals(1, assento.getNumero());
        assertEquals(StatusAssento.DISPONIVEL, assento.getStatus());
    }

    @Test
    public void deveAlterarStatusAssento() {

        Assento assento = new Assento(2);

        assento.setStatus(StatusAssento.RESERVADO);

        assertEquals(StatusAssento.RESERVADO, assento.getStatus());
    }
}
