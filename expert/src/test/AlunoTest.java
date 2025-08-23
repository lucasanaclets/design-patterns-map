package test;

import main.Aluno;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AlunoTest {

    @Test
    void deveCriarAlunoComNomeEMatricula() {
        Aluno aluno = new Aluno("Lucas Anacleto", "221080090");

        assertEquals("Lucas Anacleto", aluno.getNome());
        assertEquals("221080090", aluno.getMatricula());
    }
}
