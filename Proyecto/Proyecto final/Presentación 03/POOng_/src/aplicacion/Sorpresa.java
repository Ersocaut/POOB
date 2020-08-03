package aplicacion;

import java.awt.geom.Rectangle2D;
import java.util.Random;

public class Sorpresa {
	public int x,y;
	private Random r;
	private Tablero lamina;
	
	public Sorpresa(int x, int y, Tablero lamina) {
		this.x = x;
		this.y = y;
		this.lamina = lamina;
	}
	
	public Rectangle2D getSorpresa() {
		return new Rectangle2D.Double(x, y, 40, 40);
	}
	
	public void generaSorpresa(int s) {
		if (s == 0) {
			lamina.addCont();
		}
		else if (s == 1) {
			lamina.addBloque();
		}
	}
	
}
