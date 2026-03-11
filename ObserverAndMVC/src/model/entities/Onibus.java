package model.entities;

import model.event.AssentoEvent;
import model.event.AssentoListener;
import model.event.AssentoSource;

import java.util.ArrayList;
import java.util.List;

public class Onibus implements AssentoSource {

    private List<Assento> assentos;
    private List<AssentoListener> listeners;

    public Onibus(int quantidadeAssentos) {

        assentos = new ArrayList<>();
        listeners = new ArrayList<>();

        for (int i = 1; i <= quantidadeAssentos; i++) {
            assentos.add(new Assento(i));
        }
    }

    public List<Assento> getAssentos() {
        return assentos;
    }

    public Assento buscarAssento(int numero) {

        return assentos
                .stream()
                .filter(a -> a.getNumero() == numero)
                .findFirst()
                .orElse(null);
    }

    public void alterarStatusAssento(int numero, StatusAssento status) {

        Assento assento = buscarAssento(numero);

        if (assento != null) {

            assento.setStatus(status);

            AssentoEvent event = new AssentoEvent(assento);

            notificarListeners(event);
        }
    }

    @Override
    public void adicionarListener(AssentoListener listener) {
        listeners.add(listener);
    }

    @Override
    public void removerListener(AssentoListener listener) {
        listeners.remove(listener);
    }

    @Override
    public void notificarListeners(AssentoEvent event) {

        for (AssentoListener listener : listeners) {
            listener.atualizarAssento(event);
        }
    }
}
