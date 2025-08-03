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
public class Empresa {
        private Integer id_empresa;
    private String tipo_empresa;
    private String CNPJ;
    private String nome_empresa;
    private String email;
    private String senha;

    public Empresa(String cnpj, String nomeEmpresa, String email, String senha) {
        this.id_empresa =Utilitarios.gerar_id("empresa");
        this.tipo_empresa = "Requisitante";
        this.CNPJ = cnpj;
        this.nome_empresa = nomeEmpresa;
        this.email = email;
        this.senha = senha;
    }

   

    public Empresa() {}

    public String getTipo() {
        return tipo_empresa;
    }
    
    

    public void setTipo(String tipo) {
        this.tipo_empresa = tipo;
    }
    
    
    public long getId() {
        return id_empresa;
    }
    public void setId(Integer id){
        this.id_empresa=id;
    }
    


    public String getCnpj() {
        return CNPJ;
    }

    public void setCnpj(String cnpj) {
        this.CNPJ = cnpj;
    }

    public String getNomeEmpresa() {
        return nome_empresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nome_empresa = nomeEmpresa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
    
}
