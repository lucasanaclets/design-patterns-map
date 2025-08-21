package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import main.Disciplina;
import main.Professor;

public class ProfessorTest {

    @Test
    public void permitirAssociarProfessorAteDuasDisciplinas() {
        Professor professor = new Professor("Dunfrey Aragão");
        Disciplina d1 = new Disciplina("Sistemas Operacionais", "SO2025", 60, "Segunda 14h-16h | Quarta 14h-16h");
        Disciplina d2 = new Disciplina("Interconexão e Segurança de Redes de Computadores", "INT2025", 60, "Segunda 07h-09h | Quinta 09h-11h");

        professor.adicionarDisciplina(d1);
        professor.adicionarDisciplina(d2);

        assertEquals(2, professor.getDisciplinasMinistradas().size());
        assertTrue(professor.getDisciplinasMinistradas().stream().anyMatch(d -> d.getNome().equals("Sistemas Operacionais")));
    }

    @Test
    public void permitirObterHorarioDasDisciplinasDoProfessor() {
        Professor professor = new Professor("Ana Isabella");
        Disciplina d = new Disciplina("Gerência de Projetos", "GP2025", 60, "Segunda 11h-13h | Sexta 07-09h");

        professor.adicionarDisciplina(d);

        assertEquals("Segunda 11h-13h | Sexta 07-09h", professor.getDisciplinasMinistradas().get(0).getHorario());
    }

    @Test
    public void naoPermitirAssociarProfessorNaMesmaDisciplinaDuasVezes() {
        Professor professor = new Professor("Fabio Leite");
        Disciplina disciplina = new Disciplina("Banco de Dados", "BD2025", 60, "Quarta 14h-16h | Sexta 16h-18h");

        professor.adicionarDisciplina(disciplina);
        professor.adicionarDisciplina(disciplina); // duplicada

        assertEquals(1, professor.getDisciplinasMinistradas().size(),
                "Professor não deveria ministrar a mesma disciplina duas vezes");
    }

}