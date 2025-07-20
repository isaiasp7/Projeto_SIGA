/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Controller.CrudGenerico;
import Controller.Montador.MontadorPedido;
import DTO.ProdutoDTO;
import Model.Pedido;
import Model.itensPedido;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Isaias
 */
public class itensPedidoDAO extends CrudGenerico {
    private String nomeTabelaBd = "itenspedido";

    public boolean createItensPedido(HashMap<Integer, ProdutoDTO> pedido) {
        for (Map.Entry<Integer, ProdutoDTO> entry : pedido.entrySet()) {
            Integer key = entry.getKey();

            ProdutoDTO val = entry.getValue();
            System.out.println("Pedido  => "+key+"{"+ val.getId_produto()+" = " +val.getQuantidadeDesejada()+"}");
            
            //this.create(new itensPedido(pedido.getId_pedido(), key, val.getQuantDisponivel()), nomeTabelaBd) ;

        }

        return this.create(pedido, this.nomeTabelaBd);
    }

    public List<Pedido> readItensPedido() {
        return this.readAll(this.nomeTabelaBd, new MontadorPedido());
    }

    public boolean updateItensPedido(Pedido obj, int id) {
        return this.update(this.nomeTabelaBd, obj, id, "id_pedido");
    }

    public boolean deleteItensPedido(int id) {
        return this.delete(this.nomeTabelaBd, "id_pedido", id);
    }

}
