package aplicacion;
import java.util.*;
import java.awt.Color;
/**
 * Write a description of class Barrera here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Barrera implements Elemento
{
    private Color color;
    /**
     * Constructor for objects of class Barrera
     */
    public Barrera(AutomataCelular automata,int row,int column)
    {
        automata.setElemento(row,column, this);
        color = Color.green;
    }
    public void setVecinos(int vecinos){}
    public char getEstado(){return ' ';}
    public Color getColor(){
        return color;
    }
}