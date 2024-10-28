/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package larasamuelproject1;

import java.awt.*;
import javax.swing.*;

public class JFrameBoard {
    
    JPanel panel2;
    
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.black);
        frame.setLayout(new GridBagLayout());
        frame.setMinimumSize(new Dimension(1000, 1100));
        frame.setLocationRelativeTo(null);
        
        Board board = new Board();
        frame.add(board);
        
        frame.setVisible(true);
    }
}
