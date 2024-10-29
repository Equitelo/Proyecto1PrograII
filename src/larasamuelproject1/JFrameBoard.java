package larasamuelproject1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JFrameBoard extends JFrame implements ActionListener, GameState{
    
    Admin admin;
    private String user;
    
    JButton abandonarBtn;
    JLabel player1Lbl;
    JLabel player2Lbl;
    JTextArea listaP1;
    JTextArea listaP2;
    JPanel panelLeft;
    JPanel boardContainer;
    JLabel turno;
    
    public JFrameBoard(Admin admin) {
        this.admin=admin;
        initComponents();
    }
    
    private void initComponents(){
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.black);
        this.setLayout(new BorderLayout());
        this.setMinimumSize(new Dimension(700, 1000));
        this.setLocationRelativeTo(null);
        
        abandonarBtn = new JButton("Resignar");
        player1Lbl = new JLabel();
        player1Lbl.setBounds(0, 50, 100, 25);
        player1Lbl.setFont(new Font("Algerian", Font.PLAIN, 25));
        player1Lbl.setText(admin.usuarioActual.getUser());
        
        player2Lbl = new JLabel();
        player2Lbl.setBounds(0, 380, 100, 25);
        player2Lbl.setFont(new Font("Algerian", Font.PLAIN, 25));
        
        listaP1 = new JTextArea();
        listaP1.setBounds(0, 80, 180, 260);
        listaP1.setFont(new Font("Calibri", Font.PLAIN, 15));
        listaP1.setEditable(false);
        
        listaP2 = new JTextArea();
        listaP2.setBounds(0, 410, 180, 260);
        listaP2.setFont(new Font("Calibri", Font.PLAIN, 15));
        listaP2.setEditable(false);
        
        // Panel izquierdo para mostrar los elementos adicionales
        panelLeft = new JPanel();
        panelLeft.setPreferredSize(new Dimension(200, 1000));
        panelLeft.setLayout(null);
        panelLeft.setBackground(Color.gray);
        
        abandonarBtn.setBounds(0, 0, 100, 25);
        abandonarBtn.addActionListener(this);

        // Panel contenedor del tablero
        boardContainer = new JPanel();
        boardContainer.setPreferredSize(new Dimension(650, 650));
        boardContainer.setMaximumSize(new Dimension(650, 650));
        boardContainer.setLayout(new BorderLayout());
        
        turno = new JLabel();
        turno.setBounds(100, 0, 100, 50);
        turno.setFont(new Font("Algerian", Font.PLAIN, 15));
        
        // Tablero
        Board board = new Board(admin, listaP1, listaP2, turno, this);
        board.setPreferredSize(new Dimension(650, 650));
        board.setMaximumSize(new Dimension(650, 650));
        
        // Añadir el tablero al contenedor
        boardContainer.add(board, BorderLayout.CENTER);
        
        panelLeft.add(abandonarBtn);
        panelLeft.add(turno);
        panelLeft.add(player1Lbl);
        panelLeft.add(listaP1);
        panelLeft.add(player2Lbl);
        panelLeft.add(listaP2);
        // Añadir paneles al frame
        this.add(panelLeft, BorderLayout.WEST);
        this.add(boardContainer, BorderLayout.CENTER);

        this.pack(); // Empaquetar el frame para respetar los tamaños preferidos
        if (!board.isGameOver) {
            this.setVisible(true);
        }else{
            MenuGame menuG = new MenuGame(admin);
            menuG.setVisible(true);
            this.dispose();
        }
        
    }
    
    public void setLblPlayer2(String user){
        this.user=user;
        player2Lbl.setText(user);
    }
    
    @Override
    public void onPlayerWin() {
        JOptionPane.showMessageDialog(this, "¡Felicidades! Has ganado.");
        admin.ganarPartida(player2Lbl.getText());  // Actualizar los puntos del usuario
        MenuGame menuG = new MenuGame(admin);
        menuG.setVisible(true);
        this.dispose();
    }

    @Override
    public void onPlayerLose() {
        JOptionPane.showMessageDialog(this, "Lo siento, has perdido la partida.");
        admin.perderPartida(player2Lbl.getText()); // Actualizar los puntos del oponente
        MenuGame menuG = new MenuGame(admin);
        menuG.setVisible(true);
        this.dispose();
    }
    
    @Override
    public void actionPerformed(ActionEvent evt){
        if (evt.getSource()==abandonarBtn) {
            int salida = JOptionPane.showConfirmDialog(null, "@"+admin.usuarioActual.getUser()+", desea huir?", "Resignar", JOptionPane.OK_CANCEL_OPTION);
            switch(salida){
                case 0:
                    JOptionPane.showMessageDialog(null, "PIERDES 3 PUNTOS");
                    admin.perderPartida(player2Lbl.getText());
                    MenuGame menuG = new MenuGame(admin);
                    menuG.setVisible(true);
                    this.dispose();
                    break;
                    
            }
        }
    }
}
