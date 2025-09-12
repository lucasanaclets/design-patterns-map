package app;

import factory.UsuarioFactory;
import factory.ViagemFactory;
import model.usuario.Usuario;
import model.veiculo.Veiculo;
import model.pagamento.Pagamento;
import model.viagem.Viagem;
import model.usuario.funcoes.PassageiroFunc;
import model.usuario.funcoes.MotoristaFunc;
import repository.UsuarioRepository;
import repository.ViagemRepository;
import service.UsuarioService;
import service.ViagemService;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // --- REPOSITORIES ---
        UsuarioRepository usuarioRepository = new UsuarioRepository();
        ViagemRepository viagemRepository = new ViagemRepository();

        // --- SERVICES ---
        UsuarioService usuarioService = new UsuarioService(usuarioRepository);
        ViagemService viagemService = new ViagemService(viagemRepository);

        // --- CRIANDO USUÁRIOS ---

        // Usuário 1: Motorista
        MotoristaFunc motoristaFunc1 = new MotoristaFunc("Lucas Anacleto");

        Usuario lucasAnacleto = UsuarioFactory.criarUsuario("Lucas Anacleto", "lucas@email.com", "(83) 9 9726-2837", null,
                List.of(motoristaFunc1), null, List.of(new Veiculo("Toyota", "Corolla", "ABC-1234", 2020)), null
        );

        usuarioService.cadastrarUsuario(lucasAnacleto);

        // Usuário 2: Passegeiro
        PassageiroFunc passageiroFunc1 = new PassageiroFunc("Matheus Abreu");

        Usuario matheusAbreu = UsuarioFactory.criarUsuario("Matheus Abreu", "matheus@email.com", "(83) 9 8394-3848", List.of(passageiroFunc1),
                null, null, null, List.of(new Pagamento("Pix", "Pagamento Instantaneo"))
        );

        usuarioService.cadastrarUsuario(matheusAbreu);

        // Usuário 3: Passageiro e Motorista
        PassageiroFunc passageiroFunc2 = new PassageiroFunc("Leandro Silva");
        MotoristaFunc motoristaFunc2 = new MotoristaFunc("Leandro Silva");

        Usuario leandroSilva = UsuarioFactory.criarUsuario("Leandro Silva", "leandro@email.com", "(83) 9 9834-2833", List.of(passageiroFunc2),
                List.of(motoristaFunc2), null, List.of(new Veiculo("Fiat", "Argo", "DEF-5678", 2022)),
                List.of(new Pagamento("Cartão de Crédito", "Visa"))
        );

        usuarioService.cadastrarUsuario(leandroSilva);

        // --- CRIANDO VIAGENS ---

        // UFCG -> UEPB

        Veiculo veiculoViagem1 = lucasAnacleto.getVeiculos().get(0);
        Pagamento metodoPagamentoViagem1 = matheusAbreu.getFormasPagamento().get(0);

        Viagem viagem1 = ViagemFactory.criarViagem(
                passageiroFunc1,
                motoristaFunc1,
                veiculoViagem1,
                metodoPagamentoViagem1,
                "Universidade Federal de Campina Grande",
                "Universidade Estadual da Paraiba",
                LocalDateTime.now(),
                10.50
        );

        // Registrar viagem
        viagemService.registrarViagem(viagem1);
        passageiroFunc1.solicitarViagem(viagem1);
        motoristaFunc1.aceitarViagem(viagem1);

        // UEPB -> PARTAGE SHOPPING

        Veiculo veiculoViagem2 = lucasAnacleto.getVeiculos().get(0);
        Pagamento metodoPagamentoViagem2 = leandroSilva.getFormasPagamento().get(0);

        Viagem viagem2 = ViagemFactory.criarViagem(
                passageiroFunc2,
                motoristaFunc1,
                veiculoViagem2,
                metodoPagamentoViagem2,
                "Universidade Estadual da Paraiba",
                "Shopping Partage de Campina Grande",
                LocalDateTime.now(),
                21.22
        );

        // Registrar viagem
        viagemService.registrarViagem(viagem2);
        passageiroFunc2.solicitarViagem(viagem2);
        motoristaFunc1.aceitarViagem(viagem2);

        // PARTAGE SHOPPING -> TERMINAL DE INTEGRAÇÃO CAMPINA GRANDE

        Veiculo veiculoViagem3 = leandroSilva.getVeiculos().get(0);
        Pagamento metodoPagamentoViagem3 = matheusAbreu.getFormasPagamento().get(0);

        Viagem viagem3 = ViagemFactory.criarViagem(
                passageiroFunc1,
                motoristaFunc2,
                veiculoViagem3,
                metodoPagamentoViagem3,
                "Shopping Partage de Campina Grande",
                "Terminal de Integração de Campina Grande",
                LocalDateTime.now(),
                15.79
        );

        // Registrar viagem
        viagemService.registrarViagem(viagem3);
        passageiroFunc1.solicitarViagem(viagem3);
        motoristaFunc2.aceitarViagem(viagem3);

        // --- IMPRIMINDO RESULTADOS ---
        System.out.println("\n--- USUÁRIOS CADASTRADOS ---");
        for (Usuario u : usuarioService.listarUsuarios()) {
            System.out.println("Nome: " + u.getNome() + " | Funções: " + u.getFuncoes());
            System.out.println("Veículos: " + u.getVeiculos());
            System.out.println("Formas de Pagamento: " + u.getFormasPagamento());
            System.out.println();
        }

        System.out.println("\n--- HISTÓRICO DE VIAGENS ---\n");

        System.out.println("Viagens do " + passageiroFunc1);
        for (Viagem v : passageiroFunc1.getHistoricoViagensComoPassageiro()) {
            System.out.println(v.exibirComoPassageiro());
        }

        System.out.println();

        System.out.println("Viagens do " + passageiroFunc2);
        for (Viagem v : passageiroFunc2.getHistoricoViagensComoPassageiro()) {
            System.out.println(v.exibirComoPassageiro());
        }

        System.out.println("\nViagens do " + motoristaFunc1);
        for (Viagem v : motoristaFunc1.getHistoricoViagensComoMotorista()) {
            System.out.println(v.exibirComoMotorista());
        }

        System.out.println("\nViagens do " + motoristaFunc2);
        for (Viagem v : motoristaFunc2.getHistoricoViagensComoMotorista()) {
            System.out.println(v.exibirComoMotorista());
        }

        System.out.println("\n--- TODAS AS VIAGENS NO SISTEMA ---");
        for (Viagem v : viagemService.listarTodasViagens()) {
            System.out.println(v);
        }
    }
}
