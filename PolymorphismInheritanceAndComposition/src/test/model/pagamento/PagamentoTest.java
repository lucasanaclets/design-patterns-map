package test.model.pagamento;

import model.pagamento.Pagamento;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PagamentoTest {

    @Test
    void deveCriarPagamentoComTipoEDescricao() {
        Pagamento pagamento = new Pagamento("Cartão de Crédito", "Visa");

        assertEquals("Cartão de Crédito", pagamento.getTipo());
        assertEquals("Visa", pagamento.getDescricao());
        assertEquals("Cartão de Crédito - Visa", pagamento.toString());
    }

    @Test
    void deveCriarPagamentoSomenteComTipo() {
        Pagamento pagamento = new Pagamento("Pix", null);

        assertEquals("Pix", pagamento.getTipo());
        assertNull(pagamento.getDescricao());
        assertEquals("Pix", pagamento.toString());
    }
}
