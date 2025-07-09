/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Isaias
 */
public class ConexaoSingleton {
    private static ConexaoSingleton instancia;
    private Connection conexao;
    private String url = "jdbc:MySQL://localhost:3306/projeto";
    private String user = "root";
    private String pass = "root12345";

    private ConexaoSingleton() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(url, user, pass);
            /*
               PreparedStatement stmt = conexao.prepareStatement(script sql);
            ResultSet rs = stmt.executeQuery();
             */
        } catch (Exception e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
        }
    }
   
    

    

    public static ConexaoSingleton getInstancia() {
    if (instancia == null) {
        instancia = new ConexaoSingleton();
    }
    return instancia;
}


    public Connection getConexao() { return conexao; }

}
