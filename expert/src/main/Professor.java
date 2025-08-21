package main;

import java.util.ArrayList;
import java.util.List;

public class Professor {
    private String nome;
    private List<Disciplina> disciplinasMinistradas;

    public Professor(String nome) {
        this.nome = nome;
        this.disciplinasMinistradas = new ArrayList<>();
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        if (disciplina.setProfessor(this)) {
            disciplinasMinistradas.add(disciplina);
        } else {
            System.out.println("Falha ao processar: A disciplina " + disciplina.getNome() + " já possui professor!");
        }
    }

    // Getters e Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Disciplina> getDisciplinasMinistradas() {
        return disciplinasMinistradas;
    }

    public void setDisciplinasMinistradas(List<Disciplina> disciplinasMinistradas) {
        this.disciplinasMinistradas = disciplinasMinistradas;
    }

}