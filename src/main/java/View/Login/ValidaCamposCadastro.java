/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.Login;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.apache.commons.validator.EmailValidator;
import org.json.JSONObject;

/**
 *
 * @author Isaias
 */
//https://rapidapi.com/cnpja/api/consulta-cnpj-gratis
public class ValidaCamposCadastro {

    public static String validarCampoEmail(String email) {
        if (EmailValidator.getInstance().isValid(email)) {
            if (consultarEmail(email).equals("true")) {
                return null;
            } else {
                return "não existe";
            }

        } else {
            return "formato errado";
        }

    }

    public static String consultarEmail(String email) {

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://validect-email-verification-v1.p.rapidapi.com/v1/verify?email=" + email))
                    .header("x-rapidapi-key", "632ce6e0f4mshcea6867d6686244p167cbfjsnb7f72c00c93a")
                    .header("x-rapidapi-host", "validect-email-verification-v1.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body(); // Suponha que seja: {"status": "ok"}
            JSONObject obj = new JSONObject(json);
            String status = obj.getString("status");
            System.out.println(status);
            if (status.equals("invalid")) {
               return "formato errado";
            }else{
            return "true";
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "erro na requisição";
        }
    }

    /*====================================================================================*/
    public static String validarCampoCNPJ(String cnpj) {
        // Valida se contém apenas números
        if (!cnpj.matches("[0-9]*")) {
            return "Só é aceito números";
        }

        // Valida se tem 14 caracteres
        if (cnpj.length() != 14) {
            return "CNPJ deve ter 14 dígitos";
        }

        return null; // Retorna null se a validação passar
    }

    public static boolean consultarCNPJ(String cnpj) {

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://consulta-cnpj-gratis.p.rapidapi.com/office/" + cnpj + "?simples=false"))
                    .header("x-rapidapi-key", "632ce6e0f4mshcea6867d6686244p167cbfjsnb7f72c00c93a")
                    .header("x-rapidapi-host", "consulta-cnpj-gratis.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();

            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            int statusCode = response.statusCode();

            return statusCode == 200;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

// Método original refatorado para usar os novos métodos
    public static String verificarCNPJ(String cnpj) {
        String validacao = validarCampoCNPJ(cnpj);
        if (validacao != null) {
            return validacao;
        }

        if (consultarCNPJ(cnpj)) {
            return "true"; // Sucesso
        } else {
            return "CNPJ não existe";
        }
    }

}
