package entity;

import interfaces.Ovo;
import interfaces.Pao;
import interfaces.Presunto;
import interfaces.Queijo;

public class Sanduiche {
    protected Pao pao;
    protected Queijo queijo;
    protected Presunto presunto;
    protected Ovo ovo;
    protected Tomate tomate = new Tomate();

    @Override
    public String toString() {
        return pao + ", " + queijo + ", " + presunto + ", " + ovo + ", " + tomate;
    }

    public void setPao(Pao pao) {
        this.pao = pao;
    }

    public void setQueijo(Queijo queijo) {
        this.queijo = queijo;
    }

    public void setPresunto(Presunto presunto) {
        this.presunto = presunto;
    }

    public void setOvo(Ovo ovo) {
        this.ovo = ovo;
    }

}
