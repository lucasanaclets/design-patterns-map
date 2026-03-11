package app;

import controller.GuicheController;
import model.entities.Assento;
import model.entities.Onibus;
import view.PainelCentral;
import view.Quiosque;

public class Main {

    public static void main(String[] args) {

        System.out.println("====================================");
        System.out.println(" SISTEMA DA RODOVIÁRIA INICIADO ");
        System.out.println("====================================");

        // Criação do ônibus com 10 assentos
        Onibus onibus = new Onibus(10);

        // Views do sistema
        PainelCentral painelCentral = new PainelCentral();
        Quiosque quiosqueA = new Quiosque("A");
        Quiosque quiosqueB = new Quiosque("B");
        Quiosque quiosqueC = new Quiosque("C");

        // Registrando observers
        onibus.adicionarListener(painelCentral);
        onibus.adicionarListener(quiosqueA);
        onibus.adicionarListener(quiosqueB);
        onibus.adicionarListener(quiosqueC);

        // Controller
        GuicheController guiche = new GuicheController(onibus);

        System.out.println("\nTodos os sistemas conectados ao ônibus:");
        System.out.println("- Painel Central");
        System.out.println("- Quiosque A");
        System.out.println("- Quiosque B");
        System.out.println("- Quiosque C");

        // Mostrando estado inicial
        System.out.println("\n====================================");
        System.out.println("ESTADO INICIAL DOS ASSENTOS");
        System.out.println("====================================");

        for (Assento a : onibus.getAssentos()) {
            System.out.println("Assento " + a.getNumero() + " -> " + a.getStatus());
        }

        // Simulação de clientes no guichê

        System.out.println("\n====================================");
        System.out.println("CLIENTE 1 CHEGA AO GUICHÊ");
        System.out.println("====================================");

        guiche.reservarAssento(3);

        System.out.println("\n====================================");
        System.out.println("CLIENTE 2 CHEGA AO GUICHÊ");
        System.out.println("====================================");

        guiche.reservarAssento(5);

        System.out.println("\n====================================");
        System.out.println("CLIENTE 3 CHEGA AO GUICHÊ");
        System.out.println("====================================");

        guiche.comprarAssento(3);

        System.out.println("\n====================================");
        System.out.println("CLIENTE 4 CHEGA AO GUICHÊ");
        System.out.println("====================================");

        guiche.comprarAssento(7);

        System.out.println("\n====================================");
        System.out.println("CLIENTE 5 CHEGA AO GUICHÊ");
        System.out.println("====================================");

        guiche.reservarAssento(1);

        // Estado final

        System.out.println("\n====================================");
        System.out.println("ESTADO FINAL DOS ASSENTOS");
        System.out.println("====================================");

        for (Assento a : onibus.getAssentos()) {
            System.out.println("Assento " + a.getNumero() + " -> " + a.getStatus());
        }

        System.out.println("\n====================================");
        System.out.println("FIM DA SIMULAÇÃO");
        System.out.println("====================================");

    }
}