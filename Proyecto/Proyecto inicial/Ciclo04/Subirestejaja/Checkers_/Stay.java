
package Checkers_;
import Shapes.*;

/**
 * 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Stay extends Piece
{
    protected Circle sta;
    protected Circle staC;
    protected Circle staCC;
    public Stay(boolean isKing, int team)
    {
        super(isKing,team);
        sta = new Circle();
        changeColor(color);
        staC = new Circle();
        staC.changeColor("yellow");
        staCC = new Circle();
        staCC.changeColor("magenta");
    }
    public void changeSize(int size){
        sta.changeSize(size);
        staC.changeSize(size - 10);
        staCC.changeSize(size - 20);
    }
    public void changeColor(String color){
        sta.changeColor(color);
    }
    public void moveHorizontal(int desp){
        sta.moveHorizontal(desp);
        changeCenter();
    }
    public void moveVertical(int desp){
        sta.moveVertical(desp);
        changeCenter();
    }
    public void makeVisible(){
        sta.makeVisible();
        staC.makeVisible();
        staCC.makeVisible();
    }
    public void makeInvisible(){
        sta.makeInvisible();
        staC.makeInvisible();
        staCC.makeInvisible();
    }
    public void setPos(int x, int y){
        moveHorizontal(x);
        moveVertical(y);
    }
    private void changeCenter(){
        staC.moveVertical(-staC.getY());
        staC.moveHorizontal(-staC.getX());
        staCC.moveVertical(-staCC.getY());
        staCC.moveHorizontal(-staCC.getX());
        staC.moveVertical(sta.getY() + 5);
        staC.moveHorizontal(sta.getX() + 5);
        staCC.moveVertical(sta.getY() + 10);
        staCC.moveHorizontal(sta.getX() + 10);
    }
    @Override
    public void recoverColor(){
        super.recoverColor();
        staC.changeColor("yellow");
        staCC.changeColor("magenta");
    }
}