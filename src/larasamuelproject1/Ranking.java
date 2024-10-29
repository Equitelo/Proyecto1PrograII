package larasamuelproject1;

import javax.swing.*;
import java.awt.*;

public class Ranking extends JFrame {

    private JPanel panel;
    private JTextArea rankingArea;
    private JButton volverBtn;
    private Admin admin;

    public Ranking(Admin admin) {
        this.admin = admin;
        initComponents();
        this.setLocationRelativeTo(null);
    }

    private void initComponents() {
        this.setSize(400, 400);
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.red);

        rankingArea = new JTextArea();
        rankingArea.setEditable(false);
        rankingArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
        
        // Obtener los datos del ranking
        String[] rankingData = admin.ranking();
        StringBuilder rankingText = new StringBuilder();
        for (String line : rankingData) {
            rankingText.append(line).append("\n");
        }
        
        rankingArea.setText(rankingText.toString());
        
        JScrollPane scrollPane = new JScrollPane(rankingArea);
        scrollPane.setBounds(50, 50, 300, 200);

        volverBtn = new JButton("Volver");
        volverBtn.setBounds(150, 300, 100, 30);
        volverBtn.addActionListener(e -> {
            MenuGame menuGame = new MenuGame(admin);
            menuGame.setVisible(true);
            this.dispose();
        });

        panel.add(scrollPane);
        panel.add(volverBtn);
        
        this.add(panel);
    }
}