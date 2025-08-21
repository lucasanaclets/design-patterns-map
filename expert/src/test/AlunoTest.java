package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import main.Aluno;
import main.Disciplina;

public class AlunoTest {

    @Test
    public void permitirMatricularAlunoEmMaisDeUmaDisciplina() {

        Aluno aluno = new Aluno("Lucas Anacleto", "2201080090");
        Disciplina d1 = new Disciplina("Engenharia de Software II", "ESWII2025", 60, "Terça 07h-09h | Quinta 07-09h");
        Disciplina d2 = new Disciplina("Sistemas Operacionais", "SO2025", 60, "Segunda 14h-16h | Quarta 14h-16h");


        aluno.matricular(d1);
        aluno.matricular(d2);


        assertEquals(2, aluno.getDisciplinasMatriculadas().size());
        assertEquals("Engenharia de Software II", aluno.getDisciplinasMatriculadas().get(0).getNome());
        assertEquals(2, d1.numeroDeAlunos() + d2.numeroDeAlunos());
    }

    @Test
    public void permitirObterHorariosDasDisciplinasMatriculadas() {
        Aluno aluno = new Aluno("Matheus Abreu", "2201080092");
        Disciplina d1 = new Disciplina("Inteligência Artificial", "IA2025", 60, "Quarta 09h-11h | Sexta 09h-11h");
        aluno.matricular(d1);

        assertEquals("Quarta 09h-11h | Sexta 09h-11h", aluno.getDisciplinasMatriculadas().get(0).getHorario());
    }

    @Test
    public void naoPermitirMatricularAlunoNaMesmaDisciplinaDuasVezes() {
        Aluno aluno = new Aluno("Lucas Anacleto", "2201080092");
        Disciplina disciplina = new Disciplina("Laboratorio de Programação II", "LPII2025", 60, "Segunda 7h-9h | Sexta 7h-9h");

        aluno.matricular(disciplina);
        aluno.matricular(disciplina);

        assertEquals(1, aluno.getDisciplinasMatriculadas().size(), "Aluno não deveria ser matriculado duas vezes na mesma disciplina");
    }

}