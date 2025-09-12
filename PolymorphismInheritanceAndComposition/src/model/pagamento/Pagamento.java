package model.pagamento;

public class Pagamento {
    private String tipo;
    private String descricao;

    public Pagamento(String tipo, String descricao) {
        this.tipo = tipo;
        this.descricao = descricao;
    }

    // Getters
    public String getTipo() {
        return tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return tipo + (descricao != null ? " - " + descricao : "");
    }
}
