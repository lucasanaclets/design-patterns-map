package test.model.viagem;

import model.usuario.IPassageiro;
import model.usuario.IMotorista;
import model.veiculo.Veiculo;
import model.pagamento.Pagamento;
import model.viagem.Viagem;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ViagemTest {

    // Implementações simples para teste
    static class PassageiroStub implements IPassageiro {
        private List<Viagem> historico = new ArrayList<>();
        @Override
        public void solicitarViagem(Viagem viagem) {
            historico.add(viagem);
        }
        @Override
        public List<Viagem> getHistoricoViagensComoPassageiro() {
            return historico;
        }
        @Override
        public String toString() {
            return "PassageiroStub";
        }
    }

    static class MotoristaStub implements IMotorista {
        private List<Viagem> historico = new ArrayList<>();
        @Override
        public void aceitarViagem(Viagem viagem) {
            historico.add(viagem);
        }
        @Override
        public List<Viagem> getHistoricoViagensComoMotorista() {
            return historico;
        }
        @Override
        public String toString() {
            return "MotoristaStub";
        }
    }

    @Test
    void deveCriarViagemCorretamente() {
        IPassageiro passageiro = new PassageiroStub();
        IMotorista motorista = new MotoristaStub();
        Veiculo veiculo = new Veiculo("Toyota", "Corolla", "ABC-1234", 2020);
        Pagamento pagamento = new Pagamento("Pix", "Instantâneo");
        LocalDateTime horario = LocalDateTime.now();

        Viagem viagem = new Viagem(passageiro, motorista, veiculo, pagamento,
                "Origem", "Destino", horario, 50.0);

        assertEquals(passageiro, viagem.getPassageiro());
        assertEquals(motorista, viagem.getMotorista());
        assertEquals(veiculo, viagem.getVeiculo());
        assertEquals(pagamento, viagem.getPagamento());
        assertEquals("Origem", viagem.getOrigem());
        assertEquals("Destino", viagem.getDestino());
        assertEquals(horario, viagem.getHorario());
        assertEquals(50.0, viagem.getValor());
        assertEquals(0, viagem.getAvaliacao());
    }

    @Test
    void deveAceitarAvaliacaoValida() {
        Viagem viagem = new Viagem(new PassageiroStub(), new MotoristaStub(),
                new Veiculo("Fiat", "Argo", "DEF-5678", 2022),
                new Pagamento("Cartão", "Visa"),
                "Origem", "Destino", LocalDateTime.now(), 100.0);

        for (int i = 0; i <= 5; i++) {
            viagem.setAvaliacao(i);
            assertEquals(i, viagem.getAvaliacao());
        }
    }

    @Test
    void deveLancarExcecaoAvaliacaoInvalida() {
        Viagem viagem = new Viagem(new PassageiroStub(), new MotoristaStub(),
                new Veiculo("Fiat", "Argo", "DEF-5678", 2022),
                new Pagamento("Cartão", "Visa"),
                "Origem", "Destino", LocalDateTime.now(), 100.0);

        assertThrows(IllegalArgumentException.class, () -> viagem.setAvaliacao(-1));
        assertThrows(IllegalArgumentException.class, () -> viagem.setAvaliacao(6));
    }

    @Test
    void deveExibirComoPassageiroEMotorista() {
        IPassageiro passageiro = new PassageiroStub();
        IMotorista motorista = new MotoristaStub();
        Veiculo veiculo = new Veiculo("Toyota", "Corolla", "ABC-1234", 2020);
        Pagamento pagamento = new Pagamento("Pix", null);
        LocalDateTime horario = LocalDateTime.now();

        Viagem viagem = new Viagem(passageiro, motorista, veiculo, pagamento,
                "Origem", "Destino", horario, 75.0);

        assertTrue(viagem.exibirComoPassageiro().contains("Origem"));
        assertTrue(viagem.exibirComoPassageiro().contains("Destino"));
        assertTrue(viagem.exibirComoPassageiro().contains("Pix"));
        assertTrue(viagem.exibirComoPassageiro().contains("Toyota Corolla"));

        assertTrue(viagem.exibirComoMotorista().contains("Origem"));
        assertTrue(viagem.exibirComoMotorista().contains("Destino"));
        assertTrue(viagem.exibirComoMotorista().contains("Pix"));
    }
}
