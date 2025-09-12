package test.model.veiculo;

import model.veiculo.Veiculo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VeiculoTest {

    @Test
    void deveCriarVeiculoCorretamente() {
        Veiculo veiculo = new Veiculo("Toyota", "Corolla", "ABC-1234", 2020);

        assertEquals("Toyota", veiculo.getMarca());
        assertEquals("Corolla", veiculo.getModelo());
        assertEquals("ABC-1234", veiculo.getPlaca());
        assertEquals(2020, veiculo.getAno());
        assertEquals("Toyota Corolla (ABC-1234)", veiculo.toString());
    }
}
