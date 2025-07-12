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
    
    public boolean createFornecedor(Fornecedor fornecedor){
        return this.create(fornecedor, "empresa");
    }
   public List<Empresa> readFornecedor(String tabela){
       return this.readAll(tabela, new MontadorEmpresa());
   }
    public boolean updateFornecedor(String tipo, Fornecedor obj, int id, String nomeCampoID) {
        return this.update(tipo, obj, id, nomeCampoID) ;
    }
   public boolean deleteFornecedor(String tipo, String nomeCampoID, int id){
       return this.delete(tipo, nomeCampoID, id);
   }
  /*===============================================================================================*/
      public boolean createRequisitante(Requisitante fornecedor){
        return this.create(fornecedor, "empresa");
    }
   public List<Empresa> readRequisitante(String tabela){
       return this.readAll(tabela, new MontadorEmpresa());
   }
    public boolean updateRequisitante(String tipo, Requisitante obj, int id, String nomeCampoID) {
        return this.update("Empresa", obj, id, "id_empresa") ;
    }
   public boolean deleteRequisitante(String tipo, String nomeCampoID, int id){
       return this.delete(tipo, nomeCampoID, id);
   }
   
    public boolean validacaoLogin(String email, int senha){
       String sql = "SELECT email,senha FROM empresa WHERE email=? AND senha=? ";
        
       try {
            PreparedStatement script = this.conexao.prepareStatement(sql);
            script.setString(1, email);
            script.setInt(2,senha);
            ResultSet rs = script.executeQuery();           
             return rs.next();
          
        } catch (Exception e) {
            System.out.println("ERRO: "+e);
        }
        return false;

   
   }
 
 
}


    

    
