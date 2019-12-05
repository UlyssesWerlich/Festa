/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package festa;

import java.sql.Date;

/**
 *
 * @author Administrador
 */
public class Usuario {

    private int idUsuario;
    private String nome;
    private String cpf;
    private String cargo;
    private Date dataNascimento;
    private String telefone;
    private String email;
    private String estado;
    private String cidade;
    private String logradouro;
    private char[] senha;
    private boolean cadastrarCliente;
    private boolean consultarCliente;
    private boolean cadastrarFesta;
    private boolean consultarFesta;
    private boolean cadastrarTema;
    private boolean consultarTema;
    private boolean cadastrarItem;
    private boolean consultarItem;
    private boolean cadastrarUsuario;
    private boolean consultarUsuario;

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public void setSenha(String ssenha){
        char[] senha = new char[ssenha.length()];
        for (int i = 0; i < ssenha.length(); i++){
            senha[i] = ssenha.charAt(i);
        }
        this.senha = senha;
    }
    
    public void setSenha(char[] senha){
        this.senha = senha;
    }
    
    public void setLista(String nome, String cpf, String telefone, Date dataNascimento, 
            String cargo) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.cargo = cargo;
    }        

    public void set(String nome, String cpf, String cargo, Date dataNascimento, String telefone, String email,
             String estado, String cidade, String logradouro, boolean cadastrarCliente,
             boolean consultarCliente, boolean cadastrarFesta, boolean consultarFesta, boolean cadastrarTema,
             boolean consultarTema, boolean cadastrarItem, boolean consultarItem, boolean cadastrarUsuario,
             boolean consultarUsuario) {
        this.nome = nome;
        this.cpf = cpf;
        this.cargo = cargo;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.email = email;
        this.estado = estado;
        this.cidade = cidade;
        this.logradouro = logradouro;
        this.cadastrarCliente = cadastrarCliente;
        this.consultarCliente = consultarCliente;
        this.cadastrarFesta = cadastrarFesta;
        this.consultarFesta = consultarFesta;
        this.cadastrarTema = cadastrarTema;
        this.consultarTema = consultarTema;
        this.cadastrarItem = cadastrarItem;
        this.consultarItem = consultarItem;
        this.cadastrarUsuario = cadastrarUsuario;
        this.consultarUsuario = consultarUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getCargo() {
        return cargo;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getEstado() {
        return estado;
    }

    public String getCidade() {
        return cidade;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public char[] getSenha() {
        return senha;
    }

    public boolean isCadastrarCliente() {
        return cadastrarCliente;
    }

    public boolean isConsultarCliente() {
        return consultarCliente;
    }

    public boolean isCadastrarFesta() {
        return cadastrarFesta;
    }

    public boolean isConsultarFesta() {
        return consultarFesta;
    }

    public boolean isCadastrarTema() {
        return cadastrarTema;
    }

    public boolean isConsultarTema() {
        return consultarTema;
    }

    public boolean isCadastrarItem() {
        return cadastrarItem;
    }

    public boolean isConsultarItem() {
        return consultarItem;
    }

    public boolean isCadastrarUsuario() {
        return cadastrarUsuario;
    }

    public boolean isConsultarUsuario() {
        return consultarUsuario;
    }
}
