package larasamuelproject1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MiCuenta extends JFrame implements ActionListener{
    
    Admin admin;
    
    public MiCuenta(Admin admin){
        this.admin=admin;
        initComponents();
    }
    
    private JPanel panel;
    private JLabel userNameLbl;
    private JLabel puntosLbl;
    private JLabel fechaLbl;
    private JLabel estadoLbl;
    private JButton goBackBtn;
    private JButton changePasswordBtn;
    private JButton deleteAccountBtn;
    
    private void initComponents(){
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        panel = new JPanel();
        panel.setSize(500, 500);
        panel.setBackground(Color.red);
        panel.setLayout(null);
        
        goBackBtn = new JButton("Regresar");
        goBackBtn.setBounds(0,0,100,25);
        goBackBtn.addActionListener(this);
        
        userNameLbl = new JLabel();
        userNameLbl.setBounds(30, 50, 150, 25);
        userNameLbl.setFont(new Font("Calibri", Font.BOLD, 20));
        userNameLbl.setText("@"+admin.usuarioActual.getUser());
        
        fechaLbl = new JLabel();
        fechaLbl.setBounds(30, 100, 250, 25);
        fechaLbl.setFont(new Font("Calibri", Font.BOLD, 20));
        fechaLbl.setText("Fecha de ingreso: "+admin.usuarioActual.getFecha());
        
        puntosLbl = new JLabel();
        puntosLbl.setBounds(30, 150, 100, 25);
        puntosLbl.setFont(new Font("Calibri", Font.BOLD, 20));
        puntosLbl.setText("Puntos: "+admin.usuarioActual.getPuntos());
        
        estadoLbl = new JLabel();
        estadoLbl.setBounds(30, 200, 250, 25);
        estadoLbl.setFont(new Font("Calibri", Font.BOLD, 20));
        estadoLbl.setText("Estado: Activo");
        
        changePasswordBtn = new JButton("Cambiar Password");
        changePasswordBtn.setBounds(325, 75, 150, 25);
        changePasswordBtn.addActionListener(this);
        
        deleteAccountBtn = new JButton("Eliminar Cuenta");
        deleteAccountBtn.setBounds(325, 175, 150, 25);
        deleteAccountBtn.addActionListener(this);
        
        panel.add(userNameLbl);
        panel.add(fechaLbl);
        panel.add(puntosLbl);
        panel.add(estadoLbl);
        panel.add(changePasswordBtn);
        panel.add(deleteAccountBtn);
        panel.add(goBackBtn);
        this.add(panel);
    }
    
    @Override
    public void actionPerformed(ActionEvent evt) {
        
        if (evt.getSource() == goBackBtn) {
            MenuGame menuG = new MenuGame(admin);
            menuG.setVisible(true);
            this.dispose();
            
        } else if (evt.getSource() == changePasswordBtn) {

            String getActual = JOptionPane.showInputDialog("Ingresar contraseña actual: ");
            if (admin.usuarioActual.getPassword().equals(getActual)) {
                String getNueva = JOptionPane.showInputDialog("Ingresar nueva: ");
                if (getNueva != null && !getNueva.isEmpty() && getNueva.length() == 5) {
                    admin.usuarioActual.setNewPassword(getNueva);
                    JOptionPane.showMessageDialog(null, "Actualizada Correctamente!");
                } else {
                    JOptionPane.showMessageDialog(null, "No es valido!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Es incorrecta.");
            }

        } else if (evt.getSource() == deleteAccountBtn) {
            String getContra = JOptionPane.showInputDialog("");
            if (admin.usuarioActual.getPassword().equals(getContra)) {
               if(admin.logOut(getContra)){
                    Menu menu = new Menu(admin);
                    menu.setVisible(true);
                    this.dispose(); 
               } else {
                   JOptionPane.showMessageDialog(null, "No coincide la password");
               }
            }
        }
    }
    
}
