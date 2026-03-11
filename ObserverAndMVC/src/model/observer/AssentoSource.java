package model.observer;

public interface AssentoSource {

    void adicionarListener(AssentoListener listener);

    void removerListener(AssentoListener listener);

    void notificarListeners(AssentoEvent event);

}