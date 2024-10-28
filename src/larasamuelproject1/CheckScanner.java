package larasamuelproject1;

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

    private boolean generalFaceToFace(){
        Piece whiteGeneral = board.findGeneral(true);
        Piece redGeneral = board.findGeneral(false);
        
        if (whiteGeneral.col != redGeneral.col) {
            return false;
        }
        
        int startRow = Math.min(whiteGeneral.row, redGeneral.row)+1;
        int endRow = Math.max(whiteGeneral.row, redGeneral.row);
        
        for (int row = startRow; row < endRow; row++) {
            if (board.getPiece(whiteGeneral.col, row)!=null) {
                return false;
            }
        }
        
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
