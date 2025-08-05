/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Utils.Utilitarios;

/**
 *
 * @author Isaias
 */
public class Funcionario {
    private Integer id_func;
    private String nome_func;
    private String cargo;
    private String email;
    private String senha;
    private String CPF;

    public Funcionario( String nomeEmpregado,String cpf, String funcaoCargo, String email, String senha) {
        this.nome_func = nomeEmpregado;
        this.cargo= funcaoCargo;
        this.CPF = cpf;
       this.email = email;
          this.id_func= Utilitarios.gerar_id("funcionario");
          this.senha = senha;
       
    }

    

    public Funcionario() {
        this.id_func= Utilitarios.gerar_id("funcionario");
    }
    
    

    // Getters e Setters
public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public Integer getId() {
        return id_func;
    }
    public void setId(Integer id){
        this.id_func = id;
    }

  

    public String getNomeEmpregado() {
        return nome_func;
    }

    public void setNomeEmpregado(String nomeEmpregado) {
        this.nome_func = nomeEmpregado;
    }

    public String getFuncaoCargo() {
        return cargo;
    }

    public void setFuncaoCargo(String funcaoCargo) {
        this.cargo = funcaoCargo;
    }

    /*public Empresa getEmpresa(){
        EmpresaDAO empDAO = new EmpresaDAO();
        empDAO.
        this.id_empresa_fornecedora
    }*/

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
    
    
}

