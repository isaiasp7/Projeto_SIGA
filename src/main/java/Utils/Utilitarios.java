/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import DAO.EmpresaDAO;
import Controller.DAO.FuncionarioDAO;
import Controller.DAO.PedidoDAO;
import Controller.DAO.ProdutoDAO;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Isaias
 */
public class Utilitarios {
     public static Integer gerar_id_produto(){
          int id;
         do {             
            id= ThreadLocalRandom.current().nextInt(1000000, 9999999);//length =7
         } while (new ProdutoDAO().validateIDProduto(String.valueOf(id)));
         return id;
     
     
     }
     public static Integer gerar_id_pedido(){
          int id;
         do {             
            id=  ThreadLocalRandom.current().nextInt(10000000, 99999999);//length =7
         } while (new PedidoDAO().validateIDPedido(String.valueOf(id)));
         return id;
     
     
     }
     public static Integer gerar_id_funcionario(){
          int id;
         do {             
            id=  ThreadLocalRandom.current().nextInt(10000000, 99999999);//length =7
         } while (new FuncionarioDAO().validateIDFuncionario(String.valueOf(id)));
         return id;
     
     
     }
     public static Integer gerar_id_empresa(){
          int id;
         do {             
            id= ThreadLocalRandom.current().nextInt(100000, 999999);//length = 6
         } while (new EmpresaDAO().validateIDEmpresa(String.valueOf(id)));
         return id;
     
     
     }
         public static Integer gerar_id(String  tipo){//verificar dentro do banco se o id ja existe 
            Integer id;
                 
                 id = switch (tipo) {
                     case "produto" -> gerar_id_funcionario();
                     case "pedido" -> gerar_id_pedido();
                           
                     case "funcionario" ->   gerar_id_funcionario();
                     case "empresa" -> gerar_id_empresa();
                     default -> throw new IllegalArgumentException("Tipo de ID desconhecido: " + tipo);
                 };
            
                 //verificar se o id gerado já existe. se for o caso, gerar outro

            return id;

        }
         
          public static String gerar_email(String tipo,String nome){//verificar dentro do banco se o id ja existe
                 String email = switch (tipo) {
                     
                     case "funcionario" ->  "Empreg"+nome+String.valueOf(ThreadLocalRandom.current().nextLong(100000, 999999))+"@gmail.com";
                     case "empresa" -> "Org"+nome+String.valueOf(ThreadLocalRandom.current().nextLong(100000, 999999))+"@gmail.com";
                     default -> throw new IllegalArgumentException("Tipo desconhecido: " + tipo);
                 };

            return email;

        }
    
}
