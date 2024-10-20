/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package larasamuelproject1;

import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;

public class Menu extends JFrame implements ActionListener {
    
    JButton logInBtn;
    JButton signInBtn;
    JButton exitBtn;
    JPanel panel;
    
    Menu () {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        panel = new JPanel();
        panel.setSize(500, 500);
        panel.setBackground(Color.red);
        panel.setLayout(null);
        logInBtn = new JButton("Log In");
        signInBtn = new JButton("Crear Player");
        exitBtn = new JButton("Salir");
        logInBtn.setBounds(200, 200, 90, 25);
        signInBtn.setBounds(192, 150, 110, 25);
        exitBtn.setBounds(200, 250, 90, 25);
        logInBtn.addActionListener(this);
        signInBtn.addActionListener(this);
        exitBtn.addActionListener(this);
        this.add(panel);
        panel.add(logInBtn);
        panel.add(signInBtn);
        panel.add(exitBtn);
        this.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==logInBtn) {
            LogInGUI logIn = new LogInGUI();
            logIn.setVisible(true);
            logIn.setLocationRelativeTo(null);
            this.dispose();
        } else if (e.getSource()==signInBtn) {
            SignInGUI signIn = new SignInGUI();
            signIn.setVisible(true);
            signIn.setLocationRelativeTo(null);
            this.dispose();
        } else if (e.getSource()==exitBtn) {
        
        }
    }
}
