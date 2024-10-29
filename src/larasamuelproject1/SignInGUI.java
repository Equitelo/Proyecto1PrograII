/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package larasamuelproject1;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SignInGUI extends JFrame implements ActionListener{
    
    private JPanel panel;
    private JButton goBackBtn;
    private JLabel titleSignIn;
    private JLabel userLbl;
    private JTextField userTxt;
    private JLabel passwordLbl;
    private JPasswordField passwordTxt;
    private JButton generateDateBtn;
    private JLabel getFechaLbl;
    private JButton signInBtn;
    
    Admin admin;
    
    public SignInGUI(Admin admin){
        this.admin=admin;
        initComponents();
    }
    
    private void initComponents () {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        panel = new JPanel();
        panel.setSize(500,500);
        panel.setBackground(Color.red);
        panel.setLayout(null);
        
        goBackBtn = new JButton("Regresar");
        goBackBtn.setBounds(0, 0, 100, 25);
        goBackBtn.addActionListener(this);
        
        titleSignIn = new JLabel("Sign In");
        titleSignIn.setFont(new Font("Algerian", Font.PLAIN, 50));
        titleSignIn.setBounds(160, 0, 250, 60);
        userLbl = new JLabel("Username: ");
        userTxt = new JTextField();
        userLbl.setFont(new Font("Calibri", Font.BOLD, 15));
        userLbl.setBounds(125, 150, 90, 25);
        userTxt.setBounds(200, 150, 90, 25);
        
        passwordLbl = new JLabel("Password: ");
        passwordTxt = new JPasswordField();
        passwordLbl.setFont(new Font("Calibri", Font.BOLD, 15));
        passwordLbl.setBounds(125, 200, 90, 25);
        passwordTxt.setBounds(200, 200, 90, 25);
        
        getFechaLbl = new JLabel("DD/MM/YY");
        generateDateBtn = new JButton("Generar Fecha");
        generateDateBtn.setBounds(65, 250, 125, 25);
        getFechaLbl.setFont(new Font("Calibri", Font.BOLD, 15));
        getFechaLbl.setBounds(200, 250, 90, 25);
        generateDateBtn.addActionListener(this);
        signInBtn = new JButton("Confirmar");
        signInBtn.setBounds(200, 300, 100, 25);
        signInBtn.addActionListener(this);
        panel.add(goBackBtn);
        panel.add(titleSignIn);
        panel.add(userLbl);
        panel.add(userTxt);
        panel.add(passwordLbl);
        panel.add(passwordTxt);
        panel.add(signInBtn);
        this.add(panel);
    }
    
    @Override
    public void actionPerformed (ActionEvent evt) {
        String fecha = getFechaLbl.getText();
        String user = userTxt.getText();
        String password = passwordTxt.getText();
        int longitud = password.length();
        if(evt.getSource()==goBackBtn){
            Menu startPage = new Menu(admin);
            startPage.setVisible(true);
            this.dispose();
        }else if (longitud<5){
            JOptionPane.showMessageDialog(null, "La contraseña debe ser de 5 caracteres al menos");
        } else if (evt.getSource()==signInBtn && longitud>=5){
            if (admin.agregarUsuario(user, password)) {
                JOptionPane.showMessageDialog(null, "Se ha registrado correctamente!");
                MenuGame menuG = new MenuGame(admin);
                menuG.setVisible(true);
                menuG.setLocationRelativeTo(null);
                this.dispose();
            }
        }
    }
    
}
