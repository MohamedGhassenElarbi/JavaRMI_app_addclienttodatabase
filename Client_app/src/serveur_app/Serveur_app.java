/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serveur_app;

import Interface.User;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 *
 * @author pc
 */
public class Serveur_app {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException {
        // TODO code application logic here
         try {
            ImplementInter c= new ImplementInter();
            LocateRegistry.createRegistry(1099);
            System.setProperty("java.rmi.server.hostname","192.168.203.2");           
            Naming.rebind("rmi://192.168.203.2:1099/user1",c);
            System.out.println("Serveur en marche...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
