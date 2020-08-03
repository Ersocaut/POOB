package Checkers_;
import Shapes.*;

/**
 * Esta clase abstracta contiene las fichas que en un movimiento, solo salta una vez
 *
 * @author (Guillermo Castro-Leonardo galeano)
 * @version (Version 10)
 */
public abstract class Lazy extends Piece
{
    /**
     * Constructor for objects of class Lazy
     */
    public Lazy(boolean king, int team)
    {
        super(king,team);
    }
}