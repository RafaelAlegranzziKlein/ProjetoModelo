/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.controller;

import br.ulbra.dao.UsuarioDAOImpl;
import br.ulbra.model.Usuario;
import br.ulbra.service.UsuarioService;
import java.util.List;

public class UsuarioController {

    private UsuarioService service;

    public UsuarioController() {
        this.service = new UsuarioService(new UsuarioDAOImpl());
    }

    public String cadastrar(String nome, String email) {
        try {

            Usuario usuario = new Usuario();
            usuario.setNome(nome);
            usuario.setEmail(email);
            service.cadastrar(usuario);
            return "Usuário cadastrado com sucesso";
        } catch (Exception e) {
            return "Erro:" + e.getMessage();
        }
    }

    public List<Usuario> listar() {
        return service.listar();
    }

    public String atualizar(Long id, String nome, String email) {
        try {
            Usuario usuario = new Usuario(id, nome, email);
            service.atualizar(usuario);
            return "Atualizado com sucesso";
        } catch (Exception e) {
            return "Erro:" + e.getMessage();
        }
    }

    public String deletar(Long id) {
        try {
            service.deletar(id);
            return  "Deletado com sucesso";
        } catch (Exception e) {
            return  " Erro:"+e.getMessage();
        }
    }
}
