/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Isaias
 */
public class SingletonBd {
        private static SingletonBd instance;
    private Connection con;

    public SingletonBd() {
           try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String id, nome, dateNascimento;

             this.con= DriverManager.getConnection("jdbc:MySQL://localhost:3306/projeto", "root", "root12345");
            Statement st = con.createStatement();//usada para fazer requisiçoes
            String sql = "SELECT * FROM alunos";

            ResultSet rs =  st.executeQuery(sql);
            
           
            
            
        } catch(Exception e){
            System.out.println( e);
        }    
        
        
           
    }
    public static SingletonBd getInstance() {
        if (instance == null) {
            instance = new SingletonBd();
        }
        return instance;
    }
    public void fetchAlunos() {
        // Usando try-with-resources para garantir que a conexão seja fechada
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projeto", "root", "root12345");
             Statement st = con.createStatement()) {
            String sql = "SELECT * FROM alunos";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String id = rs.getString("idAluno");
                String nome = rs.getString("nomeAluno");
                String dateNascimento = rs.getString("nascimento");
                // Aqui você pode processar os dados como necessário
                System.out.println("ID: " + id + ", Nome: " + nome + ", Data de Nascimento: " + dateNascimento);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao executar a consulta: " + e);
        }
    }
    
    
   /*public Aluno getAluno(){
       
           this.con.close();
           
   }*/
    
    
}
