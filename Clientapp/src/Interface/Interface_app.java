/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;


/**
 *
 * @author pc
 */
public interface Interface_app extends Remote {
    
    public void ajouter(String nom,String email)throws RemoteException;
}
