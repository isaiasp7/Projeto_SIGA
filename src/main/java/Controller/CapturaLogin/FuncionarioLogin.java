/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.CapturaLogin;

/**
 *
 * @author Isaias
 */
public class FuncionarioLogin {
    private  static Integer id ;
    private static String cargo;

    public static Integer getId() {
        return id;
    }

    public static void setId(Integer aId) {
        id = aId;
    }

 

    public static String getCargo() {
        return cargo;
    }

    public static void setCargo(String cargo) {
        FuncionarioLogin.cargo = cargo;
    }


    public FuncionarioLogin(int id) {
        this.id = id;

    }
    
     

    


    

}
