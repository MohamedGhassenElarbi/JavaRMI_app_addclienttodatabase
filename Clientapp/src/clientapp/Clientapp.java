/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientapp;

import Interface.Interface_app;
import Interface.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.rmi.Remote;

/**
 *
 * @author pc
 */
public class Clientapp {
public String nom;
public String email;
    /**
     * @param args the command line arguments
     */
   // ajout ea;
    /*public Clientapp(ajout ea){
       this.ea=ea;
    }*/
    public Clientapp(String nom,String email){
       this.nom=nom;
       this.email=email;
       app();
    }
    
   
       
        public void app(){   
        try {
            
            Interface_app c = (Interface_app)Naming.lookup("rmi://localhost:1099/user1");
            System.out.println("clientapp"+nom);
            System.out.println("clientapp"+email);
            //User a =new  User(nom,email);
           // System.out.println("creation instance user");
            c.ajouter(nom,email) ;
            System.out.println("appel ajouter");
            
                
        } catch (Exception er) {
            er.printStackTrace();
        }
        }
       
       
    
    
}
