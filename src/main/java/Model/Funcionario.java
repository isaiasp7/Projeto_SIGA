/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DAO.EmpresaDAO;
import Utils.Utilitarios;

/**
 *
 * @author Isaias
 */
public class Funcionario {
    private Integer id;
    private String nomeEmpregado;
    private String funcaoCargo;
    private String email;
    private String senha;

    public Funcionario( String nomeEmpregado, String funcaoCargo, String email, String senha) {
        this.nomeEmpregado = nomeEmpregado;
        this.funcaoCargo = funcaoCargo;
       this.email = email;
          this.id = Utilitarios.gerar_id("funcionario");
          this.senha = senha;
       
    }

    

    public Funcionario() {
        this.id = Utilitarios.gerar_id("funcionario");
    }
    
    

    // Getters e Setters
public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id){
        this.id = id;
    }

  

    public String getNomeEmpregado() {
        return nomeEmpregado;
    }

    public void setNomeEmpregado(String nomeEmpregado) {
        this.nomeEmpregado = nomeEmpregado;
    }

    public String getFuncaoCargo() {
        return funcaoCargo;
    }

    public void setFuncaoCargo(String funcaoCargo) {
        this.funcaoCargo = funcaoCargo;
    }

    /*public Empresa getEmpresa(){
        EmpresaDAO empDAO = new EmpresaDAO();
        empDAO.
        this.id_empresa_fornecedora
    }*/
    
    
}

