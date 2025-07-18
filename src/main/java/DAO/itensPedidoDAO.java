/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Controller.CrudGenerico;
import DTO.ProdutoDTO;
import Model.Pedido;
import Model.itensPedido;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Isaias
 */
public class itensPedidoDAO extends CrudGenerico {
    
      private String nomeTabelaBd = "itenspedido";
      private itensPedidoDAO ipDAO = new itensPedidoDAO();
      
     public boolean createPedido(Pedido pedido){
           for (Map.Entry<Integer, ProdutoDTO> entry : pedido.getLista_pedido().entrySet()) {
             Object key = entry.getKey();
             Object val = entry.getValue();
              for (ProdutoDTO pedto : val) {
                   new itensPedido(pedido.getId_pedido(),key,pedto.getQuantDisponivel());
               }
             
         }
                   
                
                
                  
             
            return this.create(pedido, this.nomeTabelaBd);
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
