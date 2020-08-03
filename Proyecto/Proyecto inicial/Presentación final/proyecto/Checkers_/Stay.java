
package Checkers_;
import Shapes.*;

/**
 * Esta clase es la que debemos crear y la funcionalidad es quedarse quita 
 * @author (Guillermo Castro-Leonardo galeano)
 * @version (Version 10)
 */
public class Stay extends Piece
{
    protected Circle sta;
    protected Circle staC;
    protected Circle staCC;
    /**
     * Constructor for objects of class Stay
     */
    public Stay(boolean isKing, int team)
    {
        super(isKing,team);
        sta = new Circle();
        changeColor(color);
        staC = new Circle();
        staC.changeColor("yellow");
        staCC = new Circle();
        staCC.changeColor("magenta");
    }
    /**
     * cambia el tamaño de la ficha.
     * @ param size es un int con el tamaño a cambiar
     */
    public void changeSize(int size){
        sta.changeSize(size);
        staC.changeSize(size - 10);
        staCC.changeSize(size - 20);
    }
    /**
     * cambia el color de la ficha.
     * @ param color es un Strin con el color a cambiar
     */
    public void changeColor(String color){
        sta.changeColor(color);
    }
    /**
     * mueve horizontalmente la ficha.
     * @ param desp es un int con el valor a mover
     */
    public void moveHorizontal(int desp){
        sta.moveHorizontal(desp);
        changeCenter();
    }
    /**
     * mueve verticalmente la ficha.
     * @ param desp es un int con el valor a mover
     */
    public void moveVertical(int desp){
        sta.moveVertical(desp);
        changeCenter();
    }
     /**
     * Hace visible la ficha.
     */
    public void makeVisible(){
        sta.makeVisible();
        staC.makeVisible();
        staCC.makeVisible();
    }
    /**
     * Hace invisible la ficha.
     */
    public void makeInvisible(){
        sta.makeInvisible();
        staC.makeInvisible();
        staCC.makeInvisible();
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
        staC.moveVertical(-staC.getY());
        staC.moveHorizontal(-staC.getX());
        staCC.moveVertical(-staCC.getY());
        staCC.moveHorizontal(-staCC.getX());
        staC.moveVertical(sta.getY() + 5);
        staC.moveHorizontal(sta.getX() + 5);
        staCC.moveVertical(sta.getY() + 10);
        staCC.moveHorizontal(sta.getX() + 10);
    }
    @Override
    public void recoverColor(){
        super.recoverColor();
        staC.changeColor("yellow");
        staCC.changeColor("magenta");
    }
}