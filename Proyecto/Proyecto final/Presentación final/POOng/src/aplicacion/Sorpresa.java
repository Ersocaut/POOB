package aplicacion;

import java.awt.geom.Rectangle2D;

public class Sorpresa {
	public int x,y;
	private POOng comands;
	public Sorpresa(int x, int y,POOng comands) {
		this.x = x;
		this.y = y;
		this.comands = comands;
	}
	/**
	 * @return Rectangle representativo de la sorpresa
	 */
	public Rectangle2D getSorpresa() {
		return new Rectangle2D.Double(x, y, 40, 40);
	}
	/**
	 * @param s int entre 0 y 2, el cual decide cuál de las tres sorpresas crear
	 * 0: Cambio de cancha
	 * 1: Agrega un bloque al juego
	 * 2: Crea un objetivo
	 * 3: Fastball
	 * 4: Congela a un jugador
	 */
	public void generaSorpresa(int s) {
		System.out.println(s);
		if (s == 0) {
			System.out.println("Cambio de cancha");
			comands.addCont();
		}
		else if (s == 1) {
			System.out.println("Agrega un bloque");
			comands.addBloque();
		}
		else if (s == 2) {
			System.out.println("Genera un objetivo");
			comands.creaObjetivo();
		}
		else if (s == 3){
			System.out.println("FastBall prri");
			if (!(comands.pelota.rompe)) {
				comands.fastBall();
			}
		}
		else {
			System.out.println("Congelado prro");
			comands.congela();
		}
	}
	
}
