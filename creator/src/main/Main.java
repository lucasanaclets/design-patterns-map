package main;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // ----------------- INSTÂNCIAS -----------------

        Professor sabrinaDeFigueiredo = new Professor("Sabrina de Figueirêdo");
        Professor dunfreyAragao = new Professor("Dunfrey Aragão");
        Professor robsonPequeno = new Professor("Robson Pequeno");
        Professor anaIsabella = new Professor("Ana Isabella");
        Professor wellingtonCandeia = new Professor("Wellington Candeia");

        Disciplina engenhariaDeSoftwareII = new Disciplina("Engenharia de Software II", "ESWII2025", 60, "Terça 07h-09h | Quinta 07-09h");
        Disciplina sistemasOperacionais = new Disciplina("Sistemas Operacionais", "SO2025", 60, "Segunda 14h-16h | Quarta 14h-16h");
        Disciplina computacaoGrafica = new Disciplina("Computação Gráfica", "CG2025", 60, "Terça 09h-11h | Quinta 11h-13h");
        Disciplina gerenciaDeProjetos = new Disciplina("Gerência de Projetos", "GP2025", 60, "Segunda 11h-13h | Sexta 07-09h");
        Disciplina interconexaoDeComputadores = new Disciplina("Interconexão e Segurança de Redes de Computadores", "INT2025", 60, "Segunda 07h-09h | Quinta 09h-11h");
        Disciplina inteligenciaArtificial = new Disciplina("Inteligência Artificial", "IA2025", 60, "Quarta 09h-11h | Sexta 09h-11h");

        Aluno lucasAnacleto = new Aluno("Lucas Anacleto", "2201080090");
        Aluno matheusAbreu = new Aluno("Matheus Abreu", "2201080091");

        // ----------------- ASSOCIAÇÕES E MATRICULAS -----------------

        ControleAcademico CA = new ControleAcademico();

        CA.associarProfessor(sabrinaDeFigueiredo, engenhariaDeSoftwareII);
        CA.associarProfessor(dunfreyAragao, sistemasOperacionais);
        CA.associarProfessor(dunfreyAragao, interconexaoDeComputadores);
        CA.associarProfessor(robsonPequeno, computacaoGrafica);
        CA.associarProfessor(anaIsabella, gerenciaDeProjetos);
        CA.associarProfessor(wellingtonCandeia, interconexaoDeComputadores);

        CA.matricularAluno(lucasAnacleto, engenhariaDeSoftwareII);
        CA.matricularAluno(lucasAnacleto, computacaoGrafica);
        CA.matricularAluno(lucasAnacleto, gerenciaDeProjetos);
        CA.matricularAluno(lucasAnacleto, sistemasOperacionais);

        CA.matricularAluno(matheusAbreu, engenhariaDeSoftwareII);
        CA.matricularAluno(matheusAbreu, sistemasOperacionais);
        CA.matricularAluno(matheusAbreu, interconexaoDeComputadores);
        CA.matricularAluno(matheusAbreu, inteligenciaArtificial);

        // ----------------- CONSULTAS -----------------

        System.out.print("\n➡️ 1 - Quais disciplinas um professor está ministrando: \n\n");

        List<Disciplina> disciplinasDeDunfrey = CA.disciplinasDoProfessor(dunfreyAragao);

        System.out.print("Disciplinas ministradas por: " + dunfreyAragao.getNome() + "\n");
        for (Disciplina disciplina : disciplinasDeDunfrey) {
            System.out.println("- " + disciplina.getNome());
        }

        System.out.print("\n ➡️ 2 - Qual o horário de um professor: \n\n");

        List<String> horariosDeDunfrey = CA.horariosDoProfessor(dunfreyAragao);

        System.out.print("Horários do professor: " + dunfreyAragao.getNome() + "\n");
        for (String horario : horariosDeDunfrey) {
            System.out.println("- " + horario);
        }

        System.out.print("\n ➡️ 3 - Quais os alunos de uma dada disciplina: \n\n");

        List<Aluno> alunosDeSistemasOperacionais = CA.alunosDaDisciplina(sistemasOperacionais);

        System.out.print("Alunos da disciplina: " + sistemasOperacionais.getNome() + "\n");
        for (Aluno aluno : alunosDeSistemasOperacionais) {
            System.out.println("- " + aluno.getNome());
        }

        System.out.print("\n ➡️ 4 - Quais as disciplinas de um aluno: \n\n");

        List<Disciplina> disciplinasDeLucasAnacleto = CA.disciplinasDoAluno(lucasAnacleto);

        System.out.println("Disciplinas do aluno: " + lucasAnacleto.getNome());
        for (Disciplina disciplina : disciplinasDeLucasAnacleto) {
            System.out.println("- " + disciplina.getNome());
        }

        System.out.print("\n ➡️ 5 - Quais os horários de um aluno: \n\n");

        List<String> horariosDeLucasAnacleto = CA.horariosDoAluno(lucasAnacleto);

        System.out.println("Horários do aluno: " + lucasAnacleto.getNome());
        for (String horario : horariosDeLucasAnacleto) {
            System.out.println("- " + horario);
        }

        System.out.print("\n ➡️ 6 - Qual o número alunos de uma disciplina: \n\n");

        System.out.print("Quantidade de alunos da disciplina de " + engenhariaDeSoftwareII.getNome() + ": " + CA.numeroDeAlunos(sistemasOperacionais));
    }
}
