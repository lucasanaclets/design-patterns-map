package model.usuario.funcoes;

import model.usuario.IMotorista;
import model.viagem.Viagem;

public class MotoristaFunc extends FuncaoUsuario implements IMotorista {

    public MotoristaFunc(String nomeUsuario) {
        super(nomeUsuario);
    }

    @Override
    public void aceitarViagem(Viagem viagem) {
        adicionarViagem(viagem);
    }

    @Override
    public java.util.List<Viagem> getHistoricoViagensComoMotorista() {
        return getHistorico();
    }
}
