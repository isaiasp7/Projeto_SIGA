/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Controller.CrudGenerico;
import Utils.Utilitarios;

/**
 *
 * @author Isaias
 */
public class Fornecedor extends Empresa{

    public Fornecedor(String cnpj, String nomeEmpresa, String email) {
        super(Utilitarios.gerar_id("fornecedor"),"Fornecedor", cnpj, nomeEmpresa, email);
        
    }

    public Fornecedor() {
    }
    

    
    


}

