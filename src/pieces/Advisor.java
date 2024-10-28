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
public class Advisor extends Piece{
    
    public Advisor (Board board, int col, int row, boolean isWhite) {
        super(board);
        this.col=col;
        this.row=row;
        
        this.xPos=col*board.titleSize;
        this.yPos=row*board.titleSize;
        
        this.isWhite=isWhite;
        this.name="Advisor";
        
        int columnIndex = 2; // Última columna donde está el caballo en tu imagen de sprites
        
        this.sprite=sheet.getSubimage(columnIndex * sheetScaleWidth, isWhite ? 0 : 1 * sheetScaleHeight, sheetScaleWidth, sheetScaleHeight).getScaledInstance(board.titleSize, board.titleSize, BufferedImage.SCALE_SMOOTH);
    }
    
    @Override
    public boolean isValidMovement(int col, int row){
        if( Math.abs((col - this.col) * (row - this.row)) == 1){
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
    
//    @Override
//    public boolean moveCollidesWithPiece(int col, int row){
//        
//        //up left
//        if (this.col > col && this.row > row){
//            for (int i = 1; i < Math.abs(this.col - col); i++) {
//                if (board.getPiece(this.col - i, this.row - i)!=null) {
//                    return true;
//                }
//            }
//        }
//        
//        //up right
//        if (this.col < col && this.row > row){
//            for (int i = 1; i < Math.abs(this.col - col); i++) {
//                if (board.getPiece(this.col + i, this.row - i)!=null) {
//                    return true;
//                }
//            }
//        }
//        
//        //down left
//        if (this.col < col && this.row < row){
//            for (int i = 1; i < Math.abs(this.col - col); i++) {
//                if (board.getPiece(this.col + i, this.row + i)!=null) {
//                    return true;
//                }
//            }
//        }
//        
//        //down right
//        if (this.col < col && this.row < row){
//            for (int i = 1; i < Math.abs(this.col - col); i++) {
//                if (board.getPiece(this.col + i, this.row + i)!=null) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
}
