package Checkers_;
import Shapes.*;
/**
 * Esta clase abstracta contiene las fichas que no se deja capturar
 * @author (Guillermo Castro-Leonardo galeano)
 * @version (Version 10)
 */
public abstract class Powerfull extends Piece
{
    /**
     * Constructor for objects of class Powerfull
     */
    public Powerfull(boolean isKing, int team)
    {
        super(isKing, team);
    }
}