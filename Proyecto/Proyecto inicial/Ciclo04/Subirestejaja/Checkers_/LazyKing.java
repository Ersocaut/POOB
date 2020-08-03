package Checkers_;
import Shapes.*;

/**
 * Write a description of class LazyPawn here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LazyKing extends Lazy
{
    protected Triangle lazy;
    protected Triangle lazyC;
    public LazyKing(boolean isKing, int team)
    {
        super(isKing, team);
        lazy = new Triangle();
        changeColor(color);
        lazyC = new Triangle();
        lazyC.changeColor("blue");
    }
    public void changeSize(int size){
        lazy.changeSize(size,size);
        lazyC.changeSize(size - 10,size - 10);
    }
    public void changeColor(String color){
        lazy.changeColor(color);
    }
    public void moveHorizontal(int desp){
        lazy.moveHorizontal(desp);
        changeCenter();
    }
    public void moveVertical(int desp){
        lazy.moveVertical(desp);
        changeCenter();
    }
    public void makeVisible(){
        lazy.makeVisible();
        lazyC.makeVisible();
    }
    public void makeInvisible(){
        lazy.makeInvisible();
        lazyC.makeInvisible();
    }
    public void setPos(int x, int y){
        moveHorizontal(x);
        moveVertical(y);
    }
    private void changeCenter(){
        lazyC.moveVertical(-lazyC.getY());
        lazyC.moveHorizontal(-lazyC.getX());
        lazyC.moveVertical(lazy.getY() + 5);
        lazyC.moveHorizontal(lazy.getX());
    }
    @Override
    public void recoverColor(){
        super.recoverColor();
        lazyC.changeColor("blue");
    }
}