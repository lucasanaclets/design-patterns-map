package test;

import main.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AlunoDisciplinaTest {

    @Test
    void deveAdicionarAlunoQuandoNaoEstiverMatriculado() {
        Disciplina disciplina = new Disciplina(
                "Engenharia de Software II",
                "ESWII2025",
                60,
                "Terça 07h-09h | Quinta 07-09h"
        );

        AlunoDisciplina alunoDisciplina = new AlunoDisciplina(disciplina);
        Aluno aluno = new Aluno("Lucas Anacleto", "221080090");

        boolean resultado = alunoDisciplina.adicionarAluno(aluno);

        assertTrue(resultado);
        assertEquals(1, alunoDisciplina.getAlunos().size());
        assertEquals(aluno, alunoDisciplina.getAlunos().get(0));
    }

    @Test
    void naoDeveAdicionarAlunoDuplicado() {
        Disciplina disciplina = new Disciplina(
                "Engenharia de Software II",
                "ESWII2025",
                60,
                "Terça 07h-09h | Quinta 07-09h"
        );

        AlunoDisciplina alunoDisciplina = new AlunoDisciplina(disciplina);
        Aluno aluno = new Aluno("Lucas Anacleto", "221080090");

        alunoDisciplina.adicionarAluno(aluno);
        boolean resultadoDuplicado = alunoDisciplina.adicionarAluno(aluno);

        assertFalse(resultadoDuplicado);
        assertEquals(1, alunoDisciplina.getAlunos().size());
    }

    @Test
    void deveRemoverAlunoQuandoEstiverMatriculado() {
        Disciplina disciplina = new Disciplina(
                "Engenharia de Software II",
                "ESWII2025",
                60,
                "Terça 07h-09h | Quinta 07-09h"
        );

        AlunoDisciplina alunoDisciplina = new AlunoDisciplina(disciplina);
        Aluno aluno = new Aluno("Lucas Anacleto", "221080090");

        alunoDisciplina.adicionarAluno(aluno);
        boolean removido = alunoDisciplina.removerAluno(aluno);

        assertTrue(removido);
        assertEquals(0, alunoDisciplina.getAlunos().size());
    }

    @Test
    void naoDeveRemoverAlunoNaoMatriculado() {
        Disciplina disciplina = new Disciplina(
                "Engenharia de Software II",
                "ESWII2025",
                60,
                "Terça 07h-09h | Quinta 07-09h"
        );

        AlunoDisciplina alunoDisciplina = new AlunoDisciplina(disciplina);
        Aluno aluno = new Aluno("Lucas Anacleto", "221080090");

        boolean removido = alunoDisciplina.removerAluno(aluno);

        assertFalse(removido);
        assertEquals(0, alunoDisciplina.getAlunos().size());
    }
}
