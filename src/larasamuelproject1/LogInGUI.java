package larasamuelproject1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class LogInGUI extends JFrame implements ActionListener{
    
    private JPanel panel;
    private JLabel usernameLbl;
    private JTextField userTxt;
    private JLabel passwordLbl;
    private JPasswordField passwordTxt;
    private JButton verify;
    
    Admin admin;
    
    public LogInGUI(Admin admin){
        this.admin=admin;
        initComponents();
    }
    
    private void initComponents(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        usernameLbl = new JLabel("Username: ");
        userTxt = new JTextField();
        passwordLbl = new JLabel("Password: ");
        passwordTxt = new JPasswordField();
        verify = new JButton("Verificar");
        
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.red);
        panel.setSize(500, 500);
        usernameLbl.setFont(new Font("Calibri", Font.BOLD, 15));
        usernameLbl.setBounds(125, 150, 90, 25);
        userTxt.setBounds(200, 150, 90, 25);
        passwordLbl.setFont(new Font("Calibri", Font.BOLD, 15));
        passwordLbl.setBounds(125, 200, 90, 25);
        passwordTxt.setBounds(200, 200, 90, 25);
        verify.setBounds(200, 250, 90, 25);
        panel.add(usernameLbl);
        panel.add(userTxt);
        panel.add(passwordLbl);
        panel.add(passwordTxt);
        panel.add(verify);
        this.add(panel);
    }
    
    @Override
    public void actionPerformed(ActionEvent evt){
        if (evt.getSource()==verify) {
            String user = userTxt.getText();
            String password = passwordTxt.getText();
            if (user.isEmpty()||password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No ha llenado todas las casillas");
            }else {
                if(admin.buscarUsuario(user)!=null){
                    JOptionPane.showMessageDialog(null, "Usuario encontrado!");
                    MenuGame menuG = new MenuGame(admin);
                    menuG.setVisible(true);
                    menuG.setLocationRelativeTo(null);
                    this.dispose();
                }
            }
        }
    }
    
}
