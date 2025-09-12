package test.factory;

import factory.ViagemFactory;
import model.usuario.funcoes.PassageiroFunc;
import model.usuario.funcoes.MotoristaFunc;
import model.viagem.Viagem;
import model.veiculo.Veiculo;
import model.pagamento.Pagamento;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ViagemFactoryTest {

    @Test
    void deveCriarViagemComTodosOsAtributos() {
        PassageiroFunc passageiro = new PassageiroFunc("Passageiro1");
        MotoristaFunc motorista = new MotoristaFunc("Motorista1");
        Veiculo veiculo = new Veiculo("Toyota", "Corolla", "ABC-1234", 2020);
        Pagamento pagamento = new Pagamento("Pix", "Instantâneo");
        LocalDateTime horario = LocalDateTime.now();

        Viagem viagem = ViagemFactory.criarViagem(
                passageiro,
                motorista,
                veiculo,
                pagamento,
                "Origem1",
                "Destino1",
                horario,
                50.0
        );

        assertEquals(passageiro, viagem.getPassageiro());
        assertEquals(motorista, viagem.getMotorista());
        assertEquals(veiculo, viagem.getVeiculo());
        assertEquals(pagamento, viagem.getPagamento());
        assertEquals("Origem1", viagem.getOrigem());
        assertEquals("Destino1", viagem.getDestino());
        assertEquals(horario, viagem.getHorario());
        assertEquals(50.0, viagem.getValor());
        assertEquals(0, viagem.getAvaliacao());
    }
}
