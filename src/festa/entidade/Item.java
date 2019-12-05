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
public class Item {
    private int idItem;
    private String nome;
    private String descricao;
    private double preco;
    private int quantidade;
    private boolean ativo;

    public boolean isAtivo() {
        return ativo;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
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

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }    
    
    public void set(String nome, String descricao, double preco, boolean ativo){
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.ativo = ativo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
