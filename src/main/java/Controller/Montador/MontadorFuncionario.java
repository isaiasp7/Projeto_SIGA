/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Montador;

import Controller.MontadorReadAll;
import Model.Empresa;
import Model.Funcionario;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Isaias
 */
public class MontadorFuncionario implements MontadorReadAll<Funcionario> {
       public Funcionario montar(ResultSet rs) throws SQLException {//ensina ao montador como montar as listas do tipo Empresa
        Funcionario e = new Funcionario();
        e.setId(rs.getInt("id_func"));
        e.setNomeEmpregado(rs.getString("nome_func"));
        e.setFuncaoCargo(rs.getString("cargo"));
        return e;
    }


}
