/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package festa.entidade;

/**
 *
 * @author Administrador
 */
public class Tema {

    private int idTema;
    private String nome;
    private String descricao;
    private double precoAluguel;
    private boolean ativo;

    public boolean isAtivo() {
        return ativo;
    }

    public int getIdTema() {
        return idTema;
    }

    public void setIdTema(int idTema) {
        this.idTema = idTema;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPrecoAluguel() {
        return precoAluguel;
    }

    public void set(String nome, String descricao, double preco, boolean ativo) {
        this.nome = nome;
        this.descricao = descricao;
        this.precoAluguel = preco;
        this.ativo = ativo;
    }
}
