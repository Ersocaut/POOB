package Checkers_;
import Shapes.*;

public class LibertarianKing extends Libertarian
{
    protected Triangle libert;
    protected Triangle libertC;
    public LibertarianKing(boolean isKing, int team)
    {
        super(isKing, team);
        libert = new Triangle();
        changeColor(color);
        libertC = new Triangle();
        libertC.changeColor("yellow");
    }
    public void changeSize(int size){
        libert.changeSize(size,size);
        libertC.changeSize(size - 10,size - 10);
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
        libertC.moveHorizontal(libert.getX());
    }
    @Override
    public void recoverColor(){
        super.recoverColor();
        libertC.changeColor("yellow");
    }
}
