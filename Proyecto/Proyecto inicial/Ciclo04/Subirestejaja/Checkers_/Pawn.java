package Checkers_;
import Shapes.*;
/**
 * Esta clase es una heriencia de la super clase piece y crea el peon que usamos en el tablero.
 *
 * @author (Guillermo Castro-Leonardo galeano)
 * @version (Version 10)
 */
public class Pawn extends Piece
{
    // instance variables - replace the example below with your own
    protected Circle pawn;

    /**
     * Constructor for objects of class Pawn
     */
    public Pawn(boolean isKing, int team){
        super(isKing,team);
        pawn = new Circle();
        changeColor(color);
    }
    /**
     * cambia el tamaño de la ficha.
     * @ param size es un int con el tamaño a cambiar
     */
    public void changeSize(int size){
        pawn.changeSize(size);
    }
    /**
     * cambia el color de la ficha.
     * @ param newColor es un String con el color a cambiar
     */
    public void changeColor(String color){
        pawn.changeColor(color);
    }
    public void moveHorizontal(int desp){
        pawn.moveHorizontal(desp);
    }
    public void moveVertical(int desp){
        pawn.moveVertical(desp);
    }
    public void makeVisible(){
        pawn.makeVisible();
    }
    public void makeInvisible(){
        pawn.makeInvisible();
    }
    public void setPos(int x, int y){
        moveHorizontal(x);
        moveVertical(y);
    }
}
