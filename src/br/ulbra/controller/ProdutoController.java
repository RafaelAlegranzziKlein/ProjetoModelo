package br.ulbra.controller;


import br.ulbra.dao.ProdutoDAOImpl;
import br.ulbra.service.ProdutoService;
import br.ulbra.model.Produto;

import java.util.List;

public class ProdutoController {

    private ProdutoService service;

    public ProdutoController() {
        this.service = new ProdutoService(new ProdutoDAOImpl());
    }

    public String cadastrar(String nome, String codigoBarra, int quantidade,
            double preco, String categoria, boolean ativo) {
        try {
            Produto produto = new Produto();
            produto.setNome(nome);
            produto.setCodigoBarra(codigoBarra);
            produto.setQuantidade(quantidade);
            produto.setPreco(preco);
            produto.setCategoria(categoria);
            produto.setAtivo(ativo);

            service.cadastrar(produto);
            return "Produto cadastrado com sucesso";

        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }

    public List<Produto> listar() {
        return service.listar();
    }

    public String atualizar(Long id, String nome, String codigoBarra, int quantidade,
            double preco, String categoria, boolean ativo) {
        try {
            Produto produto = new Produto(id, nome, codigoBarra, quantidade, preco,
                    categoria, ativo);
            service.atualizar(produto);
            return "Atualizado com sucesso";
        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }

    public String deletar(Long id) {
        try {
            service.deletar(id);
            return "Deletado com sucesso";
        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }

}