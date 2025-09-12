package model.usuario;

import java.util.ArrayList;
import java.util.List;

import model.veiculo.Veiculo;
import model.pagamento.Pagamento;

public class Usuario {
    private String nome;
    private String email;
    private String telefone;

    // Funções do usuário
    private List<IPassageiro> funcoesPassageiro = new ArrayList<>();
    private List<IMotorista> funcoesMotorista = new ArrayList<>();
    private List<IAdministrador> funcoesAdministrador = new ArrayList<>();

    // Composição
    private List<Veiculo> veiculos = new ArrayList<>();        // usado se for motorista
    private List<Pagamento> formasPagamento = new ArrayList<>(); // usado se for passageiro

    public Usuario(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    // Métodos básicos
    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    // Funções e composição
    public void addPassageiroFunc(IPassageiro p) {
        funcoesPassageiro.add(p);
    }

    public void addMotoristaFunc(IMotorista m) {
        funcoesMotorista.add(m);
    }

    public void addAdministradorFunc(IAdministrador a) {
        funcoesAdministrador.add(a);
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void addVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    public List<Pagamento> getFormasPagamento() {
        return formasPagamento;
    }

    public void addPagamento(Pagamento pagamento) {
        formasPagamento.add(pagamento);
    }

    // Retorna os papéis do usuário
    public List<String> getFuncoes() {
        List<String> papeis = new ArrayList<>();
        if(!funcoesPassageiro.isEmpty()) papeis.add("Passageiro");
        if(!funcoesMotorista.isEmpty()) papeis.add("Motorista");
        if(!funcoesAdministrador.isEmpty()) papeis.add("Administrador");
        return papeis;
    }
}
