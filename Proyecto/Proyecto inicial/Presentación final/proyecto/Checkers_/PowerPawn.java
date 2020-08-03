package Checkers_;
import Shapes.*;

/**
 * Esta clase es una heriencia de la super clase piece y crea el peon que 
 * usamos en el tablero,este peon no se deja capturar
 *
 * @author (Guillermo Castro-Leonardo galeano)
 * @version (Version 10)
 */
public class PowerPawn extends Powerfull
{
    protected Circle power;
    protected Circle powerC;
    protected Circle powerCC;
    /**
     * Constructor for objects of class PowerPawn
     */
    public PowerPawn(boolean isKing, int team)
    {
        super(isKing, team);
        power = new Circle();
        changeColor(color);
        powerC = new Circle();
        powerC.changeColor("red");
        powerCC = new Circle();
        powerCC.changeColor("blue");
    }
    /**
     * cambia el tamaño de la ficha.
     * @ param size es un int con el tamaño a cambiar
     */
    public void changeSize(int size){
        power.changeSize(size);
        powerC.changeSize(size - 10);
        powerCC.changeSize(size - 20);
    }
    /**
     * cambia el color de la ficha.
     * @ param color es un Strin con el color a cambiar
     */
    public void changeColor(String color){
        power.changeColor(color);
    }
    /**
     * mueve horizontalmente la ficha.
     * @ param desp es un int con el valor a mover
     */
    public void moveHorizontal(int desp){
        power.moveHorizontal(desp);
        changeCenter();
    }
    /**
     * mueve verticalmente la ficha.
     * @ param desp es un int con el valor a mover
     */
    public void moveVertical(int desp){
        power.moveVertical(desp);
        changeCenter();
    }
    /**
     * Hace visible la ficha.
     */
    public void makeVisible(){
        power.makeVisible();
        powerC.makeVisible();
        powerCC.makeVisible();
    }
    /**
     * Hace invisible la ficha.
     */
    public void makeInvisible(){
        power.makeInvisible();
        powerC.makeInvisible();
        powerCC.makeInvisible();
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
        powerC.moveVertical(-powerC.getY());
        powerC.moveHorizontal(-powerC.getX());
        powerCC.moveVertical(-powerCC.getY());
        powerCC.moveHorizontal(-powerCC.getX());
        powerC.moveVertical(power.getY() + 5);
        powerC.moveHorizontal(power.getX() + 5);
        powerCC.moveVertical(power.getY() + 10);
        powerCC.moveHorizontal(power.getX() + 10);
    }
    @Override
    public void recoverColor(){
        super.recoverColor();
        powerC.changeColor("red");
        powerCC.changeColor("blue");
    }
}
