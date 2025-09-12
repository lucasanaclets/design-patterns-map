package model.usuario.funcoes;

import model.usuario.IPassageiro;
import model.viagem.Viagem;

public class PassageiroFunc extends FuncaoUsuario implements IPassageiro {

    public PassageiroFunc(String nomeUsuario) {
        super(nomeUsuario);
    }

    @Override
    public void solicitarViagem(Viagem viagem) {
        adicionarViagem(viagem);
    }

    @Override
    public java.util.List<Viagem> getHistoricoViagensComoPassageiro() {
        return getHistorico();
    }
}
