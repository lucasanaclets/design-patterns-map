package factory;

import entity.*;
import interfaces.*;

public class SanduicheFrancesFactory implements SanduicheFactory {
    @Override
    public SanduicheFactory criarFactory() {
        return new SanduicheFrancesFactory();
    }

    @Override
    public Pao criarPao(){
        return new PaoFrances();
    }

    @Override
    public Queijo criarQueijo(){
        return new QueijoCheddar();
    }

    @Override
    public Presunto criarPresunto(){
        return new PresuntoFrango();
    }

    @Override
    public Ovo criarOvo(){
        return new OvoCapoeira();
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
