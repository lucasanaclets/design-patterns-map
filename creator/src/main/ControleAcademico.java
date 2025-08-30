package main;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ControleAcademico {
    private final List<Aluno> alunos = new ArrayList<>();
    private final List<Professor> professores = new ArrayList<>();
    private final List<Disciplina> disciplinas = new ArrayList<>();
    private final List<AlunoDisciplina> alunosDisciplinas = new ArrayList<>();
    private final List<ProfessorDisciplina> professoresDisciplinas = new ArrayList<>();

    // ----------------- CRIAÇÕES -----------------

    public Aluno adicionarNovoAluno(String nome, String matricula) {
        // Verifica se já existe aluno com a mesma matrícula
        return alunos.stream()
                .filter(a -> a.getMatricula().equals(matricula))
                .findFirst()
                .orElseGet(() -> {
                    Aluno aluno = new Aluno(nome, matricula);
                    alunos.add(aluno);
                    return aluno;
                });
    }

    public Professor adicionarNovoProfessor(String nome) {
        // Verifica se já existe professor com o mesmo nome
        return professores.stream()
                .filter(p -> p.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElseGet(() -> {
                    Professor professor = new Professor(nome);
                    professores.add(professor);
                    return professor;
                });
    }

    public Disciplina adicionarNovaDisciplina(String nome, String codigo, int cargaHoraria, String horario) {
        // Verifica se já existe disciplina com o mesmo código
        return disciplinas.stream()
                .filter(d -> d.getCodigo().equalsIgnoreCase(codigo))
                .findFirst()
                .orElseGet(() -> {
                    Disciplina disciplina = new Disciplina(nome, codigo, cargaHoraria, horario);
                    disciplinas.add(disciplina);
                    return disciplina;
                });
    }

    // ----------------- ASSOCIAÇÕES -----------------

    public boolean associarProfessor(Professor professor, Disciplina disciplina) {
        for (ProfessorDisciplina pd : professoresDisciplinas) {
            if (pd.getDisciplina().equals(disciplina)) {
                return pd.atribuirProfessor(professor);
            }
        }
        ProfessorDisciplina pd = new ProfessorDisciplina(disciplina);
        professoresDisciplinas.add(pd);
        return pd.atribuirProfessor(professor);
    }

    public boolean matricularAluno(Aluno aluno, Disciplina disciplina) {
        for (AlunoDisciplina ad : alunosDisciplinas) {
            if (ad.getDisciplina().equals(disciplina)) {
                return ad.adicionarAluno(aluno);
            }
        }
        AlunoDisciplina ad = new AlunoDisciplina(disciplina);
        alunosDisciplinas.add(ad);
        return ad.adicionarAluno(aluno);
    }

    // ----------------- CONSULTAS -----------------

    public Professor obterProfessor(Disciplina disciplina) {
        for (ProfessorDisciplina pd : professoresDisciplinas) {
            if (pd.getDisciplina().equals(disciplina)) {
                return pd.getProfessor();
            }
        }
        return null;
    }

    public List<Disciplina> disciplinasDoProfessor(Professor professor) {
        return professoresDisciplinas.stream()
                .filter(pd -> professor.equals(pd.getProfessor()))
                .map(ProfessorDisciplina::getDisciplina)
                .collect(Collectors.toList());
    }

    public List<String> horariosDoProfessor(Professor professor) {
        return disciplinasDoProfessor(professor).stream()
                .map(d -> d.getNome() + ": " + d.getHorario())
                .collect(Collectors.toList());
    }

    public List<Aluno> alunosDaDisciplina(Disciplina disciplina) {
        for (AlunoDisciplina ad : alunosDisciplinas) {
            if (ad.getDisciplina().equals(disciplina)) {
                return ad.getAlunos();
            }
        }
        return new ArrayList<>();
    }

    public List<Disciplina> disciplinasDoAluno(Aluno aluno) {
        return alunosDisciplinas.stream()
                .filter(ad -> ad.getAlunos().contains(aluno))
                .map(AlunoDisciplina::getDisciplina)
                .collect(Collectors.toList());
    }

    public List<String> horariosDoAluno(Aluno aluno) {
        return disciplinasDoAluno(aluno).stream()
                .map(d -> d.getNome() + ": " + d.getHorario())
                .collect(Collectors.toList());
    }

    public int numeroDeAlunos(Disciplina disciplina) {
        return alunosDaDisciplina(disciplina).size();
    }
}
