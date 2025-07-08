package Model;

import Utils.Utilitarios;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Isaias
 */
public class Requisitante extends Empresa{
    
    public Requisitante( String cnpj, String nomeEmpresa, String email) {
        super(Utilitarios.gerar_id("requisitante"),"Requisitante", cnpj, nomeEmpresa, email);
    }
   
    
    
}

