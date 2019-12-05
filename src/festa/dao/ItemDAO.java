/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package festa.dao;

import festa.entidade.Item;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class ItemDAO {
    
    public boolean adicionarItem(Item item){
        try {
            Connection con = FabricaConexao.getConexao();
            
            PreparedStatement stmt = con.prepareStatement("insert into item(nome, descricao, preco, ativo)"
                    + " values(?,?,?,?)");
            stmt.setString(1, item.getNome());
            stmt.setString(2, item.getDescricao());
            stmt.setDouble(3, item.getPreco());
            stmt.setBoolean(4, true);
            stmt.execute();
            FabricaConexao.fechaConexao(con, stmt);     
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean deletarItem(int idItem){
        try{
            Connection con = FabricaConexao.getConexao();
            PreparedStatement stmt = con.prepareStatement("delete from item where idItem = ?");
            stmt.setInt(1, idItem);
            stmt.execute();
            FabricaConexao.fechaConexao(con, stmt);
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean removerItem(int idItem){
        try{
            Connection con = FabricaConexao.getConexao();
            PreparedStatement stmt = con.prepareStatement("update item set ativo = ? where idItem = ?");
            stmt.setBoolean(1, false);
            stmt.setInt(2, idItem);
            stmt.execute();
            FabricaConexao.fechaConexao(con, stmt);
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean alterarItem(Item item){
        try {
            Connection con = FabricaConexao.getConexao();
            PreparedStatement stmt = con.prepareStatement("update item "
                    + "set nome=?, descricao=?, preco=? where idItem=?");
            stmt.setString(1, item.getNome());
            stmt.setString(2, item.getDescricao());
            stmt.setDouble(3, item.getPreco());
            stmt.setInt(4, item.getIdItem());
            stmt.execute();
            FabricaConexao.fechaConexao(con, stmt);
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public Item getItem(int idItem) throws java.sql.SQLException{                
        Item item = new Item();
        try {
            Connection con = FabricaConexao.getConexao();
            PreparedStatement stmt = con.prepareStatement("select * from item where idItem = ?");
            stmt.setInt(1, idItem);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                item.setIdItem(rs.getInt("idItem"));
                item.set(rs.getString("nome"), rs.getString("descricao"), rs.getDouble("preco"), true);
            }
            FabricaConexao.fechaConexao(con, stmt, rs);
        } catch (Exception e){
            e.printStackTrace();
            throw new java.sql.SQLException(e);
        }
        return item;
    }
    
    public ArrayList<Item> listarItens(){
        ArrayList <Item> itens = new ArrayList<Item>();
        try {
            Connection con = FabricaConexao.getConexao();
            PreparedStatement stmt = con.prepareStatement("select * from item where ativo = ?");
            stmt.setBoolean(1, true);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Item item = new Item();
                item.setIdItem(rs.getInt("idItem"));
                item.set(rs.getString("nome"), rs.getString("descricao"), rs.getDouble("preco"), true);
                itens.add(item); 
            }
            FabricaConexao.fechaConexao(con, stmt, rs);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Falha ao listar itens");
        }
        return itens;
    }
    
        public ArrayList<Item> consultarItens(String nome){
            // String cpf, String telefone, 
            //  String estado, String cidade, String logradouro
        ArrayList <Item> itens = new ArrayList<>();
        try {
            Connection con = FabricaConexao.getConexao();
            PreparedStatement stmt = con.prepareStatement("select * from item where nome like ? and ativo = ?");
            stmt.setString(1, "%" + nome + "%");
            stmt.setBoolean(2, true);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Item item = new Item();
                item.setIdItem(rs.getInt("idItem"));
                item.set(rs.getString("nome"), rs.getString("descricao"), rs.getDouble("preco"), true);
                itens.add(item); 
            }
            FabricaConexao.fechaConexao(con, stmt, rs);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Falha ao listar clientes");
        }
        return itens;
    }
}