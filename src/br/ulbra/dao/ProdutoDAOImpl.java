/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.dao;

import br.ulbra.dao.ConnectionFactory;
import br.ulbra.model.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAOImpl implements ProdutoDAO {

    public void salvar(Produto produto) {
        String sql = "INSERT INTO produto (nome, codigoBarra, quantidade,"
                + "preco, categoria, ativo) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getCodigoBarra());
            stmt.setInt(3, produto.getQuantidade());
            stmt.setDouble(4, produto.getPreco());
            stmt.setString(5, produto.getCategoria());
            stmt.setBoolean(6, produto.isAtivo());
            stmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Produto> listar() {
        String sql = "SELECT * FROM produto";
        List<Produto> lista = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Produto u = new Produto(
                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getString("codigoBarra"),
                        rs.getInt("quantidade"),
                        rs.getDouble("preco"),
                        rs.getString("categoria"),
                        rs.getBoolean("ativo")
                );
                lista.add(u);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return lista;
    }

    public Produto buscarPorId(Long id) {
        String sql = "SELECT * FROM produto WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Produto(
                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getString("codigoBarra"),
                        rs.getInt("quantidade"),
                        rs.getDouble("preco"),
                        rs.getString("categoria"),
                        rs.getBoolean("ativo")
                );
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    public void atualizar(Produto produto) {
        String sql = "UPDATE produto SET nome = ?, codigoBarra = ?,"
                + "quantidade= ?, preco = ?, categoria = ?,"
                + "ativo=? WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getCodigoBarra());
            stmt.setInt(3, produto.getQuantidade());
            stmt.setDouble(4, produto.getPreco());
            stmt.setString(5, produto.getCategoria());
            stmt.setBoolean(6, produto.isAtivo());
            stmt.setLong(7, produto.getId());
            stmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deletar(Long id) {
        String sql = "DELETE FROM produto WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            stmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
