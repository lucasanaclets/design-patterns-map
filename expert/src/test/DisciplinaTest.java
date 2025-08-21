package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import main.Disciplina;
import main.Aluno;
import main.Professor;

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

    @Test
    public void naoPermitirAdicionarMaisDeUmProfessorNaDisciplina() {
        Disciplina disciplina = new Disciplina("Engenharia de Software II", "ESWII2025", 60, "Terça 07h-09h | Quinta 07-09h");
        Professor professor1 = new Professor("Sabrina de Figueirêdo");
        Professor professor2 = new Professor("Dunfrey Aragão");

        // Primeiro professor consegue ser adicionado
        disciplina.setProfessor(professor1);

        // Tentar adicionar segundo professor
        boolean resultado = disciplina.setProfessor(professor2);

        assertFalse(resultado, "Não deve permitir adicionar um segundo professor à mesma disciplina");
        assertEquals(professor1, disciplina.getProfessor(), "O professor da disciplina deve continuar sendo o primeiro");
    }

}