/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import Model.Produto;

/**
 *
 * @author Isaias
 */
public class ProdutoDTO {
      private Produto prod;
      private int quantidadeDesejada;

    public ProdutoDTO() {
    }
    
public ProdutoDTO(Produto p,int quantidadeDesejada) {
        this.setProd(p);
}

    public ProdutoDTO(int p,int quantidadeDesejada) {
        this.setID(p);
        this.quantidadeDesejada = quantidadeDesejada;
    }
   

    public ProdutoDTO(Produto prod) {
        this.prod = prod;
        this.quantidadeDesejada =0;
    }
    

    public Produto getProd() {
        return prod;
    }
    public void setPreco(double v){
    this.prod.setValor(v);
    }
    public void setID(int id){
        this.prod.setId(id);
    }
    public void setProd(Produto prod) {
        this.prod = prod;
    }

    public int getQuantidadeDesejada() {
        return quantidadeDesejada;
    }

    public void setQuantidadeDesejada(int quantidadeDesejada) {
        this.quantidadeDesejada = quantidadeDesejada;
    }
    
    

   
   
}
