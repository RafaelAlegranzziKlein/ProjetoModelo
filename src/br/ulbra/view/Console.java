/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.view;

import br.ulbra.controller.UsuarioController;
import br.ulbra.model.Usuario;

import java.util.List;
import java.util.Scanner;

public class Console {

    public static void main(String[] args) {

        UsuarioController controller = new UsuarioController();
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("\n1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Atualizar");
            System.out.println("4 - Deletar");
            System.out.println("0 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    System.out.println(controller.cadastrar(nome, email));
                    break;

                case 2:
                    List<Usuario> lista = controller.listar();
                    lista.forEach(u ->
                            System.out.println(u.getId() + " - " + u.getNome() + " - " + u.getEmail())
                    );
                    break;

                case 3:
                    System.out.print("ID: ");
                    Long id = scanner.nextLong();
                    scanner.nextLine();

                    System.out.print("Novo nome: ");
                    String novoNome = scanner.nextLine();

                    System.out.print("Novo email: ");
                    String novoEmail = scanner.nextLine();

                    System.out.println(controller.atualizar(id, novoNome, novoEmail));
                    break;

                case 4:
                    System.out.print("ID: ");
                    Long idDel = scanner.nextLong();

                    System.out.println(controller.deletar(idDel));
                    break;

                case 0:
                    System.exit(0);
            }
        }
    }
}

