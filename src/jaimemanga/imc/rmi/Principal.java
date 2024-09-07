
package jaimemanga.imc.rmi;

import jaimemanga.imc.rmi.net.Servidor;


public class Principal {

   
    public static void main(String[] args) {
        Servidor servidor = new Servidor();
        try{
            servidor.iniciar();
        }catch(Exception ex){
            System.out.println(ex.getLocalizedMessage());
        }
    }
    
}
