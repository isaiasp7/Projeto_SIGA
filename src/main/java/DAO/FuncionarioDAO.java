/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Controller.ConexaoSingleton;
import Controller.CrudGenerico;
import Controller.Montador.MontadorFuncionario;
import Model.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Isaias
 */
public class FuncionarioDAO extends CrudGenerico{
          private String nomeTabelaBd = "funcionario";
           private Connection conexao = ConexaoSingleton.getInstancia().getConexao();
      
     public boolean createFuncionario(Funcionario func ){
        return this.create(func, this.nomeTabelaBd);
    }
   public List<Funcionario> readFuncionario(){
       return this.readAll(this.nomeTabelaBd, new MontadorFuncionario());
   }
    public boolean updateFuncionario( Funcionario obj, int id) {
        return this.update(this.nomeTabelaBd, obj, id, "id_func") ;
    }
   public boolean deleteFuncionario(int id){
       return this.delete(this.nomeTabelaBd, "id_func", id);
   }
   public  ResultSet validacaoLoginFuncionario(String email, String senha){
       String sql = "SELECT email,senha FROM funcionario WHERE email=? AND senha=? ";
        
       try {
            PreparedStatement script = this.conexao.prepareStatement(sql);
            script.setString(1, email);
            script.setString(2,senha);
            ResultSet rs = script.executeQuery();           
             return rs;
          
        } catch (Exception e) {
            System.out.println("ERRO (validação login): "+e);
        }
        return null;

   
   }
   
}
