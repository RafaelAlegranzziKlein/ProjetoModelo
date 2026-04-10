/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.service;

/**
 *
 * @author aluno.saolucas
 */
import br.ulbra.dao.ClienteDAO;
import br.ulbra.model.Cliente;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

public class ClienteService {

    private ClienteDAO dao;

    public ClienteService(ClienteDAO dao) {
        this.dao = dao;
    }

    public void cadastrar(Cliente cliente) {
        if (cliente.getNomeclien() == null || cliente.getNomeclien().isEmpty()) {
            throw new RuntimeException("Nome obrigatório");
        }
        if (cliente.getCpf() == null || cliente.getCpf().isEmpty()) {
            throw new RuntimeException("CPF obrigatório");
        }
        // Validação de CPF
        if (!isCPFValido(cliente.getCpf())) {
            throw new RuntimeException("CPF inválido");
        }

        // Validação de data no padrão BR
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate data = LocalDate.parse(cliente.getDatanasc(), formatter);

            // exemplo: não permitir data futura
            if (data.isAfter(LocalDate.now())) {
                throw new RuntimeException("Data de nascimento inválida");
            }

        } catch (DateTimeParseException e) {
            throw new RuntimeException("Data deve estar no formato dd/MM/yyyy");
        }
    }

    public List<Cliente> listar() {
        return dao.listar();
    }

    public void atualizar(Cliente cliente) {
        dao.atualizar(cliente);
    }

    public void deletar(Long id) {
        dao.deletar(id);
    }

    public Cliente buscar(Long id) {
        return dao.buscarPorId(id);
    }
    
    private boolean isCPFValido(String cpf) {
    cpf = cpf.replaceAll("[^0-9]", "");

    if (cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) {
        return false;
    }

    try {
        int soma = 0;
        int peso = 10;

        for (int i = 0; i < 9; i++) {
            soma += (cpf.charAt(i) - '0') * peso--;
        }

        int digito1 = 11 - (soma % 11);
        if (digito1 >= 10) digito1 = 0;

        soma = 0;
        peso = 11;

        for (int i = 0; i < 10; i++) {
            soma += (cpf.charAt(i) - '0') * peso--;
        }

        int digito2 = 11 - (soma % 11);
        if (digito2 >= 10) digito2 = 0;

        return digito1 == (cpf.charAt(9) - '0') &&
               digito2 == (cpf.charAt(10) - '0');

    } catch (Exception e) {
        return false;
    }
}
}
