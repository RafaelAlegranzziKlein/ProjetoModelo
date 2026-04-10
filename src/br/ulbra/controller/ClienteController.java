package br.ulbra.controller;

/**
 *
 * @author Rafael
 */


import br.ulbra.dao.ClienteDAOImpl;
import br.ulbra.model.Cliente;
import br.ulbra.service.ClienteService;
import java.util.List;


public class ClienteController {
        private ClienteService service;

    public ClienteController() {
        this.service = new ClienteService(new ClienteDAOImpl());
    }

    public String cadastrar(String nomeclien, String cpf , String datanasc) {
        try {

            Cliente cliente = new Cliente();
            cliente.setNomeclien(nomeclien);
            cliente.setCpf(cpf);
            cliente.setDatanasc(datanasc);
            service.cadastrar(cliente);
            return "Cliente cadastrado com sucesso";
        } catch (Exception e) {
            return "Erro:" + e.getMessage();
        }
    }

    public List<Cliente> listar() {
        return service.listar();
    }

    public String atualizar(Long id, String nomeclien, String cpf , String datanasc) {
        try {
            Cliente cliente = new Cliente(id, nomeclien, cpf, datanasc);
            service.atualizar(cliente);
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
