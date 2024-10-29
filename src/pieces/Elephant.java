/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pieces;

import java.awt.image.BufferedImage;
import larasamuelproject1.Board;

public class Elephant extends Piece {
    public Elephant (Board board, int col, int row, boolean isWhite) {
        super(board);
        this.col=col;
        this.row=row;
        
        this.xPos=col*board.titleSize;
        this.yPos=row*board.titleSize;
        
        this.isWhite=isWhite;
        this.name="Elephant";
        
        int columnIndex = 1; // Última columna donde está el caballo en tu imagen de sprites
        
        this.sprite=sheet.getSubimage(columnIndex * sheetScaleWidth, isWhite ? 0 : 1 * sheetScaleHeight, sheetScaleWidth, sheetScaleHeight).getScaledInstance(board.titleSize, board.titleSize, BufferedImage.SCALE_SMOOTH);
    }
    
    @Override
    public boolean isValidMovement(int col, int row){
        
         if ( Math.abs(col - this.col) == 2 && Math.abs(row - this.row) == 2){
            if (isWhite && row > 4) return false;
            if (!isWhite && row < 5) return false;
            
            return true;
        } 
        return false;
    }

    public String getName() {
        return name;
    }
    
    @Override
    public boolean moveCollidesWithPiece(int col, int row){
            
        if (board.getPiece((col + this.col) / 2, (row + this.row) / 2) != null) {
            return true;                
        }
        return false;
    }
}
