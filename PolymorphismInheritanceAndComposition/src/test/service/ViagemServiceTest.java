package test.service;

import model.usuario.IPassageiro;
import model.usuario.IMotorista;
import model.usuario.funcoes.PassageiroFunc;
import model.usuario.funcoes.MotoristaFunc;
import model.veiculo.Veiculo;
import model.pagamento.Pagamento;
import model.viagem.Viagem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.ViagemRepository;
import service.ViagemService;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ViagemServiceTest {

    private ViagemRepository repository;
    private ViagemService service;
    private IPassageiro passageiro;
    private IMotorista motorista;

    @BeforeEach
    void setUp() {
        repository = new ViagemRepository();
        service = new ViagemService(repository);
        passageiro = new PassageiroFunc("Passageiro1");
        motorista = new MotoristaFunc("Motorista1");
    }

    private Viagem criarViagem(String origem, String destino) {
        Veiculo veiculo = new Veiculo("Toyota", "Corolla", "ABC-1234", 2020);
        Pagamento pagamento = new Pagamento("Pix", null);
        return new Viagem(passageiro, motorista, veiculo, pagamento, origem, destino, LocalDateTime.now(), 50.0);
    }

    @Test
    void deveRegistrarViagem() {
        Viagem viagem = criarViagem("Origem1", "Destino1");
        service.registrarViagem(viagem);

        List<Viagem> viagens = service.listarTodasViagens();
        assertEquals(1, viagens.size());
        assertEquals(viagem, viagens.get(0));
    }

    @Test
    void deveConsultarHistoricoDoPassageiro() {
        Viagem v1 = criarViagem("O1", "D1");
        Viagem v2 = criarViagem("O2", "D2");
        service.registrarViagem(v1);
        service.registrarViagem(v2);

        List<Viagem> historico = service.consultarHistoricoPassageiro(passageiro);
        assertEquals(2, historico.size());
        assertTrue(historico.contains(v1));
        assertTrue(historico.contains(v2));
    }

    @Test
    void deveConsultarHistoricoDoMotorista() {
        Viagem v1 = criarViagem("O1", "D1");
        Viagem v2 = criarViagem("O2", "D2");
        service.registrarViagem(v1);
        service.registrarViagem(v2);

        List<Viagem> historico = service.consultarHistoricoMotorista(motorista);
        assertEquals(2, historico.size());
        assertTrue(historico.contains(v1));
        assertTrue(historico.contains(v2));
    }
}
