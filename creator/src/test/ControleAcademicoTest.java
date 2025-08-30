package test;

import main.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ControleAcademicoTest {

    private ControleAcademico CA;
    private Aluno lucasAnacleto;
    private Aluno matheusAbreu;
    private Professor sabrinaDeFigueiredo;
    private Professor dunfreyAragao;
    private Disciplina engenhariaDeSoftwareII;
    private Disciplina sistemasOperacionais;

    @BeforeEach
    void setUp() {
        CA = new ControleAcademico();

        sabrinaDeFigueiredo = CA.adicionarNovoProfessor("Sabrina de Figueirêdo");
        dunfreyAragao = CA.adicionarNovoProfessor("Dunfrey Aragão");

        lucasAnacleto = CA.adicionarNovoAluno("Lucas Anacleto", "2201080090");
        matheusAbreu = CA.adicionarNovoAluno("Matheus Abreu", "2201080091");

        engenhariaDeSoftwareII = CA.adicionarNovaDisciplina(
                "Engenharia de Software II", "ESWII2025", 60, "Terça 07h-09h | Quinta 07-09h"
        );
        sistemasOperacionais = CA.adicionarNovaDisciplina(
                "Sistemas Operacionais", "SO2025", 60, "Segunda 14h-16h | Quarta 14h-16h"
        );
    }

    // ------------------- Testes de Professores -------------------

    @Test
    void deveAssociarProfessorSeDisciplinaNaoTiverProfessor() {
        boolean resultado = CA.associarProfessor(sabrinaDeFigueiredo, engenhariaDeSoftwareII);
        assertTrue(resultado);
        assertEquals(sabrinaDeFigueiredo, CA.obterProfessor(engenhariaDeSoftwareII));
    }

    @Test
    void naoDeveAssociarProfessorSeJaHouverOutro() {
        CA.associarProfessor(sabrinaDeFigueiredo, engenhariaDeSoftwareII);
        boolean resultadoDuplicado = CA.associarProfessor(dunfreyAragao, engenhariaDeSoftwareII);

        assertFalse(resultadoDuplicado);
        assertEquals(sabrinaDeFigueiredo, CA.obterProfessor(engenhariaDeSoftwareII));
    }

    @Test
    void deveRetornarDisciplinasDoProfessor() {
        CA.associarProfessor(sabrinaDeFigueiredo, engenhariaDeSoftwareII);
        CA.associarProfessor(sabrinaDeFigueiredo, sistemasOperacionais);

        List<Disciplina> disciplinas = CA.disciplinasDoProfessor(sabrinaDeFigueiredo);

        assertEquals(2, disciplinas.size());
        assertTrue(disciplinas.contains(engenhariaDeSoftwareII));
        assertTrue(disciplinas.contains(sistemasOperacionais));
    }

    @Test
    void deveRetornarHorariosDoProfessor() {
        CA.associarProfessor(sabrinaDeFigueiredo, engenhariaDeSoftwareII);
        List<String> horarios = CA.horariosDoProfessor(sabrinaDeFigueiredo);

        assertEquals(1, horarios.size());
        assertEquals("Engenharia de Software II: Terça 07h-09h | Quinta 07-09h", horarios.get(0));
    }

    // ------------------- Testes de Alunos -------------------

    @Test
    void deveMatricularAlunoEmDisciplina() {
        boolean resultado = CA.matricularAluno(lucasAnacleto, engenhariaDeSoftwareII);
        assertTrue(resultado);
        List<Aluno> alunos = CA.alunosDaDisciplina(engenhariaDeSoftwareII);
        assertEquals(1, alunos.size());
        assertEquals(lucasAnacleto, alunos.get(0));
    }

    @Test
    void naoDeveMatricularAlunoDuplicado() {
        CA.matricularAluno(lucasAnacleto, engenhariaDeSoftwareII);
        boolean resultadoDuplicado = CA.matricularAluno(lucasAnacleto, engenhariaDeSoftwareII);

        assertFalse(resultadoDuplicado);
        assertEquals(1, CA.alunosDaDisciplina(engenhariaDeSoftwareII).size());
    }

    @Test
    void deveRetornarDisciplinasDoAluno() {
        CA.matricularAluno(lucasAnacleto, engenhariaDeSoftwareII);
        CA.matricularAluno(lucasAnacleto, sistemasOperacionais);

        List<Disciplina> disciplinas = CA.disciplinasDoAluno(lucasAnacleto);

        assertEquals(2, disciplinas.size());
        assertTrue(disciplinas.contains(engenhariaDeSoftwareII));
        assertTrue(disciplinas.contains(sistemasOperacionais));
    }

    @Test
    void deveRetornarHorariosDoAluno() {
        CA.matricularAluno(lucasAnacleto, engenhariaDeSoftwareII);

        List<String> horarios = CA.horariosDoAluno(lucasAnacleto);

        assertEquals(1, horarios.size());
        assertEquals("Engenharia de Software II: Terça 07h-09h | Quinta 07-09h", horarios.get(0));
    }

    @Test
    void deveRetornarNumeroDeAlunosNaDisciplina() {
        CA.matricularAluno(lucasAnacleto, engenhariaDeSoftwareII);
        CA.matricularAluno(matheusAbreu, engenhariaDeSoftwareII);

        int numero = CA.numeroDeAlunos(engenhariaDeSoftwareII);
        assertEquals(2, numero);
    }

    // ------------------- Testes de Criação com Verificação de Duplicatas -------------------

    @Test
    void naoDeveCriarAlunoDuplicado() {
        Aluno repetido = CA.adicionarNovoAluno("Lucas Anacleto", "2201080090");
        assertEquals(lucasAnacleto, repetido); // retorna mesmo objeto
    }

    @Test
    void naoDeveCriarProfessorDuplicado() {
        Professor repetido = CA.adicionarNovoProfessor("Sabrina de Figueirêdo");
        assertEquals(sabrinaDeFigueiredo, repetido);
    }

    @Test
    void naoDeveCriarDisciplinaDuplicada() {
        Disciplina repetida = CA.adicionarNovaDisciplina(
                "Engenharia de Software II", "ESWII2025", 60, "Terça 07h-09h | Quinta 07-09h"
        );
        assertEquals(engenhariaDeSoftwareII, repetida);
    }
}
