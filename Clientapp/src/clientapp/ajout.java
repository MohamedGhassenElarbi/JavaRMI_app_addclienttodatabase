/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientapp;
import Interface.Interface_app;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import Interface.User;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
/**
 *
 * @author pc
 */
public class ajout extends JFrame implements ActionListener  {
JLabel nom;
JLabel adresse;
JTextField nomTxt;
JTextField adrTxt;
JButton ajouter;
JPanel I;
String head []={"id","nom","adresse"};
DefaultTableModel model =new DefaultTableModel(head,0);
JTable tab1 =new JTable(model);
JScrollPane sp=new JScrollPane(tab1);
public ajout(){
super("ajout utilisateur");
setDefaultCloseOperation(EXIT_ON_CLOSE);
init();
setSize(500,500);
setLocationRelativeTo(null);

}
public void init(){
nomTxt=new JTextField();
adrTxt=new JTextField();
nom=new JLabel("Nom");
adresse=new JLabel("adresse");
ajouter=new JButton("ajouter");
		
I=new JPanel();
I.setLayout(new GridLayout(3,2));
		
		
I.add(nom);
I.add(nomTxt);
I.add(adresse);
I.add(adrTxt);
I.add(new JLabel());
I.add(ajouter);
ajouter.addActionListener(this);		
	//ajouter.addActionListener(new Clientapp(this));
		
	
		
		
for(int i=0;i<10;i++)
model.addRow(new Object[]{i,"a","a"});
		
		
setLayout(new BorderLayout());
add("South", sp);
add("Center",I);
		
		
		
}
  public static void main(String[] args) {
      
  ajout test=new ajout();
  test.show();
  }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == ajouter){
           
           /* try {
                Registry reg=LocateRegistry.getRegistry("127.0.0.1", 1099);
            Interface_app c = (Interface_app)Naming.lookup("rmi://localhost:1099/user1");
            System.out.println("aaaaa");
            //User a =new  User(nomTxt.getText().toString(),adrTxt.getText().toString());
           c.ajouter(a) ;
            
                
        } catch (Exception er) {
            er.printStackTrace();
        }*/
       Clientapp c =    new Clientapp(nomTxt.getText().toString(),adrTxt.getText().toString());
       
       }
       
    }

}
