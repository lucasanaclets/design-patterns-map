package test.model.usuario;

import model.usuario.Usuario;
import model.usuario.funcoes.MotoristaFunc;
import model.usuario.funcoes.PassageiroFunc;
import model.veiculo.Veiculo;
import model.pagamento.Pagamento;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    @Test
    void deveCriarUsuarioComAtributosBasicos() {
        Usuario usuario = new Usuario("Lucas", "lucas@email.com", "123456789");

        assertEquals("Lucas", usuario.getNome());
        assertEquals("lucas@email.com", usuario.getEmail());
        assertEquals("123456789", usuario.getTelefone());
        assertTrue(usuario.getVeiculos().isEmpty());
        assertTrue(usuario.getFormasPagamento().isEmpty());
        assertTrue(usuario.getFuncoes().isEmpty());
    }

    @Test
    void deveAdicionarVeiculosEPagamentos() {
        Usuario usuario = new Usuario("Lucas", "lucas@email.com", "123456789");

        Veiculo veiculo = new Veiculo("Toyota", "Corolla", "ABC-1234", 2020);
        Pagamento pagamento = new Pagamento("Pix", null);

        usuario.addVeiculo(veiculo);
        usuario.addPagamento(pagamento);

        assertEquals(1, usuario.getVeiculos().size());
        assertEquals(veiculo, usuario.getVeiculos().get(0));

        assertEquals(1, usuario.getFormasPagamento().size());
        assertEquals(pagamento, usuario.getFormasPagamento().get(0));
    }

    @Test
    void deveAdicionarFuncoesEPegarFuncoesCorretamente() {
        Usuario usuario = new Usuario("Lucas", "lucas@email.com", "123456789");

        PassageiroFunc passageiroFunc = new PassageiroFunc("Lucas");
        MotoristaFunc motoristaFunc = new MotoristaFunc("Lucas");

        usuario.addPassageiroFunc(passageiroFunc);
        usuario.addMotoristaFunc(motoristaFunc);

        List<String> funcoes = usuario.getFuncoes();
        assertEquals(2, funcoes.size());
        assertTrue(funcoes.contains("Passageiro"));
        assertTrue(funcoes.contains("Motorista"));
    }

    @Test
    void deveRetornarFuncoesVaziasQuandoNenhumaForAdicionada() {
        Usuario usuario = new Usuario("Lucas", "lucas@email.com", "123456789");
        List<String> funcoes = usuario.getFuncoes();
        assertTrue(funcoes.isEmpty());
    }
}
