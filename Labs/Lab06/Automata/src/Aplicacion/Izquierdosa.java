package aplicacion;
import java.util.*;
import javafx.util.*;
import java.awt.Color;

/**
 * Write a description of class Iquierdoza here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Izquierdosa extends Celula{
    
    /**
     * Constructor for objects of class Conway
     * @param automata el automata celular al que pertence
     * @param x la posicion en las filas
     * @param y la poscion en la columna
     */
    public Izquierdosa(AutomataCelular automata,int x, int y){
        super(automata,x,y);
        super.color=Color.red;
    }
    /**
     * Cambia el estado siguiente directamente a muerta si encuentra una a la derecha
     */
    public void decida(){
        int x = super.getFila();
        int y = super.getColumma();
        if (y + 1 < automata.getLongitud()){
            Elemento right = automata.getElemento(x,y+1);
            if (right instanceof Celula){
                if (right.getEstado() == 'v'){
                    this.estadoSiguiente = 'm';
                }
            }
        }
        else{
            super.decida();
        }
    }
}
