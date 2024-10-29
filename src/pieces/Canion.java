package pieces;

import java.awt.image.BufferedImage;
import larasamuelproject1.Board;

public class Canion extends Piece {
    
    public Canion (Board board, int col, int row, boolean isWhite) {
        super(board);
        this.col=col;
        this.row=row;
        
        this.xPos=col*board.titleSize;
        this.yPos=row*board.titleSize;
        
        this.isWhite=isWhite;
        this.name="Canion";
        
        int columnIndex = 3; // Última columna donde está el caballo en tu imagen de sprites
        
        this.sprite=sheet.getSubimage(columnIndex * sheetScaleWidth, isWhite ? 0 : 1 * sheetScaleHeight, sheetScaleWidth, sheetScaleHeight).getScaledInstance(board.titleSize, board.titleSize, BufferedImage.SCALE_SMOOTH);
    }
    
    @Override
    public boolean isValidMovement(int col, int row) {
        // Verifica que el movimiento sea en línea recta
        if (this.col == col || this.row == row) {
            // Verifica si la casilla destino está vacía o tiene una pieza enemiga
            if (board.getPiece(col, row) == null) {
                // Movimiento sin captura (como una torre): se mueve libremente en línea recta
                return isPathClear(this.col, this.row, col, row);
            } else {
                // Movimiento con captura: requiere salto
                return canJumpAndCapture(this.col, this.row, col, row);
            }
        }
        return false; // Movimiento no válido si no es en línea recta
    }

    private boolean isPathClear(int startCol, int startRow, int endCol, int endRow) {
        // Calcula la dirección del movimiento
        int directionCol = Integer.signum(endCol - startCol);
        int directionRow = Integer.signum(endRow - startRow);

        int currentCol = startCol + directionCol;
        int currentRow = startRow + directionRow;

        // Recorre desde la casilla siguiente hasta la casilla final
        while (currentCol != endCol || currentRow != endRow) {
            if (board.getPiece(currentCol, currentRow) != null) {
                return false; // Hay una pieza en el camino, movimiento no válido
            }
            currentCol += directionCol;
            currentRow += directionRow;
        }
        return true; // Camino despejado
    }

    private boolean canJumpAndCapture(int startCol, int startRow, int endCol, int endRow) {
        // Calcula la dirección del movimiento
        int directionCol = Integer.signum(endCol - startCol);
        int directionRow = Integer.signum(endRow - startRow);

        int currentCol = startCol + directionCol;
        int currentRow = startRow + directionRow;
        
        boolean foundMiddlePiece = false;

        // Recorre desde la casilla siguiente hasta la casilla final
        while (currentCol != endCol || currentRow != endRow) {
            Piece currentPiece = board.getPiece(currentCol, currentRow);
            
            if (currentPiece != null) {
                if (foundMiddlePiece) {
                    // Si ya encontramos una pieza intermedia, el movimiento no es válido
                    return false;
                }
                // Marca que se encontró la pieza intermedia
                foundMiddlePiece = true;
            }
            
            // Avanza a la siguiente casilla en la dirección de movimiento
            currentCol += directionCol;
            currentRow += directionRow;
        }

        // Solo es válido si encontramos exactamente una pieza intermedia y el destino es enemigo
        Piece targetPiece = board.getPiece(endCol, endRow);
        return foundMiddlePiece && targetPiece != null && targetPiece.isWhite != this.isWhite;
    }

    public String getName() {
        return name;
    }
    
}
