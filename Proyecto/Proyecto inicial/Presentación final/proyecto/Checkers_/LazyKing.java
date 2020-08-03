package Checkers_;
import Shapes.*;

/**
 * Esta clase es una heriencia de la super clase piece y crea el rey que usamos en el tablero
 * en un movimiento, que solo salta una vez
 *
 * @author (Guillermo Castro-Leonardo galeano)
 * @version (Version 10)
 */
public class LazyKing extends Lazy
{
    protected Triangle lazy;
    protected Triangle lazyC;
    /**
     * Constructor for objects of class LazyKing
     */
    public LazyKing(boolean isKing, int team)
    {
        super(isKing, team);
        lazy = new Triangle();
        changeColor(color);
        lazyC = new Triangle();
        lazyC.changeColor("blue");
    }
    /**
     * cambia el tamaño de la ficha.
     * @ param size es un int con el tamaño a cambiar
     */
    public void changeSize(int size){
        lazy.changeSize(size,size);
        lazyC.changeSize(size - 10,size - 10);
    }
    /**
     * cambia el color de la ficha.
     * @ param color es un Strin con el color a cambiar
     */
    public void changeColor(String color){
        lazy.changeColor(color);
    }
    /**
     * mueve horizontalmente la ficha.
     * @ param desp es un int con el valor a mover
     */
    public void moveHorizontal(int desp){
        lazy.moveHorizontal(desp);
        changeCenter();
    }
    /**
     * mueve verticalmente la ficha.
     * @ param desp es un int con el valor a mover
     */
    public void moveVertical(int desp){
        lazy.moveVertical(desp);
        changeCenter();
    }
    /**
     * Hace visible la ficha.
     */
    public void makeVisible(){
        lazy.makeVisible();
        lazyC.makeVisible();
    }
    /**
     * Hace invisible la ficha.
     */
    public void makeInvisible(){
        lazy.makeInvisible();
        lazyC.makeInvisible();
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
        lazyC.moveVertical(-lazyC.getY());
        lazyC.moveHorizontal(-lazyC.getX());
        lazyC.moveVertical(lazy.getY() + 5);
        lazyC.moveHorizontal(lazy.getX());
    }
    @Override
    public void recoverColor(){
        super.recoverColor();
        lazyC.changeColor("blue");
    }
}