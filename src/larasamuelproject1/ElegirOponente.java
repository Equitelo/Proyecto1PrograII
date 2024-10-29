package larasamuelproject1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ElegirOponente extends JFrame implements ActionListener{
    
    private JPanel panel;
    private JLabel title;
    private JButton goBackBtn;
    private JComboBox choseOponent;
    private JButton aceptBtn;
    
    Admin admin;
    
    ElegirOponente(Admin admin){
        this.admin=admin;
        initComponents();
    }
    
    private void initComponents(){
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        
        panel = new JPanel();
        panel.setSize(500, 500);
        panel.setBackground(Color.red);
        panel.setLayout(null);
        
        title = new JLabel("ESCOGE TU OPONENTE");
        title.setFont(new Font("Algerian", Font.BOLD, 28));
        title.setBounds(90, 100, 300, 60);
        
        goBackBtn = new JButton("Regresar");
        goBackBtn.setBounds(0, 0, 100, 25);
        goBackBtn.addActionListener(this);
        
        choseOponent = new JComboBox();
        choseOponent.setBounds(175, 200, 150, 25);
        choseOponent.setModel(new DefaultComboBoxModel(admin.mostrarOponente()));
        
        aceptBtn = new JButton("Escoger");
        aceptBtn.setBounds(200, 400, 100, 25);
        aceptBtn.addActionListener(this);
        
        panel.add(goBackBtn);
        panel.add(title);
        panel.add(choseOponent);
        panel.add(aceptBtn);
        this.add(panel);
    }
    
    @Override
    public void actionPerformed(ActionEvent evt){
        if (evt.getSource()==aceptBtn) {
            
            String seleccionado = (String) choseOponent.getSelectedItem();
            
            if (seleccionado.equals("No hay suficientes usuarios registrados")){
                JOptionPane.showMessageDialog(null, "No es posible jugar!");
            } else {
                JOptionPane.showMessageDialog(null, "A JUGAR!");
                JFrameBoard frameBoard = new JFrameBoard(admin);
                frameBoard.setVisible(true);
                frameBoard.setLblPlayer2(seleccionado);
                this.dispose();
            }
        }else if (evt.getSource()==goBackBtn){
            MenuGame menuG = new MenuGame(admin);
            menuG.setVisible(true);
            this.dispose();
        }
    }
    
}
