package test;

import main.Disciplina;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DisciplinaTest {

    @Test
    void deveCriarDisciplinaComTodosOsAtributos() {
        Disciplina disciplina = new Disciplina(
                "Engenharia de Software II",
                "ESWII2025",
                60,
                "Terça 07h-09h | Quinta 07-09h"
        );

        assertEquals("Engenharia de Software II", disciplina.getNome());
        assertEquals("ESWII2025", disciplina.getCodigo());
        assertEquals(60, disciplina.getCargaHoraria());
        assertEquals("Terça 07h-09h | Quinta 07-09h", disciplina.getHorario());
    }
}
