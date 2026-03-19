package main;

import entity.Sanduiche;
import factory.*;
import interfaces.*;

public class Main {
    public static void main(String[] args) {
        SanduicheFactory[] factories = {
                new SanduicheIntegralFactory(),
                new SanduicheFrancesFactory(),
                new SanduicheBolaFactory()
        };

        for (SanduicheFactory factory : factories) {
            Sanduiche sanduiche = factory.preparar();
            System.out.println(sanduiche);
        }
    }
}