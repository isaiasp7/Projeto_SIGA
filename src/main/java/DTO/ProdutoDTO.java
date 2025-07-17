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
      private String nome;
    private int quantDisponivel;

    public  ProdutoDTO(Produto p) {
        this.nome = p.getNome();
        this.quantDisponivel = p.getQuantDisponivel();
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

    @Override
    public String toString() {
        return  "{ Nome =" + nome + ", quantDisponivel=" + quantDisponivel + '}';
    }
    
    
    
}
