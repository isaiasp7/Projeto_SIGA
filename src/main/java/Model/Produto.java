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
    private long id;
    private String nome;
    private int quantDisponivel;
    private long id_fornecedor;  // associação
    private double valor;
    
    public Produto() {}
    public Produto(String nome, int quantDisponivel, long id_fornecedor, double valor) {
        this.id = Utilitarios.gerar_id("produto");
        this.valor = valor;
        this.nome = nome;
        this.quantDisponivel = quantDisponivel;
        this.id_fornecedor = id_fornecedor;
    }
    public Produto(long id,String nome,long id_fornecedor){
        this.id = id;
        this.nome = nome;
        this.id_fornecedor = id_fornecedor;
    }

    
    

    
    
    // Getters e Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
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

