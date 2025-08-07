/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Controller.ConexaoSingleton;
import Controller.CrudGenerico;
import Controller.Montador.MontadorPedido;
import Controller.Montador.MontadorProduto;
import DTO.ProdutoDTO;
import Model.Pedido;
import Model.itensPedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Isaias
 */
public class itensPedidoDAO extends CrudGenerico {

    private Connection conexao = ConexaoSingleton.getInstancia().getConexao();
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

    public List<ProdutoDTO> getProdutosPorPedido(int idPedido) {//
        List<ProdutoDTO> lista = new ArrayList<>();

        String sql = "SELECT p.id_prod, p.nome_prod, p.preco, p.quant_disponivel, p.id_fornecedor_fk, ip.quantidade "
           + "FROM itensPedido ip "
           + "JOIN produto p ON p.id_prod = ip.idProduto_fk "
           + "WHERE ip.idPedido_fk = ?";

        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, idPedido);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ProdutoDTO dto = new ProdutoDTO(new MontadorProduto().montar(rs), rs.getInt("quantidade"));
                lista.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return lista;
    }
     

}
