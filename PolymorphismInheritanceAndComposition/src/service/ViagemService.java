package service;

import model.viagem.Viagem;
import model.usuario.IPassageiro;
import model.usuario.IMotorista;
import repository.ViagemRepository;

import java.util.List;

public class ViagemService {
    private ViagemRepository viagemRepository;

    public ViagemService(ViagemRepository viagemRepository) {
        this.viagemRepository = viagemRepository;
    }

    // Registrar uma nova viagem
    public void registrarViagem(Viagem viagem) {
        viagemRepository.adicionarViagem(viagem);
        System.out.println("Viagem registrada: " + viagem.getOrigem() + " -> " + viagem.getDestino());
    }

    // Consultar histórico de um passageiro
    public List<Viagem> consultarHistoricoPassageiro(IPassageiro passageiro) {
        return viagemRepository.listarPorPassageiro(passageiro);
    }

    // Consultar histórico de um motorista
    public List<Viagem> consultarHistoricoMotorista(IMotorista motorista) {
        return viagemRepository.listarPorMotorista(motorista);
    }

    // Listar todas as viagens
    public List<Viagem> listarTodasViagens() {
        return viagemRepository.listarViagens();
    }
}
