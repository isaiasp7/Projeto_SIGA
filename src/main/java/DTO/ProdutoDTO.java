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
      private int id_produto;
      private int quantidadeDesejada;
    private double totalpedido;

    public ProdutoDTO(int id_produto, int quantidadeDesejada, double totalpedido) {
        this.id_produto = id_produto;
        this.quantidadeDesejada = quantidadeDesejada;
        this.totalpedido = totalpedido;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public int getQuantidadeDesejada() {
        return quantidadeDesejada;
    }

    public void setQuantidadeDesejada(int quantidadeDesejada) {
        this.quantidadeDesejada = quantidadeDesejada;
    }

    public double getTotalpedido() {
        return totalpedido;
    }

    public void setTotalpedido(double totalpedido) {
        this.totalpedido = totalpedido;
    }

   
}
