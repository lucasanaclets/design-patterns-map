package tests;

import controller.GuicheController;
import model.entities.Onibus;
import model.entities.StatusAssento;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GuicheControllerTest {

    @Test
    public void deveReservarAssento() {

        Onibus onibus = new Onibus(10);
        GuicheController guiche = new GuicheController(onibus);

        guiche.reservarAssento(3);

        assertEquals(
                StatusAssento.RESERVADO,
                onibus.buscarAssento(3).getStatus()
        );
    }

    @Test
    public void deveComprarAssento() {

        Onibus onibus = new Onibus(10);
        GuicheController guiche = new GuicheController(onibus);

        guiche.comprarAssento(6);

        assertEquals(
                StatusAssento.INDISPONIVEL,
                onibus.buscarAssento(6).getStatus()
        );
    }
}
