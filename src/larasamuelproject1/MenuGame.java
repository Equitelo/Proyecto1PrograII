/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package larasamuelproject1;

import java.awt.Color;
import javax.swing.*;

public class MenuGame extends JFrame{
    
    private JPanel panel;
    
    Admin admin;
    
    public MenuGame(Admin admin){
        this.admin=admin;
        initComponents();
    }
    
    private void initComponents () {
        this.setSize(500, 500);
        panel = new JPanel();
        panel.setSize(500, 500);
        panel.setBackground(Color.red);
        this.add(panel);
    }
}
