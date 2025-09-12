package repository;

import model.viagem.Viagem;

import java.util.ArrayList;
import java.util.List;

public class ViagemRepository {
    private List<Viagem> viagens = new ArrayList<>();

    // Adicionar viagem
    public void adicionarViagem(Viagem viagem) {
        viagens.add(viagem);
    }

    // Listar todas as viagens
    public List<Viagem> listarViagens() {
        return new ArrayList<>(viagens);
    }

    // Listar viagens por passageiro
    public List<Viagem> listarPorPassageiro(Object passageiro) {
        List<Viagem> resultado = new ArrayList<>();
        for (Viagem v : viagens) {
            if (v.getPassageiro().equals(passageiro)) {
                resultado.add(v);
            }
        }
        return resultado;
    }

    // Listar viagens por motorista
    public List<Viagem> listarPorMotorista(Object motorista) {
        List<Viagem> resultado = new ArrayList<>();
        for (Viagem v : viagens) {
            if (v.getMotorista().equals(motorista)) {
                resultado.add(v);
            }
        }
        return resultado;
    }
}
