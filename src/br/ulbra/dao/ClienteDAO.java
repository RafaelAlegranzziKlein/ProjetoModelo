/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.dao;

/**
 *
 * @author Rafael
 */
import br.ulbra.model.Cliente;
import java.util.List;

public interface ClienteDAO {

    void salvar(Cliente cliente);

    List<Cliente> listar();

    Cliente buscarPorId(Long id);

    void atualizar(Cliente cliente);

    void deletar(Long id);
}
