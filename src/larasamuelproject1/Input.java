package larasamuelproject1;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import pieces.Piece;

public class Input extends MouseAdapter{

    Board board;
    
    public Input(Board board){
        this.board=board;
    }
    
    @Override
    public void mousePressed(MouseEvent evt) {
        
        int col = evt.getX()/board.titleSize;
        int row = evt.getY()/board.titleSize;
        
        Piece placeXY = board.getPiece(col, row);
        if (placeXY!=null) {
            board.selectedPiece = placeXY;
        }
    }
    
    @Override
    public void mouseDragged(MouseEvent evt) {
        if (board.selectedPiece!=null) {
            board.selectedPiece.xPos = evt.getX() - board.titleSize/2;
            board.selectedPiece.yPos = evt.getY() - board.titleSize/2;
            
            board.repaint();
        }
    }
    
    @Override
    public void mouseReleased(MouseEvent evt) {
        
        int col = evt.getX()/board.titleSize;
        int row = evt.getY()/board.titleSize;
        
        if (board.selectedPiece!=null) {
            
            Move move = new Move(board, board.selectedPiece, col, row);
            
            if (board.isValidMove(move)) {
                board.makeMove(move);
            } else {
                board.selectedPiece.xPos = board.selectedPiece.col * board.titleSize;
                board.selectedPiece.yPos = board.selectedPiece.row * board.titleSize;
            }
        }
        
        board.selectedPiece = null;
        board.repaint();
    }
}
