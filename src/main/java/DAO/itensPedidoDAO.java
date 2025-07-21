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

    public boolean createItensPedido(itensPedido ip) {
        return this.create(ip, nomeTabelaBd);
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
