/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Controller.CrudGenerico;
import Controller.Montador.MontadorPedido;
import Model.Pedido;
import java.util.List;

/**
 *
 * @author Isaias
 */
public class PedidoDAO extends CrudGenerico {
      private String nomeTabelaBd = "pedido";
      
     public boolean createPedido(Pedido prod ){
        return this.create(prod, this.nomeTabelaBd);
    }
   public List<Pedido> readPedido(){
       return this.readAll(this.nomeTabelaBd, new MontadorPedido());
   }
    public boolean updatePedido( Pedido obj, int id) {
        return this.update(this.nomeTabelaBd, obj, id, "id_pedido") ;
    }
   public boolean deletePedido(int id){
       return this.delete(this.nomeTabelaBd, "id_pedido", id);
   }
    
}
