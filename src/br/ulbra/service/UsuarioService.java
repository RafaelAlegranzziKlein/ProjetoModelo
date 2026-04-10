package br.ulbra.service;

import br.ulbra.dao.UsuarioDAO;
import br.ulbra.model.Usuario;
import java.util.List;

public class UsuarioService {

    private UsuarioDAO dao;

    public UsuarioService(UsuarioDAO dao) {
        this.dao = dao;
    }

    public void cadastrar(Usuario usuario) {
        if (usuario.getNome() == null || usuario.getNome().isEmpty()) {
            throw new RuntimeException("Nome obrigatório");
        }
        if (usuario.getEmail() == null
                || !usuario.getEmail().contains("@")) {
            throw new RuntimeException( "Email inválido");
        }
        dao.salvar(usuario);
    }
    public List
    <Usuario>listar() {
        return dao.listar();
    }

    public void atualizar(Usuario usuario) {
        dao.atualizar(usuario);
    }

    public void deletar(Long id) {
        dao.deletar(id);
    }

    public Usuario buscar(Long id) {
        return dao.buscarPorId(id);
    }
}
