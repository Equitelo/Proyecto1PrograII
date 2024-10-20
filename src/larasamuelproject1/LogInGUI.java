package larasamuelproject1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class LogInGUI extends JFrame implements ActionListener{
    
    JPanel panel;
    JTextField user;
    JTextField password;
    JButton verify;
    
    LogInGUI(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        user = new JTextField();
        password = new JTextField();
        verify = new JButton("Verificar");
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.red);
        panel.setSize(500, 500);
        user.setBounds(200, 150, 90, 25);
        password.setBounds(200, 200, 90, 25);
        verify.setBounds(200, 250, 90, 25);
        panel.add(user);
        panel.add(password);
        panel.add(verify);
        this.add(panel);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==verify) {
            
        }
    }
    
}
