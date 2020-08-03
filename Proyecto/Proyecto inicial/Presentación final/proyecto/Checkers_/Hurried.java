package Checkers_;
import Shapes.*;
/**
 * Esta clase abstracta contiene las fichas que repite dos veces el movimiento, si puede.
 *
 * @author (Guillermo Castro-Leonardo galeano)
 * @version (Version 10)
 */
public abstract class Hurried extends Piece
{
    /**
     * Constructor for objects of class Hurried
     */
    public Hurried(boolean isKing, int team)
    {
        super(isKing, team);
    }
}