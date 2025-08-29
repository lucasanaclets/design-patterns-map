package test;

import main.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProfessorDisciplinaTest {

    @Test
    void deveAtribuirProfessorSeNaoHouverProfessor() {
        Disciplina disciplina = new Disciplina(
                "Engenharia de Software II",
                "ESWII2025",
                60,
                "Terça 07h-09h | Quinta 07-09h"
        );
        ProfessorDisciplina professorDisciplina = new ProfessorDisciplina(disciplina);
        Professor professor = new Professor("Sabrina de Figueiredo");

        boolean atribuido = professorDisciplina.atribuirProfessor(professor);

        assertTrue(atribuido);
        assertEquals(professor, professorDisciplina.getProfessor());
    }

    @Test
    void naoDeveAtribuirProfessorSeJaExistirOutro() {
        Disciplina disciplina = new Disciplina(
                "Engenharia de Software II",
                "ESWII2025",
                60,
                "Terça 07h-09h | Quinta 07-09h"
        );
        ProfessorDisciplina professorDisciplina = new ProfessorDisciplina(disciplina);
        Professor sabrinaDeFigueiredo = new Professor("Sabrina de Figueiredo");
        Professor dunfreyAragao = new Professor("Dunfrey Aragão");

        professorDisciplina.atribuirProfessor(sabrinaDeFigueiredo);

        boolean atribuidoDuplicado = professorDisciplina.atribuirProfessor(dunfreyAragao);

        assertFalse(atribuidoDuplicado);
        assertEquals(sabrinaDeFigueiredo, professorDisciplina.getProfessor());
    }

    @Test
    void deveRemoverProfessorSeExistir() {
        Disciplina disciplina = new Disciplina(
                "Engenharia de Software II",
                "ESWII2025",
                60,
                "Terça 07h-09h | Quinta 07-09h"
        );
        ProfessorDisciplina professorDisciplina = new ProfessorDisciplina(disciplina);
        Professor professor = new Professor("Sabrina de Figueiredo");

        professorDisciplina.atribuirProfessor(professor);
        boolean removido = professorDisciplina.removerProfessor();

        assertTrue(removido);
        assertNull(professorDisciplina.getProfessor());
    }

    @Test
    void naoDeveRemoverProfessorSeNaoExistir() {
        Disciplina disciplina = new Disciplina(
                "Engenharia de Software II",
                "ESWII2025",
                60,
                "Terça 07h-09h | Quinta 07-09h"
        );
        ProfessorDisciplina professorDisciplina = new ProfessorDisciplina(disciplina);

        boolean removido = professorDisciplina.removerProfessor();

        assertFalse(removido);
        assertNull(professorDisciplina.getProfessor());
    }
}