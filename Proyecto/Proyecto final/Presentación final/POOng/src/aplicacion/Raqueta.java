package aplicacion;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public class Raqueta {
	public int x,y;
	public boolean isFreeze = false;
	public static final int ancho = 67, alto = 111;
	
	public Raqueta(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Crea la raqueta en la posición indicada con el tamaño establecido
	 * @return El Rectangle2D que representa la raqueta
	 */
	public void setY(int y) {
		this.y = y;
	}
	public Rectangle2D getRaqueta() {
		return new Rectangle2D.Double(x,y,ancho,alto);
	}
	/**
	 * Evalua el movimiento de la raqueta 1 con las teclas W y S
	 * @param limits El rectangle de los bordes del tablero de juego
	 */
	public void moverR1(Rectangle limits) {
		if (EventoTeclado.w & y > limits.getMinY()) {
			y--;
			System.out.println("Muevo para arriba JUGADOR 1");
		}
		else if (EventoTeclado.s & y < limits.getMaxY() - alto) {
			y++;
			System.out.println("Muevo para abajo JUGADOR 1");
		}
	}
	/**
	 * Evalua el movimiento de la raqueta 2 con las teclas up y down
	 * @param limits El rectangle de los bordes del tablero de juego
	 */
	public void moverR2(Rectangle limits) {
		if (EventoTeclado.up & y > limits.getMinY()) {
			y--;
			System.out.println("Muevo para arriba JUGADOR 2");
		}
		else if (EventoTeclado.down & y < limits.getMaxY() - alto) {
			y++;
			System.out.println("Muevo para abajo JUGADOR 2");
		}
	}
	public void cambiaEstado() {
		isFreeze = !(isFreeze);
	}
}
