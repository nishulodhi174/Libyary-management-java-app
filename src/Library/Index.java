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

public class Index extends JFrame implements ActionListener{

    JLabel l1,l2,l3,l4;
    JButton b1,b2;
    JPanel p1,p2,p3;
    Font f1,f2;
    
    Index(){
        super("Login Page");
        setLocation(500,450);
        setSize(500,200);
        
        f1 = new Font("Ariel", Font.BOLD, 25);
        f2 = new Font("Ariel", Font.BOLD, 20);
        
        l1 = new JLabel("Admin Login");
        l2 = new JLabel("Local Login");
        l3 = new JLabel("Library Management System");
        
        b1 = new JButton("Login");
        b2 = new JButton("Login");
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        ImageIcon img1;
        try {
            // Load the image using ClassLoader
            java.net.URL imageUrl = Index.class.getResource("/Library/icons/shield.png");
            if (imageUrl != null) {
                img1 = new ImageIcon(imageUrl);
                Image i = img1.getImage().getScaledInstance(130, 120, Image.SCALE_DEFAULT);
                ImageIcon img2 = new ImageIcon(i);
                l4 = new JLabel(img2);
            } else {
                System.err.println("Image not found: /Library/icons/shield.png");
            }
        } catch (Exception ex) {
            Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
        }
        l1.setFont(f2);
        l2.setFont(f2);
        l3.setFont(f1);
        
        b1.setFont(f2);
        b2.setFont(f2);
        
        l1.setHorizontalAlignment(JLabel.CENTER);
        l2.setHorizontalAlignment(JLabel.CENTER);
        l3.setHorizontalAlignment(JLabel.CENTER);
        l3.setForeground(Color.WHITE);
        
        p1 = new JPanel();
        p1.setLayout(new GridLayout(2,2,10,10));
        p1.add(l1);
        p1.add(b1);
        p1.add(l2);
        p1.add(b2);
        
        p2 = new JPanel();
        p2.setLayout(new GridLayout(1,1,10,10));
        p2.add(l4);
        p3 = new JPanel();
        p3.setLayout(new GridLayout(1,1,10,10));
        p3.add(l3);
        p3.setBackground(Color.blue);
        
        setLayout(new BorderLayout(10,10));
        add(p3,"North");
        add(p2,"West");
        add(p1,"Center");
                
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1){
            System.out.println("Admin Page");
//            new AdminLogin.setVisible(true);
            AdminLogin adminFrame = new AdminLogin();
            adminFrame.setVisible(true);
            this.setVisible(false);
        }
        if(e.getSource() == b2){
            System.out.println("Local Page");
//            new LocalLogin.setVisible(true);
            LocalLogin localFrame = new LocalLogin();
            localFrame.setVisible(true);
            this.setVisible(false);
        }
    }
    public static void main(String[] args) {
        new Index().setVisible(true);
    }
    
    
}
