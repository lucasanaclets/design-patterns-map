package model.viagem;

import model.usuario.IPassageiro;
import model.usuario.IMotorista;
import model.veiculo.Veiculo;
import model.pagamento.Pagamento;

import java.time.LocalDateTime;

public class Viagem {
    private IPassageiro passageiro;
    private IMotorista motorista;
    private Veiculo veiculo;
    private Pagamento pagamento;

    private String origem;
    private String destino;
    private LocalDateTime horario;
    private double valor;
    private int avaliacao; // 0 a 5 estrelas

    public Viagem(IPassageiro passageiro, IMotorista motorista, Veiculo veiculo, Pagamento pagamento,
                  String origem, String destino, LocalDateTime horario, double valor) {
        this.passageiro = passageiro;
        this.motorista = motorista;
        this.veiculo = veiculo;
        this.pagamento = pagamento;
        this.origem = origem;
        this.destino = destino;
        this.horario = horario;
        this.valor = valor;
        this.avaliacao = 0; // Avaliação inicial
    }

    // Getters
    public IPassageiro getPassageiro() {
        return passageiro;
    }

    public IMotorista getMotorista() {
        return motorista;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public String getOrigem() {
        return origem;
    }

    public String getDestino() {
        return destino;
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    public double getValor() {
        return valor;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    // Definir avaliação da viagem
    public void setAvaliacao(int avaliacao) {
        if(avaliacao < 0 || avaliacao > 5) {
            throw new IllegalArgumentException("Avaliação deve estar entre 0 e 5");
        }
        this.avaliacao = avaliacao;
    }

    @Override
    public String toString() {
        return String.format(
                "Origem: %s | Destino: %s | Horário: %s | Valor: R$ %.2f | Pagamento: %s | Veículo: %s | Avaliação: %d",
                origem,
                destino,
                horario,
                valor,
                pagamento,
                veiculo,
                avaliacao
        );
    }

    /**
     * Exibição no contexto do Passageiro
     */
    public String exibirComoPassageiro() {
        return String.format(
                "%s | Origem: %s | Destino: %s | Valor: R$ %.2f | Pagamento: %s | Veículo: %s",
                motorista,
                origem,
                destino,
                valor,
                pagamento,
                veiculo
        );
    }

    /**
     * Exibição no contexto do Motorista
     */
    public String exibirComoMotorista() {
        return String.format(
                "%s | Origem: %s | Destino: %s | Valor: R$ %.2f | Pagamento: %s",
                passageiro,
                origem,
                destino,
                valor,
                pagamento
        );
    }

}
