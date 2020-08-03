package aplicacion;

import java.awt.event.KeyEvent;

public class PlayerB extends Player {
	public PlayerB(int height,int weidth,int xpos, int ypos) {
		super(height,weidth,xpos,ypos);
		}
	public void moverBarra(int i) {
		if(i == KeyEvent.VK_D){
			racket.moveRight();
		}else if(i == KeyEvent.VK_A){
			racket.moveLeft();
		}
	}
}
