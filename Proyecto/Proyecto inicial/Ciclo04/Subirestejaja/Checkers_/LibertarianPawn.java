package Checkers_;
import Shapes.*;

/**
 * Write a description of class libertPawn here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LibertarianPawn extends Libertarian
{
    protected Circle libert;
    protected Circle libertC;
    public LibertarianPawn(boolean isKing, int team)
    {
        super(isKing, team);
        libert = new Circle();
        changeColor(color);
        libertC = new Circle();
        libertC.changeColor("yellow");
    }
    public void changeSize(int size){
        libert.changeSize(size);
        libertC.changeSize(size - 10);
    }
    public void changeColor(String color){
        libert.changeColor(color);
    }
    public void moveHorizontal(int desp){
        libert.moveHorizontal(desp);
        changeCenter();
    }
    public void moveVertical(int desp){
        libert.moveVertical(desp);
        changeCenter();
    }
    public void makeVisible(){
        libert.makeVisible();
        libertC.makeVisible();
    }
    public void makeInvisible(){
        libert.makeInvisible();
        libertC.makeInvisible();
    }
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
        libertC.changeColor("red");
    }
}
