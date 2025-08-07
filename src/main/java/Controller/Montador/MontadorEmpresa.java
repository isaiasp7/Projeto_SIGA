/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Montador;

import Controller.MontadorReadAll;
import Model.Empresa;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Isaias
 */
public class MontadorEmpresa implements MontadorReadAll<Empresa>{
  
    public Empresa montar(ResultSet rs) throws SQLException {//ensina ao montador como montar as listas do tipo Empresa
        Empresa e = new Empresa();
        e.setId(rs.getInt("id_empresa"));
        e.setNomeEmpresa(rs.getString("nome_empresa"));
        e.setTipo(rs.getString("tipo_empresa"));
        e.setCnpj(rs.getString("cnpj"));
        return e;
    }


    
}
