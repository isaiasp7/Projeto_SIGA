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
    

   

    public ProdutoDTO(Produto p,int quantidadeDesejada) {
        this.prod.setId(p.getId());
        this.quantidadeDesejada = quantidadeDesejada;
    }

    public ProdutoDTO(Produto prod) {
        this.prod = prod;
        this.quantidadeDesejada =0;
    }
    

    public Produto getProd() {
        return prod;
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
