package tests;

import model.entities.Onibus;
import model.entities.StatusAssento;
import model.observer.AssentoEvent;
import model.observer.AssentoListener;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

class TestObserver implements AssentoListener {

    boolean foiNotificado = false;

    @Override
    public void atualizarAssento(AssentoEvent event) {
        foiNotificado = true;
    }
}

public class ObserverIntegrationTest {

    @Test
    public void deveNotificarObserversQuandoAssentoAlterar() {

        Onibus onibus = new Onibus(10);

        TestObserver observer = new TestObserver();

        onibus.adicionarListener(observer);

        onibus.alterarStatusAssento(2, StatusAssento.RESERVADO);

        assertTrue(observer.foiNotificado);
    }
}
