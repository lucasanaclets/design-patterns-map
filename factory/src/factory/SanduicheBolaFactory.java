package factory;

import entity.*;
import interfaces.*;

public class SanduicheBolaFactory implements SanduicheFactory {
    @Override
    public SanduicheFactory criarFactory() {
        return new SanduicheBolaFactory();
    }

    @Override
    public Pao criarPao(){
        return new PaoBola();
    }

    @Override
    public Queijo criarQueijo(){
        return new QueijoPrato();
    }

    @Override
    public Presunto criarPresunto(){
        return new PresuntoPeru();
    }

    @Override
    public Ovo criarOvo(){
        return new OvoGranja();
    }

    public Sanduiche preparar() {
        Sanduiche sanduiche = new Sanduiche();
        sanduiche.setPao(criarPao());
        sanduiche.setPresunto(criarPresunto());
        sanduiche.setQueijo(criarQueijo());
        sanduiche.setOvo(criarOvo());
        return sanduiche;
    }
}
