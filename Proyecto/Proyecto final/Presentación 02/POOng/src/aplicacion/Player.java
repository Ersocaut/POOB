package aplicacion;
import java.io.Serializable;
import java.awt.Color;
public abstract class Player implements Serializable{
	protected Barra racket;
	public Player(int height,int weidth,int xpos, int ypos) {
		racket = new Barra(height,weidth,xpos,ypos);
	}
	public int getX() {
		return racket.getX();
	}
	
	public int getY() {
		return racket.getY();
	}
	
	public int getWidth() {
		return racket.getWidth();
	}
	
	public int getHeight() {
		return racket.getHeight();
	}

	public void confiBall(Ball ball) {
		racket.confiBall(ball);
	}
	
	public Ball existBall() {
		return racket.existBall();
	}
	public void nuevaPosicion(int x) {
		racket.nuevaPosicion(x);
	}
	
	public abstract void moverBarra(int i);
}
