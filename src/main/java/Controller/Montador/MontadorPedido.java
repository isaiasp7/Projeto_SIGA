/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Montador;

import Controller.MontadorReadAll;
import Model.Pedido;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Isaias
 */
public class MontadorPedido implements MontadorReadAll<Pedido>{

    @Override
    public Pedido montar(ResultSet rs) throws SQLException {
       Pedido ped = new Pedido();
       ped.setId_pedido(rs.getInt("id_pedido"));
       ped.setId_requisitante(rs.getInt("id_requisitante"));
       ped.setId_funcionario(rs.getInt("id_funcionario"));
       return ped;
    }
    
}
