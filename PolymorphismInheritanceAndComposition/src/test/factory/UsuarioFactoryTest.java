package test.factory;

import factory.UsuarioFactory;
import model.usuario.Usuario;
import model.usuario.funcoes.PassageiroFunc;
import model.usuario.funcoes.MotoristaFunc;
import model.veiculo.Veiculo;
import model.pagamento.Pagamento;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioFactoryTest {

    @Test
    void deveCriarUsuarioComTodosOsAtributos() {
        PassageiroFunc passageiroFunc = new PassageiroFunc("Lucas");
        MotoristaFunc motoristaFunc = new MotoristaFunc("Lucas");
        Veiculo veiculo = new Veiculo("Toyota", "Corolla", "ABC-1234", 2020);
        Pagamento pagamento = new Pagamento("Pix", "Instantâneo");

        Usuario usuario = UsuarioFactory.criarUsuario(
                "Lucas",
                "lucas@email.com",
                "123456789",
                List.of(passageiroFunc),
                List.of(motoristaFunc),
                null,
                List.of(veiculo),
                List.of(pagamento)
        );

        assertEquals("Lucas", usuario.getNome());
        assertEquals("lucas@email.com", usuario.getEmail());
        assertEquals("123456789", usuario.getTelefone());

        // Funções
        List<String> funcoes = usuario.getFuncoes();
        assertEquals(2, funcoes.size());
        assertTrue(funcoes.contains("Passageiro"));
        assertTrue(funcoes.contains("Motorista"));

        // Veículos e pagamentos
        assertEquals(1, usuario.getVeiculos().size());
        assertEquals(veiculo, usuario.getVeiculos().get(0));

        assertEquals(1, usuario.getFormasPagamento().size());
        assertEquals(pagamento, usuario.getFormasPagamento().get(0));
    }

    @Test
    void deveCriarUsuarioMesmoComListasNulas() {
        Usuario usuario = UsuarioFactory.criarUsuario(
                "Lucas",
                "lucas@email.com",
                "123456789",
                null,
                null,
                null,
                null,
                null
        );

        assertEquals("Lucas", usuario.getNome());
        assertTrue(usuario.getVeiculos().isEmpty());
        assertTrue(usuario.getFormasPagamento().isEmpty());
        assertTrue(usuario.getFuncoes().isEmpty());
    }
}
