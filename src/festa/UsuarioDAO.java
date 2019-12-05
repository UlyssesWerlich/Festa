/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package festa;

import festa.dao.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class UsuarioDAO {

    public void adicionarUsuario(Usuario usuario) {
        /*String nome, String cpf, String cargo, Date dataNascimento, String telefone, String email
                        , String estado, String cidade, String logradouro, String senha, boolean cadastrarCliente
                        , boolean consultarCliente, boolean cadastrarFesta, boolean consultarFesta, boolean cadastrarTema
                        , boolean consultarTema, boolean cadastrarItem, boolean consultarItem, boolean cadastrarUsuario
                        , boolean consultarUsuario*/

        try {
            Connection con = FabricaConexao.getConexao();

            PreparedStatement stmt = con.prepareStatement("insert into usuario(nome, cpf, cargo, dataNascimento,"
                    + "telefone, email, estado, cidade, logradouro, senha, cadastrarCliente, consultarCliente,"
                    + "cadastrarFesta, consultarFesta, cadastrarTema, consultarTema, cadastrarItem, consultarItem,"
                    + " cadastrarUsuario, consultarUsuario) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getCpf());
            stmt.setString(3, usuario.getCargo());
            stmt.setDate(4, usuario.getDataNascimento());
            stmt.setString(5, usuario.getTelefone());
            stmt.setString(6, usuario.getEmail());
            stmt.setString(7, usuario.getEstado());
            stmt.setString(8, usuario.getCidade());
            stmt.setString(9, usuario.getLogradouro());
            stmt.setString(10, "123456");
            stmt.setBoolean(11, usuario.isCadastrarCliente());
            stmt.setBoolean(12, usuario.isConsultarCliente());
            stmt.setBoolean(13, usuario.isCadastrarFesta());
            stmt.setBoolean(14, usuario.isConsultarFesta());
            stmt.setBoolean(15, usuario.isCadastrarTema());
            stmt.setBoolean(16, usuario.isConsultarTema());
            stmt.setBoolean(17, usuario.isCadastrarItem());
            stmt.setBoolean(18, usuario.isConsultarItem());
            stmt.setBoolean(19, usuario.isCadastrarUsuario());
            stmt.setBoolean(20, usuario.isConsultarUsuario());
            stmt.execute();
            FabricaConexao.fechaConexao(con, stmt);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha ao gravar usuário, " + e.getMessage());
        }
    }

    public void removerUsuario(int idUsuario) {
        try {
            Connection con = FabricaConexao.getConexao();
            PreparedStatement stmt = con.prepareStatement("delete from usuario where idUsuario = ?");
            stmt.setInt(1, idUsuario);
            stmt.execute();
            FabricaConexao.fechaConexao(con, stmt);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha ao remover usuario");
        }
    }

    public void alterarUsuario(Usuario usuario) {
        try {
            Connection con = FabricaConexao.getConexao();
            PreparedStatement stmt = con.prepareStatement("update usuario "
                    + "set nome=?, cpf=?, cargo=?, dataNascimento=?, telefone=?, email=?, estado=?, "
                    + "cidade=?, logradouro=?, cadastrarCliente=?, consultarCliente=?, "
                    + "cadastrarFesta=?, consultarFesta=?, cadastrarTema=?, consultarTema=?, cadastrarItem=?, "
                    + "consultarItem=?, cadastrarUsuario=?, consultarUsuario=? where idUsuario=?");

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getCpf());
            stmt.setString(3, usuario.getCargo());
            stmt.setDate(4, usuario.getDataNascimento());
            stmt.setString(5, usuario.getTelefone());
            stmt.setString(6, usuario.getEmail());
            stmt.setString(7, usuario.getEstado());
            stmt.setString(8, usuario.getCidade());
            stmt.setString(9, usuario.getLogradouro());
            stmt.setBoolean(10, usuario.isCadastrarCliente());
            stmt.setBoolean(11, usuario.isConsultarCliente());
            stmt.setBoolean(12, usuario.isCadastrarFesta());
            stmt.setBoolean(13, usuario.isConsultarFesta());
            stmt.setBoolean(14, usuario.isCadastrarTema());
            stmt.setBoolean(15, usuario.isConsultarTema());
            stmt.setBoolean(16, usuario.isCadastrarItem());
            stmt.setBoolean(17, usuario.isConsultarItem());
            stmt.setBoolean(18, usuario.isCadastrarUsuario());
            stmt.setBoolean(19, usuario.isConsultarUsuario());
            stmt.setInt(20,usuario.getIdUsuario());
            stmt.execute();
            FabricaConexao.fechaConexao(con, stmt);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha ao alterar usuário, " + e.getMessage());
        }
    }

    public Usuario getUsuario(int idUsuario) {
        Usuario usuario = new Usuario();
        try {
            Connection con = FabricaConexao.getConexao();
            PreparedStatement stmt = con.prepareStatement("select * from usuario where idUsuario = ?");
            stmt.setInt(1, idUsuario);
            ResultSet rs = stmt.executeQuery();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date data;
            while (rs.next()) {
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setSenha(rs.getString("senha"));
                data = format.parse(rs.getString("dataNascimento"));
                usuario.set(rs.getString("nome"),
                        rs.getString("cpf"), 
                        rs.getString("cargo"), 
                        new java.sql.Date(data.getTime()),
                        rs.getString("telefone"), 
                        rs.getString("email"), 
                        rs.getString("estado"), 
                        rs.getString("cidade"), 
                        rs.getString("logradouro"), 
                        rs.getBoolean("cadastrarCliente"), rs.getBoolean("consultarCliente"),
                        rs.getBoolean("cadastrarFesta"), rs.getBoolean("consultarFesta"), 
                        rs.getBoolean("cadastrarTema"), rs.getBoolean("consultarTema"), 
                        rs.getBoolean("cadastrarItem"), rs.getBoolean("consultarItem"),
                        rs.getBoolean("cadastrarUsuario"), rs.getBoolean("consultarUsuario"));
            }
            FabricaConexao.fechaConexao(con, stmt, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha ao listar clientes");
        }
        return usuario;
    }

    public Usuario getUsuarioCpf(String cpf) {
        Usuario usuario = new Usuario();
        try {
            Connection con = FabricaConexao.getConexao();
            PreparedStatement stmt = con.prepareStatement("select * from usuario where cpf like ?");
            stmt.setString(1, "%" + cpf + "%");
            ResultSet rs = stmt.executeQuery();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date data;
            while (rs.next()) {
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setSenha(rs.getString("senha"));
                data = format.parse(rs.getString("dataNascimento"));
                usuario.set(rs.getString("nome"),
                        rs.getString("cpf"), 
                        rs.getString("cargo"), 
                        new java.sql.Date(data.getTime()),
                        rs.getString("telefone"), 
                        rs.getString("email"), 
                        rs.getString("estado"), 
                        rs.getString("cidade"), 
                        rs.getString("logradouro"), 
                        rs.getBoolean("cadastrarCliente"), rs.getBoolean("consultarCliente"),
                        rs.getBoolean("cadastrarFesta"), rs.getBoolean("consultarFesta"), 
                        rs.getBoolean("cadastrarTema"), rs.getBoolean("consultarTema"), 
                        rs.getBoolean("cadastrarItem"), rs.getBoolean("consultarItem"),
                        rs.getBoolean("cadastrarUsuario"), rs.getBoolean("consultarUsuario"));
            }
            FabricaConexao.fechaConexao(con, stmt, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha ao listar usuario");
        }
        return usuario;
    }

    public ArrayList<Usuario> listarUsuarios() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try {
            Connection con = FabricaConexao.getConexao();
            PreparedStatement stmt = con.prepareStatement("select idUsuario, nome, cpf, "
                    + "dataNascimento, telefone, cargo from usuario");
            ResultSet rs = stmt.executeQuery();            
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date data;
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                data = format.parse(rs.getString("dataNascimento"));
                
                usuario.setLista(rs.getString("nome"), 
                        rs.getString("cpf"), 
                        rs.getString("telefone"), 
                        new java.sql.Date(data.getTime()), 
                        rs.getString("cargo"));

                usuarios.add(usuario);
            }
            FabricaConexao.fechaConexao(con, stmt, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha ao listar clientes");
        }
        return usuarios;
    }

    public ArrayList<Usuario> consultarUsuarios(String nome) {           
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try {
            Connection con = FabricaConexao.getConexao();
            PreparedStatement stmt = con.prepareStatement("select idUsuario, nome, cpf,"
                    + "dataNascimento, telefone, cargo from usuario where nome like ?");
            stmt.setString(1, "%" + nome + "%");
            ResultSet rs = stmt.executeQuery();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date data;
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                data = format.parse(rs.getString("dataNascimento"));
                
                usuario.setLista(rs.getString("nome"), 
                        rs.getString("cpf"), 
                        rs.getString("telefone"), 
                        new java.sql.Date(data.getTime()), 
                        rs.getString("cargo"));
                usuarios.add(usuario);
            }
            FabricaConexao.fechaConexao(con, stmt, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha ao listar usuarios");
        }
        return usuarios;
    }
    
    public void alterarSenha(String senha, int idUsuario){
        try {
            Connection con = FabricaConexao.getConexao();
            PreparedStatement stmt = con.prepareStatement("update usuario "
                    + "set senha = ? where idUsuario=?");
            stmt.setString(1, senha);
            stmt.setInt(2, idUsuario);
            stmt.execute();
            FabricaConexao.fechaConexao(con, stmt);
        } catch (Exception e){
            
        }
    }
    
    public void resetarSenha(int idUsuario){
        try {
            Connection con = FabricaConexao.getConexao();
            PreparedStatement stmt = con.prepareStatement("update usuario "
                    + "set senha = '123456' where idUsuario=?");
            stmt.setInt(1, idUsuario);
            stmt.execute();
            FabricaConexao.fechaConexao(con, stmt);
        } catch (Exception e){
            
        }
    }
}
