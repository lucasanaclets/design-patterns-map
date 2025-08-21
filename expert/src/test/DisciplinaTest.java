package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import main.Disciplina;
import main.Aluno;

public class DisciplinaTest {

    @Test
    public void permitirAdicionarAlunosNaDisciplina() {
        Disciplina disciplina = new Disciplina("Computação Gráfica", "CG2025", 60, "Terça 09h-11h | Quinta 11h-13h");
        Aluno aluno1 = new Aluno("Lucas Anacleto", "2201080090");
        Aluno aluno2 = new Aluno("Gabriel Guedes", "2201080091");

        disciplina.adicionarAluno(aluno1);
        disciplina.adicionarAluno(aluno2);

        assertEquals(2, disciplina.numeroDeAlunos());
        assertEquals("Gabriel Guedes", disciplina.getAlunosMatriculados().get(1).getNome());
    }

    @Test
    public void deveRetornarZeroQuandoNaoHaAlunos() {
        Disciplina disciplina = new Disciplina("Inteligência Artificial", "IA2025", 60, "Quarta 09h-11h | Sexta 09h-11h");
        assertEquals(0, disciplina.numeroDeAlunos());
    }

    @Test
    public void naoPermitirAdicionarMesmoAlunoDuasVezes() {
        Disciplina disciplina = new Disciplina("Algoritmos", "AL2025", 60, "Terça 09-11h | Quinta 09-11h");
        Aluno aluno = new Aluno("Lucas Anacleto", "2201080090");

        disciplina.adicionarAluno(aluno);
        disciplina.adicionarAluno(aluno);

        assertEquals(1, disciplina.numeroDeAlunos(),
                "Aluno não deveria ser adicionado duas vezes na mesma disciplina");
    }
}