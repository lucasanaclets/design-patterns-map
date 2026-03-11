package tests;

import model.entities.Onibus;
import model.entities.StatusAssento;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class OnibusTest {

    @Test
    public void deveCriarQuantidadeCorretaDeAssentos() {

        Onibus onibus = new Onibus(10);

        assertEquals(10, onibus.getAssentos().size());
    }

    @Test
    public void deveBuscarAssentoPorNumero() {

        Onibus onibus = new Onibus(10);

        assertNotNull(onibus.buscarAssento(5));
        assertEquals(5, onibus.buscarAssento(5).getNumero());
    }

    @Test
    public void deveAlterarStatusDoAssento() {

        Onibus onibus = new Onibus(10);

        onibus.alterarStatusAssento(4, StatusAssento.RESERVADO);

        assertEquals(
                StatusAssento.RESERVADO,
                onibus.buscarAssento(4).getStatus()
        );
    }
}
