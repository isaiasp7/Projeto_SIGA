/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Controller.CrudGenerico;
import Controller.Montador.MontadorProduto;
import Model.Produto;
import java.util.List;



/**
 *
 * @author Isaias
 */
public class ProdutoDAO extends CrudGenerico{
    private String nomeTabelaBd = "produto";
     public boolean createProduto(Produto prod ){
        return this.create(prod, this.nomeTabelaBd);
    }
   public List<Produto> readProduto(){
       return this.readAll(this.nomeTabelaBd, new MontadorProduto());
   }
    public boolean updateProduto( Produto obj, int id) {
        return this.update(this.nomeTabelaBd, obj, id, "id_prod") ;
    }
   public boolean deleteProduto(int id){
       return this.delete(this.nomeTabelaBd, "id_prod", id);
   }
    

}
