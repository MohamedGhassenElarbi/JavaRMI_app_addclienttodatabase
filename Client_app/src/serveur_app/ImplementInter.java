/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serveur_app;
import Interface.Interface_app;
import Interface.User;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;
/**
 *
 * @author pc
 */
public class ImplementInter extends UnicastRemoteObject implements Interface_app{
  public ImplementInter() throws RemoteException{ 
      con =connecter();
    }
  String url="jdbc:mysql://localhost/tpbase?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",user="root",password="";	
     Connection con=null;Statement stm=null;     
     int resultUpdate; 
     int val=0;
    
   public void ajouter(User u){
       System.out.println("Opération D'ajout effectuée");
	try{
	stm=con.createStatement();
	}catch(SQLException e){
	System.out.println("SQL creation error"+e);
	}
		
		
	String query="insert into utilisateurs (nom, adresse) values('"+u.getNom()+"','"+u.getEmail()+"')";
        try{
	resultUpdate=stm.executeUpdate(query);
	}catch(SQLException e){
	System.out.println("Error executing nhhh query"+e);
	}
   }
   
   public Connection connecter() throws RemoteException{
   
       try{
	Class.forName("com.mysql.cj.jdbc.Driver");
	}catch(ClassNotFoundException e){
	System.out.println("Driver loading error"+e);
	}
     try{
	return DriverManager.getConnection(url, user, password);
	}catch(SQLException e){
	System.out.println("SQL error"+e);
	}
     return null;
   }
   
   
   
   
   public User[] affiche()throws RemoteException{
       
    
     try{
	stm=con.createStatement();
        
        
	}catch(SQLException e){
	System.out.println("SQL creation error"+e);
	}
     ResultSet resultSelect=null;
      try{
	resultSelect=stm.executeQuery("select * from  utilisateurs");
        while (resultSelect.next() ){val++;}
	}catch(SQLException e){
	System.out.println("Error executing nhhh query"+e);
	}
      int i=0;
      User tab[]=new User[val];
      
      try{
          resultSelect=stm.executeQuery("select * from  utilisateurs");
      while(resultSelect.next()){tab[i++]=new User(resultSelect.getString("nom"),resultSelect.getString("adresse"));}
      return tab;
      }catch(SQLException e){
	System.out.println("SQL creation  2"+e);
	}
      return null;
      }
      
     
   }

