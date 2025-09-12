package model.usuario.funcoes;

import model.viagem.Viagem;
import java.util.ArrayList;
import java.util.List;

public abstract class FuncaoUsuario {
    protected String nomeUsuario;
    protected List<Viagem> historico = new ArrayList<>();

    public FuncaoUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public List<Viagem> getHistorico() {
        return historico;
    }

    public void adicionarViagem(Viagem viagem) {
        historico.add(viagem);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName().replace("Func", "") + ": " + nomeUsuario;
    }
}
