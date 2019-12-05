/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package festa.dao;

import festa.entidade.Cliente;
import festa.entidade.Festa;
import festa.entidade.Tema;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class FestaDAO {

    /*
    private int idFesta;
    private double valor;
    private String status;
    private Cliente cliente;
    private Tema tema;
    private String estado;
    private String cidade;
    private String logradouro;
    private Date dataFesta;
    private int horaInicio;   
    private int horaFim;
    private String comentario;
     */
    public void adicionarFesta(Festa festa) {
        try {
            Connection con = FabricaConexao.getConexao();

            PreparedStatement stmt = con.prepareStatement("insert into festa(valor, situacao, cpfCliente, idTema, "
                    + "estado, cidade, logradouro, dataFesta, matutino, vespertino, noturno, comentario)"
                    + " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setDouble(1, festa.getValor());
            stmt.setInt(2, festa.getStatus());
            stmt.setString(3, festa.getCliente().getCpf());
            stmt.setInt(4, festa.getTema().getIdTema());
            stmt.setString(5, festa.getEstado());
            stmt.setString(6, festa.getCidade());
            stmt.setString(7, festa.getLogradouro());
            stmt.setDate(8, festa.getDataFesta());
            stmt.setBoolean(9, festa.isMatutino());
            stmt.setBoolean(10, festa.isVespertino());
            stmt.setBoolean(11, festa.isNoturno());
            stmt.setString(12, festa.getComentario());
            stmt.execute();
            FabricaConexao.fechaConexao(con, stmt);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha ao gravar festa, " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void removerFesta(int idFesta) {
        try {
            Connection con = FabricaConexao.getConexao();
            PreparedStatement stmt = con.prepareStatement("delete from festa where idFesta = ?");
            stmt.setInt(1, idFesta);
            stmt.execute();
            FabricaConexao.fechaConexao(con, stmt);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha ao remover festa");
        }
    }

    public void alterarFesta(Festa festa) {
        try {
            Connection con = FabricaConexao.getConexao();
            PreparedStatement stmt = con.prepareStatement("update festa "
                    + "set valor=?, situacao=?, cpfCliente=?, idTema=?, estado=?, cidade=?, logradouro=?"
                    + ", dataFesta=?, matutino = ?, vespertino = ?, noturno = ?, comentario=? where idFesta=?");
            stmt.setDouble(1, festa.getValor());
            stmt.setInt(2, festa.getStatus());
            stmt.setString(3, festa.getCliente().getCpf());
            stmt.setInt(4, festa.getTema().getIdTema());
            stmt.setString(5, festa.getEstado());
            stmt.setString(6, festa.getCidade());
            stmt.setString(7, festa.getLogradouro());
            stmt.setDate(8, festa.getDataFesta());
            stmt.setBoolean(9, festa.isMatutino());
            stmt.setBoolean(10, festa.isVespertino());
            stmt.setBoolean(11, festa.isNoturno());
            stmt.setString(12, festa.getComentario());
            stmt.setInt(13, festa.getIdFesta());
            stmt.execute();
            FabricaConexao.fechaConexao(con, stmt);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha ao alterar festa, " + e.getMessage());
        }
    }

    public Festa getFesta(int idFesta) {
        Festa festa = new Festa();
        Tema tema = new Tema();
        Cliente cliente = new Cliente();
        try {
            Connection con = FabricaConexao.getConexao();
            PreparedStatement stmt = con.prepareStatement("select * from festa f join cliente c on f.cpfCliente = c.cpf "
                    + "join tema t on f.idTema = t.idTema where idFesta = ?");
            stmt.setInt(1, idFesta);
            ResultSet rs = stmt.executeQuery();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date data;
            while (rs.next()) {
                tema.setIdTema(rs.getInt("t.idTema"));
                tema.set(rs.getString("t.nome"),
                        rs.getString("t.descricao"),
                        rs.getDouble("t.precoAluguel"),
                        rs.getBoolean("t.ativo"));

                data = format.parse(rs.getString("c.dataNascimento"));
                cliente.setIdCliente(rs.getInt("c.IdCliente"));
                cliente.set(rs.getString("c.nome"),
                        rs.getString("c.cpf"),
                        rs.getString("c.telefone"),
                        rs.getString("c.email"),
                        rs.getString("c.estado"),
                        rs.getString("c.cidade"),
                        rs.getString("c.logradouro"),
                        new java.sql.Date(data.getTime()),
                        rs.getBoolean("c.ativo"));

                data = format.parse(rs.getString("f.dataFesta"));
                festa.setIdFesta(rs.getInt("f.idFesta"));
                festa.set(rs.getDouble("f.valor"),
                        cliente,
                        tema,
                        rs.getString("f.estado"),
                        rs.getString("f.cidade"),
                        rs.getString("f.logradouro"),
                        new java.sql.Date(data.getTime()),
                        rs.getBoolean("f.matutino"),
                        rs.getBoolean("f.vespertino"),
                        rs.getBoolean("f.noturno"),
                        rs.getInt("f.situacao"),
                        rs.getString("f.comentario"));
            }
            FabricaConexao.fechaConexao(con, stmt, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha ao pegar festa");
        }
        return festa;
    }

    public ArrayList<Festa> listarFestas() {
        ArrayList<Festa> festas = new ArrayList<Festa>();
        try {
            Connection con = FabricaConexao.getConexao();
            PreparedStatement stmt = con.prepareStatement("select idFesta, c.nome, t.nome, f.dataFesta, "
                    + "f.valor, f.situacao from festa f join cliente c on f.cpfCliente = c.cpf "
                    + "join tema t on f.idTema = t.idTema where situacao < 4");
            ResultSet rs = stmt.executeQuery();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date data;
            while (rs.next()) {
                Festa festa = new Festa();
                Cliente c = new Cliente();
                c.setNome(rs.getString("c.nome"));
                Tema t = new Tema();
                t.setNome(rs.getString("t.nome"));
                festa.setIdFesta(rs.getInt("idFesta"));
                data = format.parse(rs.getString("dataFesta"));
                festa.setLista(rs.getDouble("valor"),
                        c,
                        t,
                        new java.sql.Date(data.getTime()),
                        rs.getInt("situacao"));
                festas.add(festa);
            }
            FabricaConexao.fechaConexao(con, stmt, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha ao listar festas");
        }
        return festas;
    }

    public ArrayList<Festa> consultarFestasPorData(LocalDate ldata) {
        ArrayList<Festa> festas = new ArrayList<>();
        try {
            ClienteDAO cdao = new ClienteDAO();
            TemaDAO tdao = new TemaDAO();
            Connection con = FabricaConexao.getConexao();
            PreparedStatement stmt = con.prepareStatement("select idFesta, c.nome, t.nome, f.dataFesta, "
                    + "f.valor, f.situacao from festa f join cliente c on f.cpfCliente = c.cpf "
                    + "join tema t on f.idTema = t.idTema where YEAR(dataFesta) = ? and MONTH(dataFesta) = ?");
            stmt.setInt(1, ldata.getYear());
            stmt.setInt(2, ldata.getMonthValue());
            ResultSet rs = stmt.executeQuery();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date data;
            while (rs.next()) {
                Festa festa = new Festa();
                Cliente c = new Cliente();
                c.setNome(rs.getString("c.nome"));
                Tema t = new Tema();
                t.setNome(rs.getString("t.nome"));
                festa.setIdFesta(rs.getInt("idFesta"));
                data = format.parse(rs.getString("dataFesta"));
                festa.setLista(rs.getDouble("valor"),
                        c,
                        t,
                        new java.sql.Date(data.getTime()),
                        rs.getInt("situacao"));
                festas.add(festa);
            }
            FabricaConexao.fechaConexao(con, stmt, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha ao listar festas");
            e.printStackTrace();
        }
        return festas;
    }

    public ArrayList<Festa> consultarFestas(String cpf, String status) {
        ArrayList<Festa> festas = new ArrayList<>();

        try {
            ClienteDAO cdao = new ClienteDAO();
            TemaDAO tdao = new TemaDAO();
            Connection con = FabricaConexao.getConexao();
            PreparedStatement stmt = con.prepareStatement("select idFesta, c.nome, t.nome, f.dataFesta, "
                    + "f.valor, f.situacao from festa f join cliente c on f.cpfCliente = c.cpf "
                    + "join tema t on f.idTema = t.idTemawhere cpfCliente like ? and situacao < 4");

            stmt.setString(1, (cpf.trim().length() == 14) ? cpf : "%");
            stmt.setString(2, (!status.equals("-")) ? status : "%");

            ResultSet rs = stmt.executeQuery();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date data;
            while (rs.next()) {
                Festa festa = new Festa();
                Cliente c = new Cliente();
                c.setNome(rs.getString("c.nome"));
                Tema t = new Tema();
                t.setNome(rs.getString("t.nome"));
                festa.setIdFesta(rs.getInt("idFesta"));
                data = format.parse(rs.getString("dataFesta"));
                festa.setLista(rs.getDouble("valor"),
                        c,
                        t,
                        new java.sql.Date(data.getTime()),
                        rs.getInt("situacao"));
                festas.add(festa);
            }
            FabricaConexao.fechaConexao(con, stmt, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha ao listar festas");
        }
        return festas;
    }
}

/*
create table festa(idFesta int(11) primary key not null unique auto_increment, 
valor decimal(7,2) not null,
cpfCliente varchar(14) not null,
idTema int(11) not null,
estado varchar(2) not null,
cidade varchar(20) not null,
logradouro varchar(50) not null,
dataFesta date not null,
matutino boolean,
vespertino boolean,
noturno boolean,
situacao varchar(15) not null,
comentario varchar(400));

 */
