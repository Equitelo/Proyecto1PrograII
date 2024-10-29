package larasamuelproject1;

import java.awt.*;
import javax.swing.*;

public class JFrameBoard{

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.black);
        frame.setLayout(new BorderLayout());
        frame.setMinimumSize(new Dimension(700, 1000));
        frame.setLocationRelativeTo(null);
        
        JButton abandonar = new JButton("Resignar");
        JLabel p1 = new JLabel("P1");
        p1.setBounds(0, 50, 100, 25);
        p1.setFont(new Font("Algerian", Font.PLAIN, 25));
        
        JLabel p2 = new JLabel("P2");
        p2.setBounds(0, 380, 100, 25);
        p2.setFont(new Font("Algerian", Font.PLAIN, 25));
        
        JTextArea listaP1 = new JTextArea();
        listaP1.setBounds(0, 80, 180, 260);
        listaP1.setFont(new Font("Calibri", Font.PLAIN, 15));
        
        JTextArea listaP2 = new JTextArea();
        listaP2.setBounds(0, 410, 180, 260);
        listaP2.setFont(new Font("Calibri", Font.PLAIN, 15));
        
        
        // Panel izquierdo para mostrar los elementos adicionales
        JPanel panelLeft = new JPanel();
        panelLeft.setPreferredSize(new Dimension(200, 1000));
        panelLeft.setLayout(null);
        panelLeft.setBackground(Color.gray);
        
        abandonar.setBounds(0, 0, 100, 25);

        // Panel contenedor del tablero
        JPanel boardContainer = new JPanel();
        boardContainer.setPreferredSize(new Dimension(650, 650));
        boardContainer.setMaximumSize(new Dimension(650, 650));
        boardContainer.setLayout(new BorderLayout());
        
        JLabel turno = new JLabel();
        turno.setBounds(100, 0, 100, 50);
        turno.setFont(new Font("Algerian", Font.PLAIN, 15));
        
        // Tablero
        Board board = new Board(listaP1, listaP2, turno);
        board.setPreferredSize(new Dimension(650, 650));
        board.setMaximumSize(new Dimension(650, 650));
        
        // Añadir el tablero al contenedor
        boardContainer.add(board, BorderLayout.CENTER);
        
        panelLeft.add(abandonar);
        panelLeft.add(turno);
        panelLeft.add(p1);
        panelLeft.add(listaP1);
        panelLeft.add(p2);
        panelLeft.add(listaP2);
        // Añadir paneles al frame
        frame.add(panelLeft, BorderLayout.WEST);
        frame.add(boardContainer, BorderLayout.CENTER);

        frame.pack(); // Empaquetar el frame para respetar los tamaños preferidos
        frame.setVisible(true);
    }
}
