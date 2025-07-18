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
    private Integer id = Utilitarios.gerar_id("funcionario");
    private String nomeEmpregado;
    private String funcaoCargo;
    private Integer id_empresa_fornecedora;
    private String email;

    public Funcionario( String nomeEmpregado, String funcaoCargo, Integer id_empresa_fornecedora) {
        
        this.nomeEmpregado = nomeEmpregado;
        this.funcaoCargo = funcaoCargo;
        this.id_empresa_fornecedora = id_empresa_fornecedora;
    }

    

    public Funcionario() {
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

    public Integer getId_empresa_fornecedora() {
        return id_empresa_fornecedora;
    }

    public void setId_empresa_fornecedora(Integer id_empresa_fornecedora) {
        this.id_empresa_fornecedora = id_empresa_fornecedora;
    }
    /*public Empresa getEmpresa(){
        EmpresaDAO empDAO = new EmpresaDAO();
        empDAO.
        this.id_empresa_fornecedora
    }*/
    
    
}

