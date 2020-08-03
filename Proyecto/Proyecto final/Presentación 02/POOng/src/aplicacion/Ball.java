package aplicacion;
import java.awt.Color;
import java.io.Serializable;
public class Ball extends Circle implements Serializable {

	int movimientoX,movimientoY,posAntiguaX,posAntiguaY;
	
	
	public Ball(int posX,int posY, int speed){
		super(30,posX,posY);
		changeColor("WHITE");
		makeVisible();
		movimientoX = speed;
		movimientoY = -speed;
		posAntiguaX = 0;
		posAntiguaY = 0;
		
	}
	public void reset() {
		erase();
		setX(300);
		setY(300);
		draw();
	}
	public void setX(int x) {
		erase();
		xPosition = x;
		draw();
	}
	
	public void setY(int y) {
		erase();
		yPosition = y;
		draw();
	}
	
	public void jugar() {
		moveVertical(movimientoY);
		moveHorizontal(movimientoX);
	}
	public void cambioDireccion() {
		movimientoY = movimientoY * -1;
	}
	public void rebote() {
		movimientoX = movimientoX * -1;
	}
}
