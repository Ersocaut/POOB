package aplicacion;
import java.util.*;
import javafx.util.*;
import java.awt.Color;


/**
 * Write a description of class Turnadora here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Turnadora extends Celula
{
    // instance variables - replace the example below with your own
    /**
     * Constructor for objects of class Turnadora
     */
    public Turnadora(AutomataCelular automata,int x, int y)
    {
        // initialise instance variables
        super(automata,x,y);
        super.color = Color.blue;
        if ((x+y)%2 == 0){
            estadoActual = VIVA;
        }
        else{
            estadoActual = MUERTA;
        }
    }
    public void decida(){
        if (estadoActual == VIVA){
            estadoSiguiente = MUERTA;
        }
        else{
            estadoSiguiente = VIVA;
        }
    }
}