package Checkers_;
import Shapes.*;

/**
 * La ficha proletarian muere cuando debe convertirse en rey.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
    public void changeSize(int size){
        prole.changeSize(size);
        proleC.changeSize(size - 10);
    }
    public void changeColor(String color){
        prole.changeColor(color);
    }
    public void moveHorizontal(int desp){
        prole.moveHorizontal(desp);
        changeCenter();
    }
    public void moveVertical(int desp){
        prole.moveVertical(desp);
        changeCenter();
    }
    public void makeVisible(){
        prole.makeVisible();
        proleC.makeVisible();
    }
    public void makeInvisible(){
        prole.makeInvisible();
        proleC.makeInvisible();
    }
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