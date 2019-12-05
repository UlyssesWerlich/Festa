/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package festa.dao;

import festa.entidade.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Administrador
 */
public class ClienteDAO {

    public void adicionarCliente(Cliente cliente) {
        try {
            Connection con = FabricaConexao.getConexao();
            PreparedStatement stmt = con.prepareStatement("insert into cliente(nome, cpf, telefone, email,"
                    + "estado, cidade, logradouro, dataNascimento, ativo) values(?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getEmail());
            stmt.setString(5, cliente.getEstado());
            stmt.setString(6, cliente.getCidade());
            stmt.setString(7, cliente.getLogradouro());
            stmt.setDate(8, cliente.getDataNascimento());
            stmt.setBoolean(9, cliente.isAtivo());
            stmt.execute();
            FabricaConexao.fechaConexao(con, stmt);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha ao gravar cliente, " + e.getMessage());
        }
    }

    public void removerCliente(int idCliente) {
        try {
            Connection con = FabricaConexao.getConexao();
            PreparedStatement stmt = con.prepareStatement("update cliente set ativo=? where idCliente = ?");
            stmt.setBoolean(1, false);
            stmt.setInt(2, idCliente);
            stmt.execute();
            FabricaConexao.fechaConexao(con, stmt);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha ao remover cliente");
        }
    }

    public void deletarCliente(int idCliente) {
        try {
            Connection con = FabricaConexao.getConexao();
            PreparedStatement stmt = con.prepareStatement("delete from cliente where idCliente = ?");
            stmt.setInt(1, idCliente);
            stmt.execute();
            FabricaConexao.fechaConexao(con, stmt);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha ao deletar cliente");
        }
    }

    public void alterarCliente(Cliente cliente) {
        try {
            Connection con = FabricaConexao.getConexao();
            PreparedStatement stmt = con.prepareStatement("update cliente "
                    + "set nome=?, cpf=?, telefone=?, email=?, estado=?,"
                    + " cidade=?, logradouro=?, dataNascimento=? where idCliente=?");
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getEmail());
            stmt.setString(5, cliente.getEstado());
            stmt.setString(6, cliente.getCidade());
            stmt.setString(7, cliente.getLogradouro());
            stmt.setDate(8, cliente.getDataNascimento());
            stmt.setInt(9, cliente.getIdCliente());
            stmt.execute();
            FabricaConexao.fechaConexao(con, stmt);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha ao alterar cliente" + e.getMessage());
        }
    }

    public Cliente getCliente(int idCliente) {
        Cliente cliente = new Cliente();
        try {
            Connection con = FabricaConexao.getConexao();
            PreparedStatement stmt = con.prepareStatement("select * from cliente where idCliente = ?");
            stmt.setInt(1, idCliente);
            ResultSet rs = stmt.executeQuery();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date data;
            while (rs.next()) {
                cliente.setIdCliente(rs.getInt("IdCliente"));
                data = format.parse(rs.getString("dataNascimento"));
                cliente.set(rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("telefone"),
                        rs.getString("email"),
                        rs.getString("estado"),
                        rs.getString("cidade"),
                        rs.getString("logradouro"),
                        new java.sql.Date(data.getTime()),
                        rs.getBoolean("ativo"));
            }
            FabricaConexao.fechaConexao(con, stmt, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha ao listar clientes");
        }
        return cliente;
    }

    public Cliente getClienteCpf(String cpf) {
        Cliente cliente = new Cliente();
        try {
            Connection con = FabricaConexao.getConexao();
            PreparedStatement stmt = con.prepareStatement("select * from cliente where cpf like ? and ativo = ?");
            stmt.setString(1, "%" + cpf + "%");
            stmt.setBoolean(2, true);
            ResultSet rs = stmt.executeQuery();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date data;
            while (rs.next()) {
                cliente.setIdCliente(rs.getInt("IdCliente"));
                data = format.parse(rs.getString("dataNascimento"));
                cliente.set(rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("telefone"),
                        rs.getString("email"),
                        rs.getString("estado"),
                        rs.getString("cidade"),
                        rs.getString("logradouro"),
                        new java.sql.Date(data.getTime()),
                        rs.getBoolean("ativo"));
            }
            FabricaConexao.fechaConexao(con, stmt, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha ao listar clientes");
        }
        return cliente;
    }

    public ArrayList<Cliente> listarClientes() {
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        try {
            Connection con = FabricaConexao.getConexao();
            PreparedStatement stmt = con.prepareStatement("select IdCliente, nome, cpf,"
                    + "telefone, estado, cidade from cliente where ativo = ?");
            stmt.setBoolean(1, true);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("IdCliente"));
                cliente.setLista(rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("telefone"),
                        rs.getString("estado"),
                        rs.getString("cidade"));
                clientes.add(cliente);
            }
            FabricaConexao.fechaConexao(con, stmt, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha ao listar clientes");
        }
        return clientes;
    }

    public ArrayList<Cliente> consultarClientes(String nome) {
        // String cpf, String telefone, 
        //  String estado, String cidade, String logradouro
        ArrayList<Cliente> clientes = new ArrayList<>();
        try {
            Connection con = FabricaConexao.getConexao();
            PreparedStatement stmt = con.prepareStatement("select IdCliente, nome, cpf,"
                    + "telefone, estado, cidade from cliente where nome like ? and ativo = ?");
            stmt.setString(1, "%" + nome + "%");
            stmt.setBoolean(2, true);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("IdCliente"));

                cliente.setLista(rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("telefone"),
                        rs.getString("estado"),
                        rs.getString("cidade"));

                clientes.add(cliente);
            }
            FabricaConexao.fechaConexao(con, stmt, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha ao listar clientes");
        }
        return clientes;
    }
}
