/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package larasamuelproject1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MenuGame extends JFrame implements ActionListener{
    
    private String usuario;
    
    private JPanel panel;
    private JLabel lblNameUser;
    private JButton jugarBtn;
    private JButton miCuentaBtn;
    private JButton reportesBtn;
    private JButton logOutBtn;
    
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
        panel.setLayout(null);
        
        lblNameUser = new JLabel();
        lblNameUser.setFont(new Font("Calibri", Font.BOLD, 40));
        lblNameUser.setBounds(200, 100, 200, 50);
        
        jugarBtn = new JButton("Jugar Xiangqui");
        miCuentaBtn = new JButton("Mi Cuenta");
        reportesBtn = new JButton("Reportes");
        logOutBtn = new JButton("Log Out");
        
        jugarBtn.setBounds(185, 150, 125, 25);
        miCuentaBtn.setBounds(197, 200, 95, 25);
        reportesBtn.setBounds(200, 250, 90, 25);
        logOutBtn.setBounds(200, 300, 90, 25);
        jugarBtn.addActionListener(this);
        miCuentaBtn.addActionListener(this);
        reportesBtn.addActionListener(this);
        logOutBtn.addActionListener(this);
        panel.add(lblNameUser);
        panel.add(jugarBtn);
        panel.add(miCuentaBtn);
        panel.add(reportesBtn);
        panel.add(logOutBtn);
        this.add(panel);
    }
    
    public void setlblNameUser(String usuario){
        this.usuario=usuario;
        lblNameUser.setText(usuario);
    }
    
    @Override
    public void actionPerformed(ActionEvent evt){
        
        if (evt.getSource()==jugarBtn) {
            String responses[] = {"Nueva Partida", "Cancelar"};
            int getResponse = JOptionPane.showOptionDialog(null, "Jugar", "Partida", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, responses, 0);
            switch(getResponse){
                case 0:
                    ElegirOponente select = new ElegirOponente(admin);
                    select.setVisible(true);
                    this.dispose();
                    break;
                case 1:
                    break;
            }
        }else if(evt.getSource()==miCuentaBtn){
            String responses[] = {"Cambiar Password", "Cerrar mi Cuenta"};
            int getResponse = JOptionPane.showOptionDialog(null, "Que deseas hacer?", "Ver mi informacion", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, responses, 0);
            switch(getResponse){
                case 0:
                    
                    String getActual = JOptionPane.showInputDialog("Ingresar contraseña actual: ");
                    if(admin.usuarioActual.getPassword().equals(getActual)){
                        String getNueva = JOptionPane.showInputDialog("Ingresar nueva: ");
                        if(getNueva != null && !getNueva.isEmpty() && getNueva.length() == 5){
                            admin.usuarioActual.setNewPassword(getNueva);
                            JOptionPane.showMessageDialog(null, "Actualizada Correctamente!");
                        } else {
                            JOptionPane.showMessageDialog(null, "No es valido!");
                        }    
                    } else {
                        JOptionPane.showMessageDialog(null, "Es incorrecta.");
                    }
                    break;
                case 1:
                    break;
            }
        }else if(evt.getSource()==reportesBtn){
            String responses[] = {"Ranking", "Logs de mis juegos"};
            int getResponse = JOptionPane.showOptionDialog(null, "Revisa tu Rendimiento", "Reportes", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, responses, 0);
            switch(getResponse){
                case 0:
                    break;
                case 1:
                    break;
            }
        }else if(evt.getSource()==logOutBtn){
            int salida = JOptionPane.showConfirmDialog(null, usuario+", desea cerrar sesion?", "Cerrar Sesion", JOptionPane.OK_CANCEL_OPTION);
            if(salida==0){
                Menu menu = new Menu(admin);
                menu.setVisible(true);
                this.dispose();
            }
        }
    }
}
