package factory;

import model.usuario.Usuario;
import model.usuario.IPassageiro;
import model.usuario.IMotorista;
import model.usuario.IAdministrador;
import model.veiculo.Veiculo;
import model.pagamento.Pagamento;

import java.util.List;

public class UsuarioFactory {

    // Cria um usuário com funções e listas opcionais de veículos e pagamentos
    public static Usuario criarUsuario(String nome, String email, String telefone,
                                       List<IPassageiro> funcoesPassageiro,
                                       List<IMotorista> funcoesMotorista,
                                       List<IAdministrador> funcoesAdministrador,
                                       List<Veiculo> veiculos,
                                       List<Pagamento> pagamentos) {
        Usuario usuario = new Usuario(nome, email, telefone);

        if(funcoesPassageiro != null) {
            funcoesPassageiro.forEach(usuario::addPassageiroFunc);
        }

        if(funcoesMotorista != null) {
            funcoesMotorista.forEach(usuario::addMotoristaFunc);
        }

        if(funcoesAdministrador != null) {
            funcoesAdministrador.forEach(usuario::addAdministradorFunc);
        }

        if(veiculos != null) {
            veiculos.forEach(usuario::addVeiculo);
        }

        if(pagamentos != null) {
            pagamentos.forEach(usuario::addPagamento);
        }

        return usuario;
    }
}
