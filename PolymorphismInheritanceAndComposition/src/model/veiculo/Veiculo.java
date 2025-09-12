package model.veiculo;

public class Veiculo {
    private String marca;
    private String modelo;
    private String placa;
    private int ano;

    public Veiculo(String marca, String modelo, String placa, int ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.ano = ano;
    }

    // Getters
    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public int getAno() {
        return ano;
    }

    @Override
    public String toString() {
        return marca + " " + modelo + " (" + placa + ")";
    }
}
