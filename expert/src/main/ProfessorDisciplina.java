package main;

public class ProfessorDisciplina {
    private Disciplina disciplina;
    private Professor professor;

    public ProfessorDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
        this.professor = null;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public boolean atribuirProfessor(Professor professor) {
        if (this.professor == null) {
            this.professor = professor;
            return true;
        }
        return false; // disciplina já tem professor
    }
}
