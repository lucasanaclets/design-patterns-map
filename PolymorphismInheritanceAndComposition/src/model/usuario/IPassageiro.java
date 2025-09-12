package model.usuario;

import model.viagem.Viagem;

import java.util.List;

public interface IPassageiro {
    void solicitarViagem(Viagem viagem);
    List<Viagem> getHistoricoViagensComoPassageiro();
}
