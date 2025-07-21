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
     private Integer idPedido_fk;
    private Integer idProduto_fk;
    private int quantidade;

    public itensPedido(Integer id_pedido, Integer id_produto, int quantidade) {
        this.idPedido_fk = id_pedido;
        this.idProduto_fk = id_produto;
        this.quantidade = quantidade;
    }

    public itensPedido() {
    }
    
    

    public Integer getId_pedido() {
        return idPedido_fk;
    }

    public void setId_pedido(Integer id_pedido) {
        this.idPedido_fk = id_pedido;
    }

    public Integer getId_produto() {
        return idProduto_fk;
    }

    public void setId_produto(Integer id_produto) {
        this.idProduto_fk = id_produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
}
