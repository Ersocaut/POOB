package aplicacion;

import java.awt.geom.Rectangle2D;
/**
 * Extensión de POOng, encargado del modo de juego 
 * Jugador vs Máquina
 */

public class ContraMaquina extends POOng {
	public ContraMaquina(int puntaje, double ballSpeed, int ballSize) {
		super(puntaje, ballSpeed, ballSize);
	}
	/**
	 * Override del método actualizar de POOng
	 * Este ahora asigna el movimiento de la máquina a seguir automaticamente la pelota
	 * En vez de leer el input de up y down del teclado
	 */
	@Override
	public void actualizar() {
		if (sorpresa == null) {
			super.creaSorpresa();
		}
		int borra = -1;
		for (int i = 0; i < bloques.size(); i++) {
			Rectangle2D act = bloques.get(i);
			if (pelota.choque(act.getBounds()) & (pelota.rompe)) {
				borra = i;
				pelota.cambiaEstado();
				break;
			}
		}
		if (borra != -1) {
			bloques.remove(borra);
		}
		int n = r.nextInt(5);
		pelota.mover(bordes.getBounds(),colision(r1.getRaqueta()),colision(r2.getRaqueta()));
		if (!(r1.isFreeze)) {
			r1.moverR1(bordes.getBounds());
		}
		if (!(r2.isFreeze)) {
			r2.setY(pelota.getY() - 10);
		}
		if (sorpresa != null) {
			if (pelota.getPelota(ballSize).intersects(sorpresa.getSorpresa())) {
				sorpresa.generaSorpresa(n);
				sorpresa = null;
			}
		}
		if (objetivo != null) {
			if (pelota.getPelota(ballSize).intersects(objetivo.getObjetivo())) {
				System.out.println("Golpea un objetivo");
				if (pelota.getDX() > 0) {
					puntoR1();
				}
				else {
					puntoR2();
				}
				objetivo = null;
			}
		}
	}
}
