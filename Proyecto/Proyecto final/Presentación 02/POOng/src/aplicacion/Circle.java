package aplicacion;
import java.awt.*;
import java.io.*;
import java.awt.geom.*;

/**
 * A circle that can be manipulated and that draws itself on a canvas.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 1.0.  (15 July 2000) 
 */
public class Circle extends Shape implements Serializable{

    public static double PI=3.1416;
    
    private int diameter;

    /**
     * Create a new circle at default position with default color.
     */
    public Circle(int dia,int x, int y){
        diameter = dia;
        xPosition = x;
        yPosition = y;
    }

    /**
     * Change the size.
     * @param newDiameter the new size (in pixels). Size must be >=0.
     */
    public void changeSize(int newDiameter){
        erase();
        diameter = newDiameter;
        draw();
    }
    /**
     * Draw the circle with current specifications on screen.
     */
    public void draw(){
        if(isVisible) {
            Canvas canvas = Canvas.setCanvas(POOng.frame.getWidth(), POOng.frame.getHeight(),POOng.frame);
            canvas.draw(this,"white", 
                new Ellipse2D.Double(xPosition, yPosition, 
                diameter, diameter));
            canvas.wait(10);
        }
    }
    public void setDiameter(int newDiameter){
        diameter = newDiameter;
    }

}
