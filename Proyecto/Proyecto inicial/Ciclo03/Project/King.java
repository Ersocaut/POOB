
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
}