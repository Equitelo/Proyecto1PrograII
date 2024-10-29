package larasamuelproject1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class HistorialPartidas extends JFrame implements ActionListener {
    
    Admin admin;
    
    public HistorialPartidas(Admin admin) {
        this.admin = admin;
        initComponents();
    }
    
    private JPanel panel;
    private JList<String> lista;
    private JButton goBackBtn;
    private DefaultListModel<String> listModel;
    
    private void initComponents() {
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        
        panel = new JPanel();
        panel.setSize(500, 500);
        panel.setBackground(Color.red);
        panel.setLayout(null);
        
        listModel = new DefaultListModel<>();
        lista = new JList<>(listModel);
        lista.setBounds(100, 50, 300, 300);
        
        // Cargar el historial de partidas del usuario actual en orden inverso (partidas recientes primero)
        ArrayList<Partida> historial = admin.usuarioActual.getHistorialPartidas();
        for (int i = historial.size() - 1; i >= 0; i--) {
            listModel.addElement(historial.get(i).toString());
        }
        
        goBackBtn = new JButton("Regresar");
        goBackBtn.setBounds(200, 380, 100, 25);
        goBackBtn.addActionListener(this);
        
        panel.add(lista);
        panel.add(goBackBtn);
        this.add(panel);
    }
    
    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == goBackBtn) {
            MenuGame menuG = new MenuGame(admin);
            menuG.setVisible(true);
            this.dispose();
        }
    }
}