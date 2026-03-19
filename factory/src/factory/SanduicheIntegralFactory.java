package factory;

import entity.*;
import interfaces.*;

public class SanduicheIntegralFactory implements SanduicheFactory {
    @Override
    public SanduicheFactory criarFactory() {
        return new SanduicheIntegralFactory();
    }

    @Override
    public Pao criarPao(){
        return new PaoIntegral();
    }

    @Override
    public Queijo criarQueijo(){
        return new QueijoMussarela();
    }

    @Override
    public Presunto criarPresunto(){
        return new PresuntoPeru();
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
