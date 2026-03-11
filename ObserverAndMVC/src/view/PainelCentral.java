package view;

import model.entities.Assento;
import model.event.AssentoEvent;
import model.event.AssentoListener;

public class PainelCentral implements AssentoListener {

    @Override
    public void atualizarAssento(AssentoEvent event) {

        Assento assento = event.getAssento();

        String cor = switch (assento.getStatus()) {
            case DISPONIVEL -> "VERDE";
            case RESERVADO -> "AMARELO";
            case INDISPONIVEL -> "VERMELHO";
        };

        System.out.println("PAINEL CENTRAL -> Assento "
                + assento.getNumero()
                + " agora está "
                + assento.getStatus()
                + " (" + cor + ")");
    }
}