package Checkers_;
import Shapes.*;

/**
 * Esta clase es una heriencia de la super clase piece y crea el peon que 
 * usamos en el tablero para repetir dos veces el movimiento, si puede.
 *
 * @author (Guillermo Castro-Leonardo galeano)
 * @version (Version 10)
 */
public class HurryPawn extends Hurried
{
    protected Circle hurry;
    protected Circle hurryC;
    /**
     * Constructor for objects of class HurryPawn
     */
    public HurryPawn(boolean isKing, int team)
    {
        super(isKing, team);
        hurry = new Circle();
        changeColor(color);
        hurryC = new Circle();
        hurryC.changeColor("magenta");
    }
    /**
     * cambia el tamaño de la ficha.
     * @ param size es un int con el tamaño a cambiar
     */
    public void changeSize(int size){
        hurry.changeSize(size);
        hurryC.changeSize(size - 10);
    }
    /**
     * cambia el color de la ficha.
     * @ param color es un String con el color a cambiar
     */
    public void changeColor(String color){
        hurry.changeColor(color);
    }
    /**
     * mueve horizontalmente la ficha.
     * @ param desp es un int con el valor a mover
     */
    public void moveHorizontal(int desp){
        hurry.moveHorizontal(desp);
        changeCenter();
    }
    /**
     * mueve verticalmente la ficha.
     * @ param desp es un int con el valor a mover
     */
    public void moveVertical(int desp){
        hurry.moveVertical(desp);
        changeCenter();
    }
    /**
     * Hace visible la ficha.
     */
    public void makeVisible(){
        hurry.makeVisible();
        hurryC.makeVisible();
    }
    /**
     * Hace invisible la ficha.
     */
    public void makeInvisible(){
        hurry.makeInvisible();
        hurryC.makeInvisible();
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
    private void changeCenter(){
        hurryC.moveVertical(-hurryC.getY());
        hurryC.moveHorizontal(-hurryC.getX());
        hurryC.moveVertical(hurry.getY() + 5);
        hurryC.moveHorizontal(hurry.getX() + 5);
    }
    @Override
    public void recoverColor(){
        super.recoverColor();
        hurryC.changeColor("magenta");
    }
}
