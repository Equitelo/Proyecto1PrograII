/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pieces;

import java.awt.image.BufferedImage;
import larasamuelproject1.Board;

/**
 *
 * @author user
 */
public class General extends Piece{
    public General (Board board, int col, int row, boolean isWhite) {
        super(board);
        this.col=col;
        this.row=row;
        
        this.xPos=col*board.titleSize;
        this.yPos=row*board.titleSize;
        
        this.isWhite=isWhite;
        this.name="General";
        
        int columnIndex = 0; // Última columna donde está el caballo en tu imagen de sprites
        
        this.sprite=sheet.getSubimage(columnIndex * sheetScaleWidth, isWhite ? 0 : 1 * sheetScaleHeight, sheetScaleWidth, sheetScaleHeight).getScaledInstance(board.titleSize, board.titleSize, BufferedImage.SCALE_SMOOTH);
    }

    public String getName() {
        return name;
    }
    
    public boolean isValidMovement(int col, int row){
        if(Math.abs(col - this.col) + Math.abs(row - this.row) == 1){
        
            if ((isWhite && row > 2) || (isWhite && col > 5) || (isWhite && col < 3)) {
                return false;
            }
            if ((!isWhite && row < 7) || (!isWhite && col > 5) || (!isWhite && col < 3)) {
                return false;
            }
            return true;
        }
        return false;
    }
}
