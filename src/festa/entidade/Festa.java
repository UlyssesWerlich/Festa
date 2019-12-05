/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package festa.entidade;

import java.sql.Date;

/**
 *
 * @author Administrador
 */
public class Festa {
    
    private int idFesta;
    private double valor;
    private int status;
    private Cliente cliente;
    private Tema tema;
    private String estado;
    private String cidade;
    private String logradouro;
    private Date dataFesta;
    private boolean matutino;   
    private boolean vespertino;
    private boolean noturno;
    private String comentario;

    public int getIdFesta() {
        return idFesta;
    }

    public void setIdFesta(int idFesta) {
        this.idFesta = idFesta;
    }

    public double getValor() {
        return valor;
    }

    public int getStatus() {
        return status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Tema getTema() {
        return tema;
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

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Date getDataFesta() {
        return dataFesta;
    }

    public String getComentario() {
        return comentario;
    }
    

    public boolean isMatutino() {
        return matutino;
    }

    public boolean isVespertino() {
        return vespertino;
    }

    public boolean isNoturno() {
        return noturno;
    }
    
    public void set(double valor, Cliente cliente, Tema tema, String estado, String cidade, String logradouro, 
            Date dataFesta, boolean matutino, boolean vespertino, boolean noturno, int status, String comentario){
        this.valor = valor;
        this.cliente = cliente;
        this.tema = tema;
        this.estado = estado;
        this.cidade = cidade;
        this.logradouro = logradouro;
        this.dataFesta = dataFesta;
        this.matutino = matutino;
        this.vespertino = vespertino;
        this.noturno = noturno;
        this.status = status;
        this.comentario = comentario;
    }

    public void setLista(double valor, Cliente cliente, Tema tema, 
            Date dataFesta, int status){
        this.valor = valor;
        this.cliente = cliente;
        this.tema = tema;
        this.dataFesta = dataFesta;
        this.status = status;
    }
}
