package aplicacion;

import java.awt.geom.Rectangle2D;
/**
 * Extensión de POOng, encargado del modo de juego
 * Máquina vs Máquina
 */

public class EntreMaquinas extends POOng{
	public EntreMaquinas(int puntaje, double ballSpeed, int ballSize) {
		super(puntaje, ballSpeed, ballSize);
	}
	/**
	 * Override el método actualizar
	 * En este caso aigna el movimiento de ambos jugadores a seguir la pelota en todo momento
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
			r1.setY(pelota.getY() - 10);
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
