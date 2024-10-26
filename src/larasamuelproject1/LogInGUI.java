package larasamuelproject1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class LogInGUI extends JFrame implements ActionListener{
    
    private JPanel panel;
    private JButton goBackBtn;
    private JLabel titleLogIn;
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
        
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.red);
        panel.setSize(500, 500);
        
        goBackBtn = new JButton("Regresar");
        goBackBtn.setBounds(0, 0, 100, 25);
        goBackBtn.addActionListener(this);
        
        titleLogIn = new JLabel("Log In");
        titleLogIn.setFont(new Font("Algerian", Font.PLAIN, 50));
        titleLogIn.setBounds(170, 0, 250, 60);
        usernameLbl = new JLabel("Username: ");
        userTxt = new JTextField();
        passwordLbl = new JLabel("Password: ");
        passwordTxt = new JPasswordField();
        verify = new JButton("Verificar");
        
        usernameLbl.setFont(new Font("Calibri", Font.BOLD, 15));
        usernameLbl.setBounds(125, 150, 90, 25);
        userTxt.setBounds(200, 150, 90, 25);
        passwordLbl.setFont(new Font("Calibri", Font.BOLD, 15));
        passwordLbl.setBounds(125, 200, 90, 25);
        passwordTxt.setBounds(200, 200, 90, 25);
        
        verify.setBounds(200, 250, 90, 25);
        verify.addActionListener(this);
        
        panel.add(goBackBtn);
        panel.add(titleLogIn);
        panel.add(usernameLbl);
        panel.add(userTxt);
        panel.add(passwordLbl);
        panel.add(passwordTxt);
        panel.add(verify);
        this.add(panel);
    }
    
    @Override
    public void actionPerformed(ActionEvent evt){
        if(evt.getSource()==goBackBtn){
            Menu startPage = new Menu(admin);
            startPage.setVisible(true);
            this.dispose();
        }else if (evt.getSource()==verify) {
            String user = userTxt.getText();
            String password = passwordTxt.getText();
            if (user.isEmpty()||password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No ha llenado todas las casillas");
            }else {
                if(admin.buscarUsuario(user)){
                    JOptionPane.showMessageDialog(null, "Usuario encontrado!");
                    MenuGame menuG = new MenuGame(admin);
                    menuG.setVisible(true);
                    menuG.setLocationRelativeTo(null);
                    menuG.setlblNameUser("@"+userTxt.getText());
                    this.dispose();
                }
            }
        }
    }
    
}
