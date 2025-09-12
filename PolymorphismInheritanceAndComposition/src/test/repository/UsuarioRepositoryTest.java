package test.repository;

import model.usuario.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioRepositoryTest {

    private UsuarioRepository repository;

    @BeforeEach
    void setUp() {
        repository = new UsuarioRepository();
    }

    @Test
    void deveAdicionarUsuario() {
        Usuario usuario = new Usuario("Lucas", "lucas@email.com", "123456789");
        repository.adicionarUsuario(usuario);

        List<Usuario> usuarios = repository.listarUsuarios();
        assertEquals(1, usuarios.size());
        assertEquals(usuario, usuarios.get(0));
    }

    @Test
    void deveBuscarUsuarioPorEmail() {
        Usuario usuario = new Usuario("Lucas", "lucas@email.com", "123456789");
        repository.adicionarUsuario(usuario);

        Optional<Usuario> encontrado = repository.buscarPorEmail("lucas@email.com");
        assertTrue(encontrado.isPresent());
        assertEquals(usuario, encontrado.get());

        Optional<Usuario> naoEncontrado = repository.buscarPorEmail("naoexiste@email.com");
        assertFalse(naoEncontrado.isPresent());
    }

    @Test
    void deveListarTodosUsuarios() {
        Usuario u1 = new Usuario("Lucas", "lucas@email.com", "123");
        Usuario u2 = new Usuario("Matheus", "matheus@email.com", "456");
        repository.adicionarUsuario(u1);
        repository.adicionarUsuario(u2);

        List<Usuario> usuarios = repository.listarUsuarios();
        assertEquals(2, usuarios.size());
        assertTrue(usuarios.contains(u1));
        assertTrue(usuarios.contains(u2));
    }

    @Test
    void deveRemoverUsuario() {
        Usuario usuario = new Usuario("Lucas", "lucas@email.com", "123456789");
        repository.adicionarUsuario(usuario);
        repository.removerUsuario(usuario);

        List<Usuario> usuarios = repository.listarUsuarios();
        assertTrue(usuarios.isEmpty());
    }
}
