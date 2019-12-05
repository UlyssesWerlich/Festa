/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package festa.dao;

import festa.entidade.Item;
import festa.entidade.Tema;
import festa.entidade.TemaItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class TemaDAO {

    public void adicionarTema(Tema tema) {
        try {
            Connection con = FabricaConexao.getConexao();

            PreparedStatement stmt = con.prepareStatement("insert into tema(nome, descricao, precoAluguel, ativo)"
                    + " values(?,?,?,?)");
            stmt.setString(1, tema.getNome());
            stmt.setString(2, tema.getDescricao());
            stmt.setDouble(3, tema.getPrecoAluguel());
            stmt.setBoolean(4, true);
            stmt.execute();
            FabricaConexao.fechaConexao(con, stmt);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha ao gravar tema, " + e.getMessage());
        }
    }

    public void removerTema(int idTema) {
        try {
            Connection con = FabricaConexao.getConexao();
            PreparedStatement stmt = con.prepareStatement("update tema set ativo = ? where idTema = ?");
            stmt.setBoolean(1, false);
            stmt.setInt(2, idTema);
            stmt.execute();
            FabricaConexao.fechaConexao(con, stmt);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha ao remover tema");
        }
    }
    
    public void deletarTema(int idTema) {
        try {
            Connection con = FabricaConexao.getConexao();
            PreparedStatement stmt = con.prepareStatement("delete from tema where idTema = ?");
            stmt.setInt(1, idTema);
            stmt.execute();
            FabricaConexao.fechaConexao(con, stmt);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha ao remover tema");
        }
    }

    public void alterarTema(Tema tema) {
        try {
            Connection con = FabricaConexao.getConexao();
            PreparedStatement stmt = con.prepareStatement("update tema "
                    + "set nome=?, descricao=?, precoAluguel=? where idTema=?");
            stmt.setString(1, tema.getNome());
            stmt.setString(2, tema.getDescricao());
            stmt.setDouble(3, tema.getPrecoAluguel());
            stmt.setInt(4, tema.getIdTema());
            stmt.execute();
            FabricaConexao.fechaConexao(con, stmt);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha ao alterar tema" + e.getMessage());
        }
    }

    public Tema getTema(int idTema) {
        Tema tema = new Tema();
        try {
            Connection con = FabricaConexao.getConexao();
            PreparedStatement stmt = con.prepareStatement("select * from tema where idTema = ?");
            stmt.setInt(1, idTema);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                tema.setIdTema(rs.getInt("idTema"));
                tema.set(rs.getString("nome"), 
                        rs.getString("descricao"), 
                        rs.getDouble("precoAluguel"), 
                        true);
            }
            FabricaConexao.fechaConexao(con, stmt, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha ao pegar tema");
        }
        return tema;
    }

    public ArrayList<Tema> listarTemas() {
        ArrayList<Tema> temas = new ArrayList<>();
        try {
            Connection con = FabricaConexao.getConexao();
            PreparedStatement stmt = con.prepareStatement("select * from tema where ativo = ?");
            stmt.setBoolean(1, true);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Tema tema = new Tema();
                tema.setIdTema(rs.getInt("idTema"));
                tema.set(rs.getString("nome"), 
                        rs.getString("descricao"), 
                        rs.getDouble("precoAluguel"), 
                        true);
                temas.add(tema);
            }
            FabricaConexao.fechaConexao(con, stmt, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha ao listar temas");
        }
        return temas;
    }

    public ArrayList<Tema> consultarTemas(String nome) {
        ArrayList<Tema> temas = new ArrayList<>();
        try {
            Connection con = FabricaConexao.getConexao();
            PreparedStatement stmt = con.prepareStatement("select * from tema where nome like ? and ativo = ?");
            stmt.setString(1, "%" + nome + "%");
            stmt.setBoolean(2, true);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Tema tema = new Tema();
                tema.setIdTema(rs.getInt("idTema"));
                tema.set(rs.getString("nome"), 
                        rs.getString("descricao"), 
                        rs.getDouble("precoAluguel"), 
                        true);
                temas.add(tema);
            }
            FabricaConexao.fechaConexao(con, stmt, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha ao listar temas");
        }
        return temas;
    }

    public ArrayList<TemaItem> listarTemaItemPorTema(int idTema) {
        ArrayList<TemaItem> tis = new ArrayList<>();
        try {
            Connection con = FabricaConexao.getConexao();
            PreparedStatement stmt = con.prepareStatement("select * from temaitem t "
                    + "join item i on t.idItem = i.idItem where idTema=?");
            stmt.setInt(1, idTema);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Item item = new Item();
                item.setNome(rs.getString("i.nome"));
                item.setIdItem(rs.getInt("i.idItem"));
                item.setPreco(rs.getDouble("i.preco"));
                TemaItem ti = new TemaItem();
                ti.setId(rs.getInt("id"));
                ti.setItem(item);
                tis.add(ti);
            }
            FabricaConexao.fechaConexao(con, stmt, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return tis;
    }

    public void removerTemaItem(int idTema) {
        try {
            Connection con = FabricaConexao.getConexao();
            PreparedStatement stmt = con.prepareStatement("delete from temaitem where idTema = ?");
            stmt.setInt(1, idTema);
            stmt.execute();
            FabricaConexao.fechaConexao(con, stmt);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha ao registrar itens no tema , Mensagem:\n" + e.getMessage());
        }
    }

    public void adicionarListaTemaItem(ArrayList<Integer> idItens, int idTema) {
        try {
            Connection con = FabricaConexao.getConexao();
            PreparedStatement stmt = con.prepareStatement("insert into temaitem(idTema, idItem) values(?,?)");
            for (int i : idItens){
                stmt.setInt(1, idTema);
                stmt.setInt(2, i);
                stmt.execute();
            }
            FabricaConexao.fechaConexao(con, stmt);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha ao registrar itens no tema" + e.getMessage());
        }
    }
}
