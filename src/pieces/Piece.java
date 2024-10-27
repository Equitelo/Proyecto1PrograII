package pieces;

import larasamuelproject1.Board;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Piece {
    public int col, row;
    public int xPos, yPos;
    
    public boolean isWhite;
    public String name;
    public int value;
    
    public boolean isFirstMove = true;
    
    BufferedImage sheet;
    
    protected int sheetScaleWidth, sheetScaleHeight;
    {
        try {
            sheet = ImageIO.read(getClass().getClassLoader().getResourceAsStream("xp.png"));
            if (sheet != null) {
            // Ajusta el tamaño de cada pieza en función de las columnas y filas en la imagen
            int columns = 7; // Número de columnas en tu imagen de sprites
            int rows = 2; // Número de filas en tu imagen de sprites
            
            sheetScaleWidth = sheet.getWidth() / columns;
            sheetScaleHeight = sheet.getHeight() / rows;
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    
    Image sprite;
    
    Board board;
    
    public Piece(Board board){
        this.board=board;
    }
    
    public boolean isValidMovement(int col, int row){return true;}
    
     public boolean moveCollidesWithPiece(int col, int row){return false;}
    
    public void paint(Graphics2D g2d) {
        g2d.drawImage(sprite, xPos, yPos, null);
    }
}
