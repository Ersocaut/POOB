package Checkers_;
import Shapes.*;
/**
 * Esta clase es una heriencia de la super clase piece y crea el rey que usamos en el tablero.
 *
 * @author (Guillermo Castro-Leonardo galeano)
 * @version (Version 10)
 */
public class King extends Piece
{
    // instance variables - replace the example below with your own
    protected Triangle king;

    /**
     * Constructor for objects of class King
     */
    public King(boolean isKing, int team){
        super(isKing, team);
        king = new Triangle();
        changeColor(color);
    }
    /**
     * cambia el tamaño de la ficha.
     * @ param size es un int con el tamaño a cambiar
     */
    public void changeSize(int size){
        king.changeSize(size,size);
    }
    /**
     * cambia el color de la ficha.
     * @ param newColor es un String con el color a cambiar
     */
    public void changeColor(String color){
        king.changeColor(color);
    }
    /**
     * mueve horizontalmente la ficha.
     * @ param desp es un int con el valor a mover
     */
    public void moveHorizontal(int desp){
        king.moveHorizontal(desp);
    }
    /**
     * mueve verticalmente la ficha.
     * @ param desp es un int con el valor a mover
     */
    public void moveVertical(int desp){
        king.moveVertical(desp);
    }
    /**
     * Hace visible la ficha.
     */
    public void makeVisible(){
        king.makeVisible();
    }
    /**
     * Hace invisible la ficha.
     */
    public void makeInvisible(){
        king.makeInvisible();
    }
    /**
     * cambia el valor de la posicionficha.
     * @ param x es un int con la nueva posicion que toma en el eje x
     * @ param y es un int con la nueva posicion que toma en el eje y
     */
    public void setPos(int x, int y){
        moveHorizontal(x);
        moveVertical(y);
    }
}
