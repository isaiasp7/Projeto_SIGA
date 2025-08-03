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
         System.out.println(func);
        return this.create(func, this.nomeTabelaBd);
    }
       public boolean validateIDFuncionario(String id){//se false, não existe ninguem com o id 
    return this.validateID("funcionario", "id_func", id);
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
       String sql = "SELECT id_func, id_empresa_fk FROM funcionario WHERE email = ? AND senha = ?";
        try {
            PreparedStatement script = this.conexao.prepareStatement(sql);
            script.setString(1, email);
            script.setString(2, senha);
            return script.executeQuery();
        } catch (Exception e) {
            System.out.println("ERRO (validação login): " + e);
        }
        return null;

   
   }
   
}
