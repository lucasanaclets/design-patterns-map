package factory;

import model.viagem.Viagem;
import model.usuario.IPassageiro;
import model.usuario.IMotorista;
import model.veiculo.Veiculo;
import model.pagamento.Pagamento;

import java.time.LocalDateTime;

public class ViagemFactory {

    public static Viagem criarViagem(IPassageiro passageiro,
                                     IMotorista motorista,
                                     Veiculo veiculo,
                                     Pagamento pagamento,
                                     String origem,
                                     String destino,
                                     LocalDateTime horario,
                                     double valor) {
        return new Viagem(passageiro, motorista, veiculo, pagamento, origem, destino, horario, valor);
    }
}
