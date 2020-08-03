package Checkers_;
import Shapes.*;

/**
 * Esta clase es una heriencia de la super clase piece y crea el peon que 
 * usamos en el tablero,este peon no captura las piezas que salta
 *
 * @author (Guillermo Castro-Leonardo galeano)
 * @version (Version 10)
 */
public class LibertarianPawn extends Libertarian
{
    protected Circle libert;
    protected Circle libertC;
    /**
     * Constructor for objects of class LibertarianPawn
     */
    public LibertarianPawn(boolean isKing, int team)
    {
        super(isKing, team);
        libert = new Circle();
        changeColor(color);
        libertC = new Circle();
        libertC.changeColor("yellow");
    }
    /**
     * cambia el tamaño de la ficha.
     * @ param size es un int con el tamaño a cambiar
     */
    public void changeSize(int size){
        libert.changeSize(size);
        libertC.changeSize(size - 10);
    }
    /**
     * cambia el color de la ficha.
     * @ param color es un Strin con el color a cambiar
     */
    public void changeColor(String color){
        libert.changeColor(color);
    }
    /**
     * mueve horizontalmente la ficha.
     * @ param desp es un int con el valor a mover
     */
    public void moveHorizontal(int desp){
        libert.moveHorizontal(desp);
        changeCenter();
    }
    /**
     * mueve verticalmente la ficha.
     * @ param desp es un int con el valor a mover
     */
    public void moveVertical(int desp){
        libert.moveVertical(desp);
        changeCenter();
    }
    /**
     * Hace visible la ficha.
     */
    public void makeVisible(){
        libert.makeVisible();
        libertC.makeVisible();
    }
    /**
     * Hace invisible la ficha.
     */
    public void makeInvisible(){
        libert.makeInvisible();
        libertC.makeInvisible();
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
        libertC.moveVertical(-libertC.getY());
        libertC.moveHorizontal(-libertC.getX());
        libertC.moveVertical(libert.getY() + 5);
        libertC.moveHorizontal(libert.getX() + 5);
    }
    @Override
    public void recoverColor(){
        super.recoverColor();
        libertC.changeColor("yellow");
    }
}
