package main;

public class ControleAcademico {
    public static void main(String[] args) {

        Professor professor1 = new Professor("Sabrina de Figueirêdo");
        Professor professor2 = new Professor("Dunfrey Aragão");
        Professor professor3 = new Professor("Robson Pequeno");
        Professor professor4 = new Professor("Ana Isabella");
        Professor professor5 = new Professor("Wellington Candeia");

        Disciplina engenhariaDeSoftwareII = new Disciplina("Engenharia de Software II", "ESWII2025", 60, "Terça 07h-09h | Quinta 07-09h");
        Disciplina sistemasOperacionais = new Disciplina("Sistemas Operacionais", "SO2025", 60, "Segunda 14h-16h | Quarta 14h-16h");
        Disciplina computacaoGrafica = new Disciplina("Computação Gráfica", "CG2025", 60, "Terça 09h-11h | Quinta 11h-13h");
        Disciplina gerenciaDeProjetos = new Disciplina("Gerência de Projetos", "GP2025", 60, "Segunda 11h-13h | Sexta 07-09h");
        Disciplina interconexaoDeComputadores = new Disciplina("Interconexão e Segurança de Redes de Computadores", "INT2025", 60, "Segunda 07h-09h | Quinta 09h-11h");
        Disciplina inteligenciaArtificial = new Disciplina("Inteligência Artificial", "IA2025", 60, "Quarta 09h-11h | Sexta 09h-11h");

        professor1.adicionarDisciplina(engenhariaDeSoftwareII);
        professor2.adicionarDisciplina(sistemasOperacionais);
        professor2.adicionarDisciplina(interconexaoDeComputadores);
        professor3.adicionarDisciplina(computacaoGrafica);
        professor4.adicionarDisciplina(gerenciaDeProjetos);
        professor5.adicionarDisciplina(inteligenciaArtificial);

        Aluno aluno1 = new Aluno("Lucas Anacleto", "2201080090");
        Aluno aluno2 = new Aluno("Gabriel Guedes", "2201080091");
        Aluno aluno3 = new Aluno("Matheus Abreu", "2201080092");

        aluno1.matricular(engenhariaDeSoftwareII);
        aluno1.matricular(sistemasOperacionais);
        aluno1.matricular(computacaoGrafica);
        aluno1.matricular(inteligenciaArtificial);

        aluno2.matricular(computacaoGrafica);
        aluno2.matricular(gerenciaDeProjetos);
        aluno2.matricular(interconexaoDeComputadores);

        aluno3.matricular(inteligenciaArtificial);
        aluno3.matricular(interconexaoDeComputadores);
        aluno3.matricular(sistemasOperacionais);
        aluno3.matricular(engenhariaDeSoftwareII);

        System.out.print("➡️ 1 - Quais disciplinas um professor está ministrando: \n\n");

        System.out.println("Disciplinas ministradas por: " + professor1.getNome());
        for ( Disciplina disciplina : professor1.getDisciplinasMinistradas() ) {
            System.out.println("- " + disciplina.getNome());
        }

        System.out.print("\n");

        System.out.println("Disciplinas ministradas por: " + professor2.getNome());
        for ( Disciplina disciplina : professor2.getDisciplinasMinistradas() ) {
            System.out.println("- " + disciplina.getNome());
        }

        System.out.print("\n ➡️ 2 - Qual o horário de um professor: \n\n");

        System.out.println("Horários do(a) professor(a): " + professor3.getNome());
        for ( Disciplina disciplina : professor3.getDisciplinasMinistradas() ) {
            System.out.println("- " + disciplina.getNome() + ": " + disciplina.getHorario());
        }

        System.out.print("\n");

        System.out.println("Horários do(a) professor(a): " + professor4.getNome());
        for ( Disciplina disciplina : professor4.getDisciplinasMinistradas() ) {
            System.out.println("- " + disciplina.getNome() + ": " + disciplina.getHorario());
        }

        System.out.print("\n ➡️ 3 - Quais os alunos de uma dada disciplina: \n\n");

        System.out.println("Alunos da disciplina: " + computacaoGrafica.getNome());
        for ( Aluno aluno : computacaoGrafica.getAlunosMatriculados() ) {
            System.out.println("- " +  aluno.getNome());
        }

        System.out.print("\n");

        System.out.println("Alunos da disciplina: " + interconexaoDeComputadores.getNome());
        for ( Aluno aluno : interconexaoDeComputadores.getAlunosMatriculados() ) {
            System.out.println("- " +  aluno.getNome());
        }

        System.out.print("\n ➡️ 4 - Quais as disciplinas de um aluno: \n\n");

        System.out.println("Disciplinas do(a) aluno(a): " + aluno1.getNome());
        for ( Disciplina disciplina : aluno1.getDisciplinasMatriculadas() ) {
            System.out.println("- " +  disciplina.getNome());
        }

        System.out.print("\n");

        System.out.println("Disciplinas do(a) aluno(a): " + aluno3.getNome());
        for ( Disciplina disciplina : aluno3.getDisciplinasMatriculadas() ) {
            System.out.println("- " +  disciplina.getNome());
        }

        System.out.print("\n ➡️ 5 - Quais os horários de um aluno: \n\n");

        System.out.println("Horários do(a) aluno(a): " + aluno1.getNome());
        for ( Disciplina disciplina : aluno1.getDisciplinasMatriculadas() ) {
            System.out.println("- " + disciplina.getNome() + ": " + disciplina.getHorario());
        }

        System.out.print("\n");

        System.out.println("Horários do(a) aluno(a): " + aluno3.getNome());
        for ( Disciplina disciplina : aluno3.getDisciplinasMatriculadas() ) {
            System.out.println("- " + disciplina.getNome() + ": " + disciplina.getHorario());
        }

        System.out.print("\n ➡️ 6 - Qual o número alunos de uma disciplina: \n\n");

        System.out.println("Número de alunos da disciplina " + engenhariaDeSoftwareII.getNome() + ": " + engenhariaDeSoftwareII.numeroDeAlunos());
        System.out.println("Número de alunos da disciplina " + sistemasOperacionais.getNome() + ": " + sistemasOperacionais.numeroDeAlunos());
        System.out.println("Número de alunos da disciplina " + computacaoGrafica.getNome() + ": " + computacaoGrafica.numeroDeAlunos());
        System.out.println("Número de alunos da disciplina " + gerenciaDeProjetos.getNome() + ": " + gerenciaDeProjetos.numeroDeAlunos());
        System.out.println("Número de alunos da disciplina " + interconexaoDeComputadores.getNome() + ": " + interconexaoDeComputadores.numeroDeAlunos() );
        System.out.println("Número de alunos da disciplina " + inteligenciaArtificial.getNome() + ": " + inteligenciaArtificial.numeroDeAlunos());
    }
}