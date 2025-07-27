/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Isaias
 */
public enum StatusPedido {
    Pendente,Recusado,Aprovado,Empacotando, Enviado,Entregue;
    public static StatusPedido conversor(String tipo){
        //'Pendente','Recusado','Empacotando', 'Enviado','Entregue'
        switch (tipo) {
            case "Pendente":
                return Pendente;
            case "Recusado":
                return Recusado;
            case "Empacotando":
                return Empacotando;
            case "Aprovado":
                return Aprovado;
            case "Enviado":
                return Enviado;
            case "Entregue":
                return Entregue;
            default:
                throw new AssertionError();
        }
    }
    
}
