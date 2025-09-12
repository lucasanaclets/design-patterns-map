package repository;

import model.usuario.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioRepository {
    private List<Usuario> usuarios = new ArrayList<>();

    // Adicionar usuário
    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    // Buscar por email
    public Optional<Usuario> buscarPorEmail(String email) {
        return usuarios.stream()
                .filter(u -> u.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }

    // Listar todos os usuários
    public List<Usuario> listarUsuarios() {
        return new ArrayList<>(usuarios);
    }

    // Remover usuário
    public void removerUsuario(Usuario usuario) {
        usuarios.remove(usuario);
    }
}
