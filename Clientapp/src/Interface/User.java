/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.io.Serializable;

/**
 *
 * @author pc
 */
public class User implements Serializable {
   private String nom;
   private String email;

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(String nom, String email) {
        this.nom = nom;
        this.email = email;
    }
   
}
