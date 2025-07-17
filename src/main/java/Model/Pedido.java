package Model;


import DTO.ProdutoDTO;
import Model.Requisitante;
import static Model.StatusPedido.PENDENTE;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Isaias
 */
public class Pedido {

    private long id_pedido;
    private long id_requisitante;  // associação
    private HashMap<Long,ProdutoDTO> lista_pedido = new HashMap<>();// lista_pedido = id_produto= {nome, quantidade pedida}
    private long id_funcionario;
    private StatusPedido status;

    public Pedido( long id_requisitante) {
        this.id_pedido = Utils.Utilitarios.gerar_id("pedido");
        this.id_requisitante = id_requisitante;
        this.status = PENDENTE;
    }

    public Pedido(long id_requisitante, HashMap<Long,ProdutoDTO> lista_pedido) {
        this.id_pedido = Utils.Utilitarios.gerar_id("pedido");
        this.id_requisitante = id_requisitante;
        this.lista_pedido = lista_pedido;
        this.status = PENDENTE;

    }
    
    

    public Pedido() {
    }
    
    
    
   

    // Getters e Setters
    
    
    public void setId_funcionario(long id_funcionario) {
        this.id_funcionario = id_funcionario;
    }
 public long getId_funcionario() {
        return id_funcionario;
    }
    public long getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(long id_pedido) {
        this.id_pedido = id_pedido;
    }

    public long getId_requisitante() {
        return id_requisitante;
    }

    public void setId_requisitante(long id_requisitante) {
        this.id_requisitante = id_requisitante;
    }

   /*public List<ProdutoDTO> getProduto_Pedido(){//retorna sem sem os id
       List<ProdutoDTO> lista = new ArrayList<>();
       for (ProdutoDTO value : lista_pedido.values()) {
           lista.add(value);
       }
       return lista;
   }*/
    

  

}
