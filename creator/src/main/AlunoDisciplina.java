package main;

import java.util.ArrayList;
import java.util.List;

public class AlunoDisciplina {
    private Disciplina disciplina;
    private List<Aluno> alunos;

    public AlunoDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
        this.alunos = new ArrayList<>();
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public boolean adicionarAluno(Aluno aluno) {
        if (!alunos.contains(aluno)) {
            alunos.add(aluno);
            return true;
        }
        return false; // aluno já está matriculado
    }

    public boolean removerAluno(Aluno aluno) {
        if (alunos.contains(aluno)) {
            alunos.remove(aluno);
            return true;
        }
        return false; // aluno não estava matriculado
    }
}
