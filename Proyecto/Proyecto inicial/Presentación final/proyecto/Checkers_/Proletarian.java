package Checkers_;
import Shapes.*;

/**
 * La ficha proletarian muere cuando debe convertirse en rey.
 */
public class Proletarian extends Piece
{
    protected Circle prole;
    protected Circle proleC;
    public Proletarian(boolean isKing, int team)
    {
        super(isKing,team);
        prole = new Circle();
        changeColor(color);
        proleC = new Circle();
        proleC.changeColor("green");
    }
    /**
     * cambia el tamaño de la ficha.
     * @ param size es un int con el tamaño a cambiar
     */
    public void changeSize(int size){
        prole.changeSize(size);
        proleC.changeSize(size - 10);
    }
    /**
     * cambia el color de la ficha.
     * @ param color es un Strin con el color a cambiar
     */
    public void changeColor(String color){
        prole.changeColor(color);
    }
    /**
     * mueve horizontalmente la ficha.
     * @ param desp es un int con el valor a mover
     */
    public void moveHorizontal(int desp){
        prole.moveHorizontal(desp);
        changeCenter();
    }
    /**
     * mueve verticalmente la ficha.
     * @ param desp es un int con el valor a mover
     */
    public void moveVertical(int desp){
        prole.moveVertical(desp);
        changeCenter();
    }/**
     * Hace visible la ficha.
     */
    public void makeVisible(){
        prole.makeVisible();
        proleC.makeVisible();
    }
    /**
     * Hace invisible la ficha.
     */
    public void makeInvisible(){
        prole.makeInvisible();
        proleC.makeInvisible();
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
        proleC.moveVertical(-proleC.getY());
        proleC.moveHorizontal(-proleC.getX());
        proleC.moveVertical(prole.getY() + 5);
        proleC.moveHorizontal(prole.getX() + 5);
    }
    @Override
    public void recoverColor(){
        super.recoverColor();
        proleC.changeColor("green");
    }
}