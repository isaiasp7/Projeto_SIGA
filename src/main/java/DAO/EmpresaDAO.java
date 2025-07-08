/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Controller.ConexaoBd;
import Controller.Montador.MontadorEmpresa;
import Controller.MontadorReadAll;
import Model.Empresa;
import Model.Fornecedor;
import Model.Requisitante;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Isaias
 */
public class EmpresaDAO extends ConexaoBd{
    
    public boolean createFornecedor(Fornecedor fornecedor){
        return this.create(fornecedor, "Fornecedor");
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
        return this.create(fornecedor, "Requisitante");
    }
   public List<Empresa> readRequisitante(String tabela){
       return this.readAll(tabela, new MontadorEmpresa());
   }
    public boolean updateRequisitante(String tipo, Requisitante obj, int id, String nomeCampoID) {
        return this.update(tipo, obj, id, nomeCampoID) ;
    }
   public boolean deleteRequisitante(String tipo, String nomeCampoID, int id){
       return this.delete(tipo, nomeCampoID, id);
   }
 
 
}


    

    
