package Model;


import DTO.ProdutoDTO;
import Model.Requisitante;
import static Model.StatusPedido.PENDENTE;
import java.time.LocalDate;
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

    private Integer id_pedido;
    private Integer id_requisitante;  // associação
    private HashMap<Integer,ProdutoDTO> lista_pedido = new HashMap<>();// lista_pedido = id_produto= {nome, quantidade pedida}
    private Integer id_funcionario;
    private LocalDate data_pedido;
    private StatusPedido status;

    public Pedido( Integer id_requisitante) {
        this.id_pedido = Utils.Utilitarios.gerar_id("pedido");
        this.id_requisitante = id_requisitante;
        this.data_pedido = LocalDate.now();
        this.status = PENDENTE;
    }

    public Pedido(Integer id_requisitante, HashMap<Integer,ProdutoDTO> lista_pedido) {
        this.id_pedido = Utils.Utilitarios.gerar_id("pedido");
        this.id_requisitante = id_requisitante;
        this.lista_pedido = lista_pedido;
         this.data_pedido = LocalDate.now();
        this.status = PENDENTE;

    }
    
    

    public Pedido() {
         this.data_pedido = LocalDate.now();
         this.id_pedido = Utils.Utilitarios.gerar_id("pedido");
    }
    
    
    
   
   

    // Getters e Setters
    
    public LocalDate getData_pedido() {
        return data_pedido;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }
    
    
    public StatusPedido getStatus() {
        return status;
    }

    public void setId_funcionario(Integer id_funcionario) {
        this.id_funcionario = id_funcionario;
    }
 public Integer getId_funcionario() {
        return id_funcionario;
    }
    public Integer getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(Integer id_pedido) {
        this.id_pedido = id_pedido;
    }

    public Integer getId_requisitante() {
        return id_requisitante;
    }

    public void setId_requisitante(Integer id_requisitante) {
        this.id_requisitante = id_requisitante;
    }

   public List<ProdutoDTO> getProduto_Pedido(){//retorna sem sem os id
       List<ProdutoDTO> lista = new ArrayList<>();
       for (ProdutoDTO value : lista_pedido.values()) {
           lista.add(value);
       }
       return lista;
   }

    public HashMap<Integer, ProdutoDTO> getLista_pedido() {
        return lista_pedido;
    }

    public void setLista_pedido(HashMap<Integer, ProdutoDTO> lista_pedido) {
        this.lista_pedido = lista_pedido;
    }
    
   

}
