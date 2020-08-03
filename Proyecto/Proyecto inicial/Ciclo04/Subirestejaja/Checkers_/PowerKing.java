package Checkers_;
import Shapes.*;

/**
 * Write a description of class powerPawn here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PowerKing extends Powerfull
{
    protected Triangle power;
    protected Triangle powerC;
    protected Triangle powerCC;
    public PowerKing(boolean isKing, int team)
    {
        super(isKing, team);
        power = new Triangle();
        changeColor(color);
        powerC = new Triangle();
        powerC.changeColor("red");
        powerCC = new Triangle();
        powerCC.changeColor("blue");
    }
    public void changeSize(int size){
        power.changeSize(size,size);
        powerC.changeSize(size - 10,size - 10);
        powerCC.changeSize(size - 20, size - 20);
    }
    public void changeColor(String color){
        power.changeColor(color);
    }
    public void moveHorizontal(int desp){
        power.moveHorizontal(desp);
        changeCenter();
    }
    public void moveVertical(int desp){
        power.moveVertical(desp);
        changeCenter();
    }
    public void makeVisible(){
        power.makeVisible();
        powerC.makeVisible();
        powerCC.makeVisible();
    }
    public void makeInvisible(){
        power.makeInvisible();
        powerC.makeInvisible();
        powerCC.makeInvisible();
    }
    public void setPos(int x, int y){
        moveHorizontal(x);
        moveVertical(y);
    }
    private void changeCenter(){
        powerC.moveVertical(-powerC.getY());
        powerC.moveHorizontal(-powerC.getX());
        powerCC.moveVertical(-powerCC.getY());
        powerCC.moveHorizontal(-powerCC.getX());
        powerC.moveVertical(power.getY() + 5);
        powerC.moveHorizontal(power.getX() + 5);
        powerCC.moveVertical(power.getY() + 10);
        powerCC.moveHorizontal(power.getX() + 10);
    }
    @Override
    public void recoverColor(){
        super.recoverColor();
        powerC.changeColor("red");
        powerCC.changeColor("blue");
    }
}