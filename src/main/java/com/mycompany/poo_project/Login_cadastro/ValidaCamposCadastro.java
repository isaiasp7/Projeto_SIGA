/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo_project.Login_cadastro;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author Isaias
 */
public class ValidaCamposCadastro{
    

    public static String Cnpj(String cnpj) {
        if (cnpj.matches("[0-9]*") ) {
            if (cnpj.hashCode() == 14) {
                try {
                // 1. Criar cliente HTTP
                HttpClient client = HttpClient.newHttpClient();

                // 2. Criar requisição GET para URL da API
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(new URI("https://receitaws.com.br/v1/cnpj/" + cnpj))
                        .GET()
                        .build();

                // 3. Enviar requisição e receber resposta como String
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                int statusCode = response.statusCode();
                if (statusCode == 200) {
                    // 4. Criar ObjectMapper para converter JSON
                } else {
                    // Trate erro conforme código
                    System.out.println("Erro na requisição. Código HTTP: " + statusCode);
                    System.out.println("Mensagem: " + response.body()); // muitas APIs mandam erro em JSON também
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            }else{
            return "14";
            }
            
        } else {
           return "Só é aceito números";
        }
        return "false";
    }

}
