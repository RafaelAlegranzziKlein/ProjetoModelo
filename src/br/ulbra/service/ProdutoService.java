/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.service;

import br.ulbra.dao.ProdutoDAO;
import br.ulbra.model.Produto;
import java.util.List;

public class ProdutoService {

    private ProdutoDAO dao;

    public ProdutoService(ProdutoDAO dao) {
        this.dao = dao;
    }

    public void cadastrar(Produto produto) {

        if (produto.getNome() == null || produto.getNome().isEmpty()) {
            throw new RuntimeException("Nome obrigatório");
        }

        if (produto.getCodigoBarra() == null || produto.getCodigoBarra().isEmpty()
                || produto.getCodigoBarra().length() != 13) {
            throw new RuntimeException("Codigo de barra inválido inválido");
        }

        if (produto.getQuantidade() < 0) {
            throw new RuntimeException("Quantidade inválida");
        }

        if (produto.getPreco() < 0) {
            throw new RuntimeException("Preço inválido");
        }

        if (produto.getCategoria() == null || produto.getCategoria().isEmpty()) {
            throw new RuntimeException("Categoria inválida");
        }

        dao.salvar(produto);
    }

    public List<Produto> listar() {
        return dao.listar();
    }

    public void atualizar(Produto produto) {
        dao.atualizar(produto);
    }

    public void deletar(Long id) {
        dao.deletar(id);
    }

    public Produto buscar(Long id) {
        return dao.buscarPorId(id);
    }
}
