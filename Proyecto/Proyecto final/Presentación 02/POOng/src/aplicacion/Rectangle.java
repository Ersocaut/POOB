package aplicacion;
import java.awt.*;
import java.io.*;

/**
 * A rectangle that can be manipulated and that draws itself on a canvas.
 * 
 * @author  Michael Kolling and David J. Barnes (Modified)
 * @version 1.0  (15 July 2000)()
 */



public class Rectangle extends Shape implements Serializable{

    private int height;
    private int width;

    /**
     * Create a new rectangle at default position with default color.
     */
    public Rectangle(int height, int width, int xPosition,int yPosition
    		){
        super();
        this.height = height;
        this.width = width;
        super.setPos(xPosition,yPosition);
        super.changeColor("blue");
        isVisible = false;
    }
    /**
     * Change the size to the new size
     * @param newHeight the new height in pixels. newHeight must be >=0.
     * @param newWidht the new width in pixels. newWidth must be >=0.
     */
    public void changeSize(int newHeight, int newWidth) {
        erase();
        height = newHeight;
        width = newWidth;
        draw();
    }

    /**
     * Draw the rectangle with current specifications on screen.
     */

    public void draw() {
        if(isVisible) {
            Canvas canvas = Canvas.setCanvas(POOng.frame.getWidth(), POOng.frame.getHeight(),POOng.frame);
            canvas.draw(this, color,
                new java.awt.Rectangle(xPosition, yPosition, width, height));
        }
    }
    
    public int getHeight(){
        return height;
    }
    
    public int getWidth(){
        return width;
    }
    
}

