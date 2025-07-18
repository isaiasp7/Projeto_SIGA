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
        private Integer id;
    private String tipo;
    private String cnpj;
    private String nomeEmpresa;
    private String email;

    public Empresa( String tipo, String cnpj, String nomeEmpresa, String email) {
        this.id =Utilitarios.gerar_id("empresa");
        this.tipo = tipo;
        this.cnpj = cnpj;
        this.nomeEmpresa = nomeEmpresa;
        this.email = email;
    }

   

    public Empresa() {}

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    public long getId() {
        return id;
    }
    public void setId(Integer id){
        this.id=id;
    }
    


    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
    
}
