package main;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ControleAcademico {
    private final List<AlunoDisciplina> alunosDisciplinas = new ArrayList<>();
    private final List<ProfessorDisciplina> professoresDisciplinas = new ArrayList<>();

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
