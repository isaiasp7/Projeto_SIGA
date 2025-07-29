/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Controller.ConexaoSingleton;
import Controller.CrudGenerico;
import Controller.Montador.MontadorProduto;
import DTO.ProdutoDTO;
import Model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Isaias
 */
public class ProdutoDAO extends CrudGenerico {

    private MontadorProduto mp = new MontadorProduto();
    private String nomeTabelaBd = "produto";

    public boolean createProduto(Produto prod) {
        return this.create(prod, this.nomeTabelaBd);
    }

    public List<Produto> readProduto() {
        return this.readAll(this.nomeTabelaBd, new MontadorProduto());
    }

    public boolean updateProduto(Produto obj, int id){
       // System.out.println(" dentro de produtoUpdate");
        return this.update(this.nomeTabelaBd, obj, id, "id_prod");
    }

    public boolean deleteProduto(int id) {
        return this.delete(this.nomeTabelaBd, "id_prod", id);
    }

    public Produto requestIdProduto(Integer id) {//rever
       return this.requestById(nomeTabelaBd, "id_prod", id,new MontadorProduto());
    }

   public List<Produto> searchID(List<Produto> lista, String id) {
        List<Produto> p = new ArrayList<>();
        for (Produto produto : lista) {
            if (String.valueOf(produto.getId()).contains(id)) {
                 p.add(produto);
            }
        }
        return p;
    }
       public List<Produto> searchNome(List<Produto> lista, String nome) {
        List<Produto> p = new ArrayList<>();
        for (Produto produto : lista) {
            if (String.valueOf(produto.getNome()).contains(nome)) {
                p.add(produto);
            }
        }
         return p;
    }
     public List<Produto> searchIDdto(List<ProdutoDTO> lista, String id) {
        List<Produto> p = new ArrayList<>();
        for (ProdutoDTO produto : lista) {
            if (String.valueOf(produto.getProd().getId()).contains(id)) {
                 p.add(produto.getProd());
            }
        }
        return p;
    }

    public List<Produto> searchNomedto(List<ProdutoDTO> lista, String nome) {
        List<Produto> p = new ArrayList<>();
        for (ProdutoDTO produto : lista) {
            if (String.valueOf(produto.getProd().getNome()).contains(nome)) {
                p.add(produto.getProd());
            }
        }
         return p;
    }

    public List<Produto> getProdutosPorFornecedor(int idFornecedor) {
        List<Produto> lista = new ArrayList<>();
        String sql = "SELECT * FROM produto WHERE id_fornecedor_fk = ?";

        try {
            Connection conexao = ConexaoSingleton.getInstancia().getConexao();
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, idFornecedor);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Produto p = new MontadorProduto().montar(rs);
                lista.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
    
    
}
