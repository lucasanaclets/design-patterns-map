package model.usuario;

import java.util.List;

import model.usuario.Usuario;

public interface IAdministrador {
    void gerenciarUsuario(Usuario usuario);
    void gerenciarPagamentos();
    void suporte();
    List<Usuario> listarUsuarios();
}
