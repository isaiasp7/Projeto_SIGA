/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Controller.CrudGenerico;
import Controller.Montador.MontadorProduto;
import Controller.MontadorReadAll;
import Model.Produto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    public boolean updateProduto(Produto obj, int id) {
        return this.update(this.nomeTabelaBd, obj, id, "id_prod");
    }

    public boolean deleteProduto(int id) {
        return this.delete(this.nomeTabelaBd, "id_prod", id);
    }

    public Produto requestID(Long id) {//rever
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

}
