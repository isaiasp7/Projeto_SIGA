/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Login;

/**
 *
 * @author Isaias
 */
public class FuncionarioLogin {
    private  static Integer id ;
    private static Integer id_empresa_fk;

    public static Integer getId() {
        return id;
    }

    public static void setId(Integer aId) {
        id = aId;
    }

    public static Integer getId_empresa_fk() {
        return id_empresa_fk;
    }

    public static void setId_empresa_fk(Integer id_empresa_fk) {
        FuncionarioLogin.id_empresa_fk = id_empresa_fk;
    }


    public FuncionarioLogin(int id, int id_empresa_fk) {
        this.id = id;
        this.id_empresa_fk = id_empresa_fk;

    }
    
     

    


    

}
