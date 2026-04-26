/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.dao;

import br.ulbra.model.Produto;
import java.util.List;

public interface ProdutoDAO {

    void salvar(Produto produto);

    List<Produto> listar();

    Produto buscarPorId(Long id);

    void atualizar(Produto produto);

    void deletar(Long id);
}
