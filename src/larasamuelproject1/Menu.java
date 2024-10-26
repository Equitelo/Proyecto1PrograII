/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package larasamuelproject1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Menu extends JFrame implements ActionListener {
    
    private JPanel panel;
    private JLabel menuLbl;
    private JButton logInBtn;
    private JButton signInBtn;
    private JButton exitBtn;
    
    Admin admin;
    
    public Menu(Admin admin){
        this.admin=admin;
        initComponents();
    }
    
    private void initComponents () {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        panel = new JPanel();
        panel.setSize(500, 500);
        panel.setBackground(Color.red);
        panel.setLayout(null);
        menuLbl = new JLabel("Inicio");
        menuLbl.setFont(new Font("Algerian", Font.PLAIN, 50));
        menuLbl.setBounds(177, 0, 250, 60);
        logInBtn = new JButton("Log In");
        signInBtn = new JButton("Crear Player");
        exitBtn = new JButton("Salir");
        signInBtn.setBounds(192, 150, 110, 25);
        logInBtn.setBounds(200, 200, 90, 25);
        exitBtn.setBounds(200, 250, 90, 25);
        logInBtn.addActionListener(this);
        signInBtn.addActionListener(this);
        exitBtn.addActionListener(this);
        panel.add(menuLbl);
        panel.add(logInBtn);
        panel.add(signInBtn);
        panel.add(exitBtn);
        this.add(panel);
        this.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent evt){
        if (evt.getSource()==logInBtn) {
            LogInGUI logIn = new LogInGUI(admin);
            logIn.setVisible(true);
            logIn.setLocationRelativeTo(null);
            this.dispose();
        } else if (evt.getSource()==signInBtn) {
            SignInGUI signIn = new SignInGUI(admin);
            signIn.setVisible(true);
            signIn.setLocationRelativeTo(null);
            this.dispose();
        } else if (evt.getSource()==exitBtn) {
            this.dispose();
        }
    }
}
