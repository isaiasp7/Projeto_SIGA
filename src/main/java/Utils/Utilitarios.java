/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Isaias
 */
public class Utilitarios {
         public static long gerar_id(String  tipo){//verificar dentro do banco se o id ja existe
                 long id = switch (tipo) {
                     case "produto" -> ThreadLocalRandom.current().nextLong(100000000, 999999999);//length=9
                     case "pedido" ->
                             ThreadLocalRandom.current().nextLong(10000000, 99999999);//length =8
                     case "funcionario" ->    ThreadLocalRandom.current().nextLong(1000000, 9999999);//length =7
                     case "empresa" -> ThreadLocalRandom.current().nextLong(100000, 999999);//length = 6
                     default -> throw new IllegalArgumentException("Tipo de ID desconhecido: " + tipo);
                 };

            return id;

        }
    
}
