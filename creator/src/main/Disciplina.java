package main;

public class Disciplina {
    private String nome;
    private String codigo;
    private int cargaHoraria;
    private String horario;

    public Disciplina(String nome, String codigo, int cargaHoraria, String horario) {
        this.nome = nome;
        this.codigo = codigo;
        this.cargaHoraria = cargaHoraria;
        this.horario = horario;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public String getHorario() {
        return horario;
    }
}
