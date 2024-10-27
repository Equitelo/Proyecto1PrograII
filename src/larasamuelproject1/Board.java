/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package larasamuelproject1;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import pieces.Advisor;
import pieces.Canion;
import pieces.Elephant;
import pieces.General;
import pieces.Knight;
import pieces.Pawn;
import pieces.Piece;
import pieces.Rook;

public class Board extends JPanel{
    
    public int titleSize = 65;
    
    int cols = 9;
    int rows = 10;
    
    ArrayList<Piece> pieceList = new ArrayList<>();
    
    public Piece selectedPiece;
    
    Input input = new Input(this);
    
    public Board(){
        this.setPreferredSize(new Dimension(cols * titleSize, rows * titleSize));
        
        this.addMouseListener(input);
        this.addMouseMotionListener(input);
        
        this.addPieces();
    }
    
    public Piece getPiece(int col, int row){
        
        for(Piece piece: pieceList){
            if (piece.col == col && piece.row == row) {
                return piece;
            }
        }
        
        return null;
    }
    
    public void makeMove(Move move){
        
        move.piece.col = move.newCol;
        move.piece.row = move.newRow;
        move.piece.xPos = move.newCol * titleSize;
        move.piece.yPos = move.newRow * titleSize;
        
        capture(move);
    }
    
    public void capture(Move move) {
        pieceList.remove(move.capture);
    }
    
    public boolean isValidMove(Move move) {
        
        if (sameTeam(move.piece, move.capture)) {
            return false;
        }
        if (!move.piece.isValidMovement(move.newCol, move.newRow)){
            return false;
        }
        if (move.piece.moveCollidesWithPiece(move.newCol, move.newRow)) {
            return false;
        }
        
        
        return true;
    }
    
    public boolean sameTeam(Piece p1, Piece p2){
        if (p1 == null || p2 == null) {
            return false;
        }
        return p1.isWhite == p2.isWhite;
    }
    
    private void addPieces(){
        pieceList.add(new Rook(this, 0, 0, true));
        pieceList.add(new Knight(this, 1, 0, true));
        pieceList.add(new Elephant(this, 2, 0, true));
        pieceList.add(new Advisor(this, 3, 0, true));
        pieceList.add(new General(this, 4, 0, true));
        pieceList.add(new Advisor(this, 5, 0, true));
        pieceList.add(new Elephant(this, 6, 0, true));
        pieceList.add(new Knight(this, 7, 0, true));
        pieceList.add(new Rook(this, 8, 0, true));
        pieceList.add(new Canion(this, 1, 1, true));
        pieceList.add(new Pawn(this, 0, 2, true));
        pieceList.add(new Pawn(this, 2, 2, true));
        pieceList.add(new Pawn(this, 4, 2, true));
        pieceList.add(new Pawn(this, 6, 2, true));
        pieceList.add(new Pawn(this, 8, 2, true));
        pieceList.add(new Canion(this, 7, 1, true));
        
        pieceList.add(new Rook(this, 0, 9, false));
        pieceList.add(new Knight(this, 1, 9, false));
        pieceList.add(new Elephant(this, 2, 9, false));
        pieceList.add(new Advisor(this, 3, 9, false));
        pieceList.add(new General(this, 4, 9, false));
        pieceList.add(new Advisor(this, 5, 9, false));
        pieceList.add(new Elephant(this, 6, 9, false));
        pieceList.add(new Knight(this, 7, 9, false));
        pieceList.add(new Rook(this, 8, 9, false));
        pieceList.add(new Canion(this, 1, 8, false));
        pieceList.add(new Pawn(this, 0, 7, false));
        pieceList.add(new Pawn(this, 2, 7, false));
        pieceList.add(new Pawn(this, 4, 7, false));
        pieceList.add(new Pawn(this, 6, 7, false));
        pieceList.add(new Pawn(this, 8, 7, false));
        pieceList.add(new Canion(this, 7, 8, false));
    }
    
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        
        //paint board
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                g2d.setColor((c + r) % 2 ==0 ? new Color(0,100,0) : Color.white);
                g2d.fillRect(c * titleSize, r * titleSize, titleSize, titleSize);
            }
        }
        
        //paint highlights
        if (selectedPiece != null) {
            
            for (int r = 0; r < 10; r++) {
                for (int c = 0; c < 10; c++) {
                    if (isValidMove(new Move(this, selectedPiece, c, r))) {

                        g2d.setColor(new Color(0, 255, 0, 128));
                        g2d.fillRect(c * titleSize, r * titleSize, titleSize, titleSize);

                    }
                }
            }
            
        }
        
        g2d.setColor(Color.BLACK);
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                
                boolean isInPalaceSuperior = (r >= 0 && r <= 2) && (c >= 3 && c <= 5);
                boolean isInPalaceInferior = (r >= 7 && r <= 9) && (c >= 3 && c <= 5);
                
                if (isInPalaceSuperior || isInPalaceInferior) {
                    g2d.drawRect(c * titleSize, r * titleSize, titleSize, titleSize);
                }
                
            }
        }

        //Dibuja el río
        g2d.setColor(Color.BLUE);
        g2d.drawLine(0, 5 * titleSize, cols * titleSize, 5 * titleSize);

        // Dibuja el palacio superior (3x3)
        g2d.setColor(Color.BLACK);
        // Líneas del palacio superior
        int palaceX = 3 * titleSize;
        int palaceY = 0;
        g2d.drawLine(palaceX, palaceY, palaceX + 3 * titleSize, palaceY + 3 * titleSize); // Diagonal 1
        g2d.drawLine(palaceX + 3 * titleSize, palaceY, palaceX, palaceY + 3 * titleSize); // Diagonal 2

        // Dibuja el palacio inferior (3x3)
        palaceY = 7 * titleSize;
        g2d.drawLine(palaceX, palaceY, palaceX + 3 * titleSize, palaceY + 3 * titleSize); // Diagonal 1
        g2d.drawLine(palaceX + 3 * titleSize, palaceY, palaceX, palaceY + 3 * titleSize); // Diagonal 2
        
        //paint pieces
        for (Piece pos : pieceList) {
            pos.paint(g2d);
        }
        
    } 
}

