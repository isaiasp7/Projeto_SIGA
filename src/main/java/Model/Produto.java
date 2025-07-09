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
public class Produto {
    private long id = Utilitarios.gerar_id("produto");
    private String nome;
    private int quantDisponivel;
    private long id_fornecedor;  // associação

    // Getters e Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

  
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantDisponivel() {
        return quantDisponivel;
    }

    public void setQuantDisponivel(int quantDisponivel) {
        this.quantDisponivel = quantDisponivel;
    }

    public long getId_fornecedor() {
        return id_fornecedor;
    }

    public void setId_fornecedor(long id_fornecedor) {
        this.id_fornecedor = id_fornecedor;
    }
    
    /*public Fornecedor getFornecedor() {
        requisita ao banco de acordo com o id e retorna o obj 
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }*/

   
}

