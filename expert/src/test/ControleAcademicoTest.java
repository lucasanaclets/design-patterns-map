package test;

import main.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ControleAcademicoTest {

    private ControleAcademico controle;
    private Professor sabrinaDeFigueiredo;
    private Professor dunfreyAragao;
    private Aluno lucasAnacleto;
    private Aluno matheusAbreu;
    private Disciplina engenhariaDeSoftwareII;
    private Disciplina sistemasOperacionais;

    @BeforeEach
    void setUp() {
        controle = new ControleAcademico();

        sabrinaDeFigueiredo = new Professor("Sabrina de Figueirêdo");
        dunfreyAragao = new Professor("Dunfrey Aragão");

        lucasAnacleto = new Aluno("Lucas Anacleto", "2201080090");
        matheusAbreu = new Aluno("Matheus Abreu", "2201080091");

        engenhariaDeSoftwareII = new Disciplina(
                "Engenharia de Software II",
                "ESWII2025",
                60,
                "Terça 07h-09h | Quinta 07-09h"
        );

        sistemasOperacionais = new Disciplina(
                "Sistemas Operacionais",
                "SO2025",
                60,
                "Segunda 14h-16h | Quarta 14h-16h"
        );
    }

    // ------------------- Testes de Professores -------------------

    @Test
    void deveAssociarProfessorSeDisciplinaNaoTiverProfessor() {
        boolean resultado = controle.associarProfessor(sabrinaDeFigueiredo, engenhariaDeSoftwareII);
        assertTrue(resultado);
        assertEquals(sabrinaDeFigueiredo, controle.obterProfessor(engenhariaDeSoftwareII));
    }

    @Test
    void naoDeveAssociarProfessorSeJaHouverOutro() {
        controle.associarProfessor(sabrinaDeFigueiredo, engenhariaDeSoftwareII);
        boolean resultadoDuplicado = controle.associarProfessor(dunfreyAragao, engenhariaDeSoftwareII);

        assertFalse(resultadoDuplicado);
        assertEquals(sabrinaDeFigueiredo, controle.obterProfessor(engenhariaDeSoftwareII));
    }

    @Test
    void deveRetornarDisciplinasDoProfessor() {
        controle.associarProfessor(sabrinaDeFigueiredo, engenhariaDeSoftwareII);
        controle.associarProfessor(sabrinaDeFigueiredo, sistemasOperacionais);

        List<Disciplina> disciplinas = controle.disciplinasDoProfessor(sabrinaDeFigueiredo);

        assertEquals(2, disciplinas.size());
        assertTrue(disciplinas.contains(engenhariaDeSoftwareII));
        assertTrue(disciplinas.contains(sistemasOperacionais));
    }

    @Test
    void deveRetornarHorariosDoProfessor() {
        controle.associarProfessor(sabrinaDeFigueiredo, engenhariaDeSoftwareII);
        List<String> horarios = controle.horariosDoProfessor(sabrinaDeFigueiredo);

        assertEquals(1, horarios.size());
        assertEquals("Engenharia de Software II: Terça 07h-09h | Quinta 07-09h", horarios.get(0));
    }

    // ------------------- Testes de Alunos -------------------

    @Test
    void deveMatricularAlunoEmDisciplina() {
        boolean resultado = controle.matricularAluno(lucasAnacleto, engenhariaDeSoftwareII);
        assertTrue(resultado);
        List<Aluno> alunos = controle.alunosDaDisciplina(engenhariaDeSoftwareII);
        assertEquals(1, alunos.size());
        assertEquals(lucasAnacleto, alunos.get(0));
    }

    @Test
    void naoDeveMatricularAlunoDuplicado() {
        controle.matricularAluno(lucasAnacleto, engenhariaDeSoftwareII);
        boolean resultadoDuplicado = controle.matricularAluno(lucasAnacleto, engenhariaDeSoftwareII);

        assertFalse(resultadoDuplicado);
        assertEquals(1, controle.alunosDaDisciplina(engenhariaDeSoftwareII).size());
    }

    @Test
    void deveRetornarDisciplinasDoAluno() {
        controle.matricularAluno(lucasAnacleto, engenhariaDeSoftwareII);
        controle.matricularAluno(lucasAnacleto, sistemasOperacionais);

        List<Disciplina> disciplinas = controle.disciplinasDoAluno(lucasAnacleto);

        assertEquals(2, disciplinas.size());
        assertTrue(disciplinas.contains(engenhariaDeSoftwareII));
        assertTrue(disciplinas.contains(sistemasOperacionais));
    }

    @Test
    void deveRetornarHorariosDoAluno() {
        controle.matricularAluno(lucasAnacleto, engenhariaDeSoftwareII);

        List<String> horarios = controle.horariosDoAluno(lucasAnacleto);

        assertEquals(1, horarios.size());
        assertEquals("Engenharia de Software II: Terça 07h-09h | Quinta 07-09h", horarios.get(0));
    }

    @Test
    void deveRetornarNumeroDeAlunosNaDisciplina() {
        controle.matricularAluno(lucasAnacleto, engenhariaDeSoftwareII);
        controle.matricularAluno(matheusAbreu, engenhariaDeSoftwareII);

        int numero = controle.numeroDeAlunos(engenhariaDeSoftwareII);
        assertEquals(2, numero);
    }
}
