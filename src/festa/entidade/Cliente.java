package festa.entidade;

import java.sql.Date;

public class Cliente {
    private String nome;
    private String cpf;
    private int idCliente;
    private String telefone;
    private String email;
    private String estado;
    private String cidade;
    private String logradouro;
    private Date dataNascimento;
    private boolean ativo;

    public boolean isAtivo() {
        return ativo;
    }
    
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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

    public Date getDataNascimento() {
        return dataNascimento;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setLista(String nome, String cpf, String telefone, String estado, 
            String cidade) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.estado = estado;
        this.cidade = cidade;
    }    
    
    public void set(String nome, String cpf, String telefone, String email, String estado, 
            String cidade, String logradouro, Date dataNascimento, boolean ativo) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.estado = estado;
        this.cidade = cidade;
        this.logradouro = logradouro;
        this.dataNascimento = dataNascimento;
        this.ativo = ativo;
    }
}