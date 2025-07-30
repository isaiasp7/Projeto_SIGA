/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Controller.ConexaoSingleton;
import Controller.CrudGenerico;
import Controller.Montador.MontadorEmpresa;
import Controller.MontadorReadAll;
import Model.Empresa;
import Model.Fornecedor;
import Model.Requisitante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Isaias
 */
public class EmpresaDAO extends CrudGenerico{
      private Connection conexao = ConexaoSingleton.getInstancia().getConexao();
    
    public boolean createEmpresa(Empresa empresa){
        return this.create(empresa, "empresa");
    }
   public List<Empresa> readEmpresa(String tabela){
       return this.readAll(tabela, new MontadorEmpresa());
   }
    public boolean updateEmpresa(String tipo, Empresa obj, int id, String nomeCampoID) {
        return this.update(tipo, obj, id, nomeCampoID) ;
    }
   public boolean deleteEmpresa(String tipo, String nomeCampoID, int id){
       return this.delete(tipo, nomeCampoID, id);
   }
   
    public  ResultSet validacaoLoginEmpresa(String email, String senha){
       String sql = "SELECT id_empresa,nome_empresa,email,senha FROM empresa WHERE email=? AND senha=? ";
        
       try {
            PreparedStatement script = this.conexao.prepareStatement(sql);
            script.setString(1, email);
            script.setString(2,senha);
            ResultSet rs = script.executeQuery();           
             return rs;
          
        } catch (Exception e) {
            System.out.println("ERRO: "+e);
        }
        return null;

   
   }
 
 
}


    

    
