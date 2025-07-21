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
    private Integer id_prod;
    private String nome_prod;
    private int quant_disponivel;
    private Integer id_fornecedor_fk;  // associação
    private double preco;
    
    public Produto() {}
    public Produto(String nome, int quantDisponivel, Integer id_fornecedor, double valor) {
        this.id_prod = Utilitarios.gerar_id("produto");
        this.preco = valor;
        this.nome_prod = nome;
        this.quant_disponivel = quantDisponivel;
        this.id_fornecedor_fk = id_fornecedor;
    }
    public Produto(Integer id,String nome,Integer id_fornecedor){
        this.id_prod = id;
        this.nome_prod = nome;
        this.id_fornecedor_fk = id_fornecedor;
    }

    
    

    
    
    // Getters e Setters

    public Integer getId() {
        return id_prod;
    }

    public void setId(Integer id) {
        this.id_prod = id;
    }

    public double getValor() {
        return preco;
    }

    public void setValor(double valor) {
        this.preco = valor;
    }
    

  
    public String getNome() {
        return nome_prod;
    }

    public void setNome(String nome) {
        this.nome_prod = nome;
    }

    public int getQuantDisponivel() {
        return quant_disponivel;
    }

    public void setQuantDisponivel(int quantDisponivel) {
        this.quant_disponivel = quantDisponivel;
    }

    public Integer getId_fornecedor() {
        return id_fornecedor_fk;
    }

    public void setId_fornecedor(Integer id_fornecedor) {
        this.id_fornecedor_fk = id_fornecedor;
    }
    
    /*public Fornecedor getFornecedor() {
        requisita ao banco de acordo com o id e retorna o obj 
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }*/

   
}

