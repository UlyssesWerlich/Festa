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
public class TemaItem {
    private int id;
    private Tema tema;
    private Item item;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
