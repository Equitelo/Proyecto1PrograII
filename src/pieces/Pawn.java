package pieces;

import java.awt.image.BufferedImage;
import larasamuelproject1.Board;

public class Pawn extends Piece{
    public Pawn (Board board, int col, int row, boolean isWhite) {
        super(board);
        this.col=col;
        this.row=row;
        
        this.xPos=col*board.titleSize;
        this.yPos=row*board.titleSize;
        
        this.isWhite=isWhite;
        this.name="Pawn";
        
        int columnIndex = 4; // Última columna donde está el caballo en tu imagen de sprites
        
        this.sprite=sheet.getSubimage(columnIndex * sheetScaleWidth, isWhite ? 0 : 1 * sheetScaleHeight, sheetScaleWidth, sheetScaleHeight).getScaledInstance(board.titleSize, board.titleSize, BufferedImage.SCALE_SMOOTH);
    }
    
    @Override
    public boolean isValidMovement(int col, int row) {
        int colorIndex = isWhite ? -1 : 1;

        if (this.col == col && row == this.row - colorIndex) {
            Piece destino = board.getPiece(col, row);
            if (destino == null || !board.sameTeam(this, destino)) {
                return true;
            }
        }

        boolean cruzoRio = (isWhite && this.row > 4) || (!isWhite && this.row < 5);

        if (cruzoRio) {
            if (Math.abs(col - this.col) == 1 && row == this.row) {
                Piece destino = board.getPiece(col, row);
                return destino == null || !board.sameTeam(this, destino);
            }
        }

        return false;
    }

    public String getName() {
        return name;
    }
}
