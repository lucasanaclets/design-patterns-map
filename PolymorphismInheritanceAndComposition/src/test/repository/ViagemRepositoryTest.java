package test.repository;

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

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ViagemRepositoryTest {

    private ViagemRepository repository;
    private IPassageiro passageiro;
    private IMotorista motorista;

    @BeforeEach
    void setUp() {
        repository = new ViagemRepository();
        passageiro = new PassageiroFunc("Passageiro1");
        motorista = new MotoristaFunc("Motorista1");
    }

    private Viagem criarViagem(String origem, String destino) {
        Veiculo veiculo = new Veiculo("Toyota", "Corolla", "ABC-1234", 2020);
        Pagamento pagamento = new Pagamento("Pix", null);
        return new Viagem(passageiro, motorista, veiculo, pagamento, origem, destino, LocalDateTime.now(), 50.0);
    }

    @Test
    void deveAdicionarViagem() {
        Viagem viagem = criarViagem("Origem1", "Destino1");
        repository.adicionarViagem(viagem);

        List<Viagem> viagens = repository.listarViagens();
        assertEquals(1, viagens.size());
        assertEquals(viagem, viagens.get(0));
    }

    @Test
    void deveListarTodasViagens() {
        Viagem v1 = criarViagem("O1", "D1");
        Viagem v2 = criarViagem("O2", "D2");
        repository.adicionarViagem(v1);
        repository.adicionarViagem(v2);

        List<Viagem> viagens = repository.listarViagens();
        assertEquals(2, viagens.size());
        assertTrue(viagens.contains(v1));
        assertTrue(viagens.contains(v2));
    }

    @Test
    void deveListarViagensPorPassageiro() {
        Viagem v1 = criarViagem("O1", "D1");
        Viagem v2 = new Viagem(new PassageiroFunc("Outro"), new MotoristaFunc("Motorista2"),
                new Veiculo("Fiat", "Argo", "DEF-5678", 2022),
                new Pagamento("Cartão", "Visa"), "O2", "D2", LocalDateTime.now(), 75.0);

        repository.adicionarViagem(v1);
        repository.adicionarViagem(v2);

        List<Viagem> viagensPassageiro = repository.listarPorPassageiro(passageiro);
        assertEquals(1, viagensPassageiro.size());
        assertEquals(v1, viagensPassageiro.get(0));
    }

    @Test
    void deveListarViagensPorMotorista() {
        Viagem v1 = criarViagem("O1", "D1");
        Viagem v2 = new Viagem(new PassageiroFunc("Passageiro2"), new MotoristaFunc("OutroMotorista"),
                new Veiculo("Fiat", "Argo", "DEF-5678", 2022),
                new Pagamento("Cartão", "Visa"), "O2", "D2", LocalDateTime.now(), 75.0);

        repository.adicionarViagem(v1);
        repository.adicionarViagem(v2);

        List<Viagem> viagensMotorista = repository.listarPorMotorista(motorista);
        assertEquals(1, viagensMotorista.size());
        assertEquals(v1, viagensMotorista.get(0));
    }
}
