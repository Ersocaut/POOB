package aplicacion;
import java.awt.event.KeyEvent;
import java.io.Serializable;

public class PlayerA extends Player implements Serializable{
	public PlayerA(int height,int weidth,int xpos, int ypos) {
		super(height,weidth,xpos,ypos);
		}
	public void moverBarra(int i) {
		if(i == KeyEvent.VK_RIGHT){
			racket.moveRight();
		}else if(i == KeyEvent.VK_LEFT){
			racket.moveLeft();
		}
	}
}
