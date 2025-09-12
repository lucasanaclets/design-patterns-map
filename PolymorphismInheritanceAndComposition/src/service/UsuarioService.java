package service;

import model.usuario.Usuario;
import repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Cadastrar usuário
    public void cadastrarUsuario(Usuario usuario) {
        Optional<Usuario> existente = usuarioRepository.buscarPorEmail(usuario.getEmail());
        if (existente.isPresent()) {
            System.out.println("Usuário já cadastrado com este email: " + usuario.getEmail());
        } else {
            usuarioRepository.adicionarUsuario(usuario);
            System.out.println("Usuário cadastrado: " + usuario.getNome());
        }
    }

    // Buscar usuário por email
    public Usuario buscarUsuarioPorEmail(String email) {
        return usuarioRepository.buscarPorEmail(email).orElse(null);
    }

    // Listar todos os usuários
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.listarUsuarios();
    }

    // Remover usuário
    public void removerUsuario(Usuario usuario) {
        usuarioRepository.removerUsuario(usuario);
        System.out.println("Usuário removido: " + usuario.getNome());
    }
}
