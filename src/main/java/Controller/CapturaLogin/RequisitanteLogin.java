/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Login;

/**
 *
 * @author Isaias
 */
public class RequisitanteLogin {
    private static Integer id;
    private static String nome;

    public RequisitanteLogin(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
        
        
    }

    public static Integer getId() {
        return id;
    }

    public  void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
