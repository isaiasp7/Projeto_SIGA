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
    private long id_fornecedor_fk;  // associação
    private double preco;
    
    public Produto() {}
    public Produto(Produto p) {
        this.id_fornecedor_fk = p.getId_fornecedor();
        this.nome_prod = p.getNome();
        this.id_prod = p.getId();
        this.preco = p.getValor();
        this.quant_disponivel = p.getQuantDisponivel();
        
    }
    
    public Produto(String nome, int quantDisponivel, long id_fornecedor, double valor) {
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

    public Produto(Integer id_prod, String nome_prod) {
        this.id_prod = id_prod;
        this.nome_prod = nome_prod;
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

    public long getId_fornecedor() {
        return id_fornecedor_fk;
    }

    public void setId_fornecedor(long id_fornecedor) {
        this.id_fornecedor_fk = id_fornecedor;
    }
    
    /*public Fornecedor getFornecedor() {
        requisita ao banco de acordo com o id e retorna o obj 
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }*/

   
}

