package model.usuario;

import model.viagem.Viagem;

import java.util.List;

public interface IMotorista {
    void aceitarViagem(Viagem viagem);
    List<Viagem> getHistoricoViagensComoMotorista();
}
