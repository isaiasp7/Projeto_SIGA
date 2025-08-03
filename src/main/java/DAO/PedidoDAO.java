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
import Model.StatusPedido;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Isaias
 */
public class PedidoDAO extends CrudGenerico {

    private Connection conexao = ConexaoSingleton.getInstancia().getConexao();
    private String nomeTabelaBd = "pedido";
    private itensPedidoDAO ip = new itensPedidoDAO();

    public boolean createPedido(Pedido ped) {//pedido possui uma hash com id = {nome, quantidade desejada}
        System.out.println("o pedido criado é o :" + ped.getId_pedido());
        String sql = new String();
        sql = "INSERT INTO pedido (id_pedido, id_requisitante, total_pedido, data_pedido, status) VALUES ("
                + ped.getId_pedido() + ", "
                + ped.getId_requisitante() + ", "
                + ped.getValorTotal() + ", '"
                + ped.getData_pedido() + "', '"
                + ped.getStatus() + "')";

        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            return ps.executeUpdate() > 0;
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

    public HashMap<Pedido, List<ProdutoDTO>> requestByIdRequisitante(Integer id_requisitante) {//pesquisa os produtos de um pedido de acordo com o id do requisitante
        System.out.println("==========================================");
        System.out.println("requestByIdRequisitante");
        HashMap<Pedido, List<ProdutoDTO>> pedidosRequisitante = new HashMap<>();

        String sql = "SELECT ped.id_pedido, "
                + "                  ped.status, "
                + "                    ip.idProduto_fk, "
                + "                   prod.nome_prod, "
                + "                     ip.quantidade as quantidadeDesejada, "
                + "                     prod.preco, "
                + "ped.total_pedido"
                + "                FROM pedido ped "
                + "                INNER JOIN itenspedido ip ON ped.id_pedido = ip.idPedido_fk "
                + "                INNER JOIN produto prod ON ip.idProduto_fk = prod.id_prod "
                + "                WHERE ped.id_requisitante = ?";

        //retorna {id_prod, nome_prod,quantidade,preco}
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setLong(1, id_requisitante);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                //criando dados na mão
                Pedido pedido = new Pedido();
                pedido.setId_pedido(rs.getInt("id_pedido"));
                pedido.setStatus(StatusPedido.conversor(rs.getString("status")));
                pedido.setValorTotal(rs.getDouble("total_pedido"));
                System.out.println("pedido");

                ProdutoDTO produto = new ProdutoDTO(new ProdutoDAO().requestIdProduto(rs.getInt("idProduto_fk")), rs.getInt("quantidadeDesejada"));

                // Se já tiver o pedido no mapa, só adiciona o produto
                Pedido encontrado = null;
                for (Pedido p : pedidosRequisitante.keySet()) {
                   if (p.getId_pedido().equals(pedido.getId_pedido()) ){
                        encontrado = p;
                        break;
                    }
                }
               if (encontrado != null) {
                   System.out.println("encontrado=true > "+rs.getInt("quantidadeDesejada"));
                    pedidosRequisitante.get(encontrado).add(new ProdutoDTO(produto.getProd(), rs.getInt("quantidadeDesejada")));
                } else {
                   System.out.println("encontrado=false > "+rs.getInt("quantidadeDesejada"));
                    List<ProdutoDTO> lista = new ArrayList<>();
                    lista.add(new ProdutoDTO(produto.getProd(), rs.getInt("quantidadeDesejada")));
                    pedidosRequisitante.put(pedido, lista);
                }

            }

        } catch (SQLException ex) {
            System.out.println("erro em requestByIdRequisitante : " + ex);
            //Logger.getLogger(CrudGenerico.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pedidosRequisitante;

    }
      public boolean validateIDPedido(String id){//se false, não existe ninguem com o id 
    return this.validateID("pedido", "id_pedido", id);
            }

}
