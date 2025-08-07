/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Controller.ConexaoSingleton;
import Controller.CrudGenerico;
import Controller.Montador.MontadorEmpresa;
import Model.Empresa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Isaias
 */
public class EmpresaDAO extends CrudGenerico{
      private Connection conexao = ConexaoSingleton.getInstancia().getConexao();
    
    public boolean createEmpresa(Empresa empresa){
        System.out.println("persistind no banco");
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
    
    public boolean validateIDEmpresa(String id){//se false, não existe ninguem com o id 
    return this.validateID("empresa", "id_empresa", id);
            }
    
public boolean validateCNPJEmpresa(String cnpj) {
    String sql = "SELECT CNPJ FROM empresa WHERE CNPJ = ?";

    try {
        PreparedStatement script = this.conexao.prepareStatement(sql);
        script.setString(1, cnpj);
        ResultSet rs = script.executeQuery();

        // Se achou o CNPJ no banco, retorna false
        return !rs.next(); // se não tem resultado, retorna true
    } catch (Exception e) {
        System.out.println("ERRO: " + e);
    }

    return false; // erro na execução → por segurança, não deixa cadastrar
}

public List<Empresa> listarFornecedores() {
    List<Empresa> fornecedores = new ArrayList<>();
    String sql = "SELECT * FROM empresa WHERE tipo_empresa = 'fornecedor'";

    try {
        PreparedStatement script = this.conexao.prepareStatement(sql);
        ResultSet rs = script.executeQuery();

        MontadorEmpresa montador = new MontadorEmpresa();
        while (rs.next()) {
            Empresa fornecedor = montador.montar(rs);
            fornecedores.add(fornecedor);
        }
    } catch (Exception e) {
        System.out.println("Erro ao listar fornecedores: " + e);
    }

    return fornecedores;
}




}

