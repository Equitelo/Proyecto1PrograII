package larasamuelproject1;

import javax.swing.JOptionPane;
import pieces.Piece;

public class CheckScanner {
    Board board;

    public CheckScanner(Board board) {
        this.board = board;
    }

    public boolean isGeneralChecked(Move move) {
        Piece general = board.findGeneral(move.piece.isWhite);
        if (general == null) {
            return false;
        }

        int generalCol = general.col;
        int generalRow = general.row;

        // Simula el movimiento del general si es el que se está moviendo
        if (move.piece.name.equals("General")) {
            generalCol = move.newCol;
            generalRow = move.newRow;
        }
        
        if(generalFaceToFace()){
            
            return true;
        }
        
        return false;
    }

    public boolean generalFaceToFace() {
    // Encuentra las posiciones de los Generales
        Piece whiteGeneral = board.findGeneral(true);
        Piece blackGeneral = board.findGeneral(false);

        // Verifica si están en la misma columna
        if (whiteGeneral.col != blackGeneral.col) {
            return false;
        }

        // Revisa si hay alguna pieza entre los Generales en la misma columna
        int startRow = Math.min(whiteGeneral.row, blackGeneral.row);
        int endRow = Math.max(whiteGeneral.row, blackGeneral.row);

        for (int row = startRow + 1; row < endRow; row++) {
            if (board.getPiece(whiteGeneral.col, row) != null) {
                // Hay una pieza entre los Generales
                return false;
            }
        }

        // No hay piezas entre los Generales, están "cara a cara"
        return true;
    }
    public boolean isGameOver(Piece general){
        for(Piece piece : board.pieceList){
            if(board.sameTeam(piece, general)){
                board.selectedPiece = piece == general ? general : null;
                for (int row = 0; row < board.rows; row++) {
                    for (int col = 0; col < board.cols; col++) {
                        Move move = new Move(board, piece, col, row);
                        if (board.isValidMove(move)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
