/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Controller.ConexaoSingleton;
import Controller.CrudGenerico;
import Controller.Montador.MontadorPedido;
import DTO.ProdutoDTO;
import Model.Pedido;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Isaias
 */
public class PedidoDAO extends CrudGenerico {
 private Connection conexao = ConexaoSingleton.getInstancia().getConexao();
    private String nomeTabelaBd = "pedido";
    private itensPedidoDAO ip = new itensPedidoDAO();

    public boolean createPedido(Pedido ped) {//pedido possui uma hash com id = {nome, quantidade desejada}
        System.out.println("o pedido criado é o :"+ped.getId_pedido());
        String sql = new String();
sql = "INSERT INTO pedido (id_pedido, id_requisitante, total_pedido, data_pedido, status) VALUES (" +
       ped.getId_pedido() + ", " +
       ped.getId_requisitante() + ", " +
       ped.getValorTotal() + ", '" +
       ped.getData_pedido() + "', '" +
       ped.getStatus() + "')";

        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            return  ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public List<Pedido> readPedido() {
        return this.readAll(this.nomeTabelaBd, new MontadorPedido());
    }

    public boolean updatePedido(Pedido obj, int id) {
        return this.update(this.nomeTabelaBd, obj, id, "id_pedido");
    }

    public boolean deletePedido(int id) {
        return this.delete(this.nomeTabelaBd, "id_pedido", id);
    }

}
