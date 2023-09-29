/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Library;

/**
 *
 * @author Nishu Lodhi
 */

import java.awt.event.*;
import java.awt.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.sql.*;

public class AdminLogin extends JFrame implements ActionListener {

    JLabel l1,l2,l3;
    JButton b1,b2;
    JPanel p1,p2;
    Font f1,f2;
    JTextField tf1;
    JPasswordField pf1;
    AdminLogin(){
        super("Login Page");
        setLocation(500,450);
        setSize(500,200);
        
        f1 = new Font("Ariel", Font.BOLD, 25);
        f2 = new Font("Ariel", Font.BOLD, 20);
        
        l1 = new JLabel("Username");
        l2 = new JLabel("Password");
        l3 = new JLabel("Admin Login");
        
        b1 = new JButton("Login");
        b2 = new JButton("Cancel");
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        tf1 = new JTextField();
        pf1 = new JPasswordField();
        
        l1.setFont(f2);
        l2.setFont(f2);
        l3.setFont(f1);
        tf1.setFont(f2);
        pf1.setFont(f2);
        b1.setFont(f2);
        b2.setFont(f2);
        
        
        l3.setHorizontalAlignment(JLabel.CENTER);
        l3.setForeground(Color.WHITE);
        
        p2 = new JPanel();
        p2.setLayout(new GridLayout(3,2,10,10));
        p2.add(l1);
        p2.add(tf1);
        p2.add(l2);
        p2.add(pf1);
        p1 = new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l3);
        p1.setBackground(Color.blue);
        p2.add(b1);
        p2.add(b2);
        
        setLayout(new BorderLayout(10,10));
        add(p2,"Center");
        add(p1,"North");
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    
        String name = tf1.getText().trim();
        char[] passwordChars = pf1.getPassword();
        String pass = new String(passwordChars).trim();
        
        if(e.getSource()==b1){
            try{
                ConnectionClass obj1 = new ConnectionClass();
//                String s = "select * from admin where username = '"+name+"' and password + '"+pass+"'";
//                ResultSet res = obj1.stm.executeQuery(s);
                
                String s = "SELECT * FROM admin WHERE username = ? AND password = ?";
                PreparedStatement preparedStatement = obj1.con.prepareStatement(s);
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, pass);
                ResultSet res = preparedStatement.executeQuery();

                
                if(res.next()){
                    System.out.println("Admin Section");
                    AdminSection af = new AdminSection();
                    af.setVisible(true);
                    this.setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null, "Wrong name or pass");
                }
            }catch(Exception exp){
                exp.printStackTrace();
            }
        }
        if(e.getSource()==b2){
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new AdminLogin().setVisible(true);
    }
    
}
