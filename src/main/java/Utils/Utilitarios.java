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
                     case "notas" -> ThreadLocalRandom.current().nextLong(100000000, 999999999);//length=9
                     case "matricula" ->
                             ThreadLocalRandom.current().nextLong(10000000, 99999999);//gerar entre intrevalos. essa vai gerar um id de length =8
                     case "professor" -> ThreadLocalRandom.current().nextLong(100000, 999999);//length = 6
                     case "disciplina" ->
                             ThreadLocalRandom.current().nextLong(10000, 99999);//gerar entre intrevalos. essa vai gerar um id de length =5
                     case "turma" -> ThreadLocalRandom.current().nextLong(0, 9999);
                     default -> throw new IllegalArgumentException("Tipo de ID desconhecido: " + tipo);
                 };

            return id;

        }
    
}
