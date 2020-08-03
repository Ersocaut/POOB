package aplicacion;

import java.awt.geom.Rectangle2D;
/**
 * Clase encargada de crear el objetivo generado por las sorpresas
 */
public class Objetivo {
	public int x,y;
	public Objetivo(int x, int y) {
		this.x = x;
		this.y = y;
	}
	/**
	 * @return Rectangle Que representa el objetivo actual de la partida
	 */
	public Rectangle2D getObjetivo() {
		return new Rectangle2D.Double(x, y, 40, 40);
	}
	/**
	 * @return int Coordenada x del rectangulo representativo del objetivo
	 */
	public int getX() {
		return x;
	}
	/**
	 * @return int Coordenada y del rectangulo representativo del objetivo
	 */
	public int getY() {
		return y;
	}
}
