/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Login;

/**
 *
 * @author Isaias
 */
public class FornecedorLogin {
    private static Integer id;
    private static String nome;
    private static String email;
    private static String senha;

    public FornecedorLogin(Integer id, String nome, String email, String senha) {
        FornecedorLogin.id = id;
        FornecedorLogin.nome = nome;
        FornecedorLogin.email = email;
        FornecedorLogin.senha = senha;
    }

    public static Integer getId() {
        return id;
    }

    public static void setId(Integer id) {
        FornecedorLogin.id = id;
    }

    public static String getNome() {
        return nome;
    }

    public static void setNome(String nome) {
        FornecedorLogin.nome = nome;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        FornecedorLogin.email = email;
    }

    public static String getSenha() {
        return senha;
    }

    public static void setSenha(String senha) {
        FornecedorLogin.senha = senha;
    }
    
    

}
