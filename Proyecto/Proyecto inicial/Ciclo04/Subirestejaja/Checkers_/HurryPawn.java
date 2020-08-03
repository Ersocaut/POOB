package Checkers_;
import Shapes.*;

/**
 * Write a description of class hurryPawn here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HurryPawn extends Hurried
{
    protected Circle hurry;
    protected Circle hurryC;
    public HurryPawn(boolean isKing, int team)
    {
        super(isKing, team);
        hurry = new Circle();
        changeColor(color);
        hurryC = new Circle();
        hurryC.changeColor("magenta");
    }
    public void changeSize(int size){
        hurry.changeSize(size);
        hurryC.changeSize(size - 10);
    }
    public void changeColor(String color){
        hurry.changeColor(color);
    }
    public void moveHorizontal(int desp){
        hurry.moveHorizontal(desp);
        changeCenter();
    }
    public void moveVertical(int desp){
        hurry.moveVertical(desp);
        changeCenter();
    }
    public void makeVisible(){
        hurry.makeVisible();
        hurryC.makeVisible();
    }
    public void makeInvisible(){
        hurry.makeInvisible();
        hurryC.makeInvisible();
    }
    public void setPos(int x, int y){
        moveHorizontal(x);
        moveVertical(y);
    }
    private void changeCenter(){
        hurryC.moveVertical(-hurryC.getY());
        hurryC.moveHorizontal(-hurryC.getX());
        hurryC.moveVertical(hurry.getY() + 5);
        hurryC.moveHorizontal(hurry.getX() + 5);
    }
    @Override
    public void recoverColor(){
        super.recoverColor();
        hurryC.changeColor("magenta");
    }
}
