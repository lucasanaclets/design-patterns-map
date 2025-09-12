package test.service;

import model.usuario.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.UsuarioRepository;
import service.UsuarioService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioServiceTest {

    private UsuarioRepository repository;
    private UsuarioService service;

    @BeforeEach
    void setUp() {
        repository = new UsuarioRepository();
        service = new UsuarioService(repository);
    }

    @Test
    void deveCadastrarUsuarioQuandoEmailNaoExiste() {
        Usuario usuario = new Usuario("Lucas", "lucas@email.com", "123456789");
        service.cadastrarUsuario(usuario);

        List<Usuario> usuarios = service.listarUsuarios();
        assertEquals(1, usuarios.size());
        assertEquals(usuario, usuarios.get(0));
    }

    @Test
    void naoDeveCadastrarUsuarioComEmailDuplicado() {
        Usuario usuario1 = new Usuario("Lucas", "lucas@email.com", "123456789");
        Usuario usuario2 = new Usuario("Outro", "lucas@email.com", "987654321");

        service.cadastrarUsuario(usuario1);
        service.cadastrarUsuario(usuario2); // não deve ser adicionado

        List<Usuario> usuarios = service.listarUsuarios();
        assertEquals(1, usuarios.size());
        assertEquals(usuario1, usuarios.get(0));
    }

    @Test
    void deveBuscarUsuarioPorEmail() {
        Usuario usuario = new Usuario("Lucas", "lucas@email.com", "123456789");
        service.cadastrarUsuario(usuario);

        Usuario encontrado = service.buscarUsuarioPorEmail("lucas@email.com");
        assertNotNull(encontrado);
        assertEquals(usuario, encontrado);

        Usuario naoEncontrado = service.buscarUsuarioPorEmail("naoexiste@email.com");
        assertNull(naoEncontrado);
    }

    @Test
    void deveListarTodosUsuarios() {
        Usuario u1 = new Usuario("Lucas", "lucas@email.com", "123");
        Usuario u2 = new Usuario("Matheus", "matheus@email.com", "456");

        service.cadastrarUsuario(u1);
        service.cadastrarUsuario(u2);

        List<Usuario> usuarios = service.listarUsuarios();
        assertEquals(2, usuarios.size());
        assertTrue(usuarios.contains(u1));
        assertTrue(usuarios.contains(u2));
    }

    @Test
    void deveRemoverUsuario() {
        Usuario usuario = new Usuario("Lucas", "lucas@email.com", "123456789");
        service.cadastrarUsuario(usuario);

        service.removerUsuario(usuario);
        List<Usuario> usuarios = service.listarUsuarios();
        assertTrue(usuarios.isEmpty());
    }
}
