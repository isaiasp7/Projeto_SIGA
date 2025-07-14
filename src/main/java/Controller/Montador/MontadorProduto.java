/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Montador;

import Controller.MontadorReadAll;
import Model.Produto;
import java.sql.ResultSet;
import Controller.CrudGenerico;
import java.sql.SQLException;

/**
 *
 * @author Isaias
 */
public class MontadorProduto extends CrudGenerico implements MontadorReadAll<Produto>{

    @Override
    public Produto montar(ResultSet rs) throws SQLException {
       Produto e = new Produto();
        e.setId(rs.getInt("id_prod"));
        e.setNome(rs.getString("nome_prod"));
        e.setQuantDisponivel(Integer.parseInt(rs.getString("quant_disponivel")));
        e.setId_fornecedor(rs.getLong("id_fornecedor_fk"));
        return e;
    }
    
}
