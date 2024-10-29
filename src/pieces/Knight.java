package pieces;

import java.awt.image.BufferedImage;
import larasamuelproject1.Board;

public class Knight extends Piece{
    
    public Knight (Board board, int col, int row, boolean isWhite) {
        super(board);
        this.col=col;
        this.row=row;
        
        this.xPos=col*board.titleSize;
        this.yPos=row*board.titleSize;
        
        this.isWhite=isWhite;
        this.name="Knight";
        
        int columnIndex = 6; // Última columna donde está el caballo en tu imagen de sprites
        
        this.sprite=sheet.getSubimage(columnIndex * sheetScaleWidth, isWhite ? 0 : 1 * sheetScaleHeight, sheetScaleWidth, sheetScaleHeight).getScaledInstance(board.titleSize, board.titleSize, BufferedImage.SCALE_SMOOTH);
    }
    
    @Override
    public boolean isValidMovement(int col, int row){
        return Math.abs(col - this.col) * Math.abs(row - this.row) == 2;
    }
    
    @Override
    public boolean moveCollidesWithPiece(int col, int row) {
        int deltaX = col - this.col;
        int deltaY = row - this.row;

        if (Math.abs(deltaX) == 2 && Math.abs(deltaY) == 1) {
            int checkX = this.col + deltaX / 2;
            int checkY = this.row;
            if (board.getPiece(checkX, checkY) != null) {
                return true;
            }
        } else if (Math.abs(deltaX) == 1 && Math.abs(deltaY) == 2) {
            int checkX = this.col;
            int checkY = this.row + deltaY / 2;
            if (board.getPiece(checkX, checkY) != null) {
                return true;
            }
        }

        return false;
    }
    @Override
    public String getName() {
        return name;
    }
    
}
