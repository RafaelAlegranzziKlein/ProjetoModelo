package br.ulbra.dao;

/**
 *
 * @author Rafael
 */
import br.ulbra.model.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ClienteDAOImpl implements ClienteDAO {

    @Override
    public void salvar(Cliente cliente) {
        String sql = "INSERT INTO cliente(nomeclien, cpf, datanasc) VALUES(?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNomeclien());
            stmt.setString(2, cliente.getCpf());

            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate data = LocalDate.parse(cliente.getDatanasc(), formato);

            stmt.setDate(3, Date.valueOf(data));

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Cliente> listar() {
        String sql = "SELECT * FROM cliente ";
        List<Cliente> lista = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Cliente u = new Cliente(
                        rs.getLong("id"),
                        rs.getString("nomeclien"),
                        rs.getString("cpf"),
                        rs.getString("datanasc")
                );
                lista.add(u);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    @Override
    public Cliente buscarPorId(Long id) {
        String sql = "SELECT * FROM cliente WHERE id =  ? ";
        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Cliente(
                        rs.getLong("id"),
                        rs.getString("nomeclien"),
                        rs.getString("cpf"),
                        rs.getString("datanasc")
                );
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void atualizar(Cliente cliente) {

        String sql = "UPDATE cliente SET nomeclien = ?, cpf = ?, datanasc = ? WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNomeclien());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getDatanasc());
            stmt.setLong(4, cliente.getId());
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deletar(Long id) {
        String sql = "DELETE FROM cliente WHERE id =  ?";

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
