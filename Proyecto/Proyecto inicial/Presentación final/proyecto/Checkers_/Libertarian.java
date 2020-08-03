package Checkers_;
/**
 * Esta clase abstracta contiene las fichas que no capturan las piezas que saltan
 * @author (Guillermo Castro-Leonardo galeano)
 * @version (Version 10)
 */
public abstract class Libertarian extends Piece
{
    /**
     * Constructor for objects of class Libertarian
     */
    public Libertarian(boolean isKing, int team)
    {
        super(isKing,team);
    }
}
