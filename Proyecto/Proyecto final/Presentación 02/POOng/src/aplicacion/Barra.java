package aplicacion;
import java.io.*;
import java.awt.event.KeyEvent;
public class Barra implements Serializable{
	protected Rectangle racket;
	protected int weidth;
	protected int height;
	protected int xPos;
	protected int yPos;
	protected Ball ball;
	public Barra(int height,int weidth,int xPos, int yPos) {
		this.height = height;
		this.weidth = weidth;
		this.xPos = xPos;
		this.yPos = yPos;
		ball = null;

		racket = new Rectangle(height,weidth, xPos,yPos);
		if (xPos < 400) {
			xPos = xPos + 40;
		} else {
			xPos = xPos - 100;
		}
	
		racket.setPos(xPos,yPos);
		racket.makeVisible();
	}
		
	public void moveRight(){
			if(racket.getX()+racket.getWidth()<580) {
				racket.moveRight();
				if (ball != null) {
					ball.moveRight();
				}
			}
		}
		
	public void moveLeft() {
			if(racket.getX()>10) {
				racket.moveLeft();
				if (ball != null) {
					ball.moveLeft();
				}
			}
			
		}

	public int getX() {
		return racket.getX();
	}
	public int getY() {
		return racket.getY();
	}
	
	public int getWidth() {
		return weidth;
	}
	
	public int getHeight() {
		return height;
	}

	public void confiBall(Ball ball) {
		this.ball = ball;
	}
	
	public Ball existBall() {
		return ball;
	}
	
	
	public void moverBarra(int i) {
			if(i == KeyEvent.VK_RIGHT){
				moveRight();
			}else if(i == KeyEvent.VK_LEFT){
				moveLeft();
			}
	}
	public void nuevaPosicion(int x) {
		racket.setPos(x,yPos);
		xPos = x;
	}
	
	
}

