/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Isaias
 */
public class itensPedido {
     private Integer id_pedido;
    private Integer id_produto;
    private int quantidade;

    public itensPedido(Integer id_pedido, Integer id_produto, int quantidade) {
        this.id_pedido = id_pedido;
        this.id_produto = id_produto;
        this.quantidade = quantidade;
    }

    public itensPedido() {
    }
    
    

    public Integer getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(Integer id_pedido) {
        this.id_pedido = id_pedido;
    }

    public Integer getId_produto() {
        return id_produto;
    }

    public void setId_produto(Integer id_produto) {
        this.id_produto = id_produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
}
