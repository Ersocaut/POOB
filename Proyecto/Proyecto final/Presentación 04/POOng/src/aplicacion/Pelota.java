package aplicacion;

import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class Pelota {
	
	private int x;
	private int y;
	private int dx = 1, dy = 1;
	private double ballSize;
	private Tablero lamina;
	Random r = new Random();
	
	public Pelota(int x, int y, Tablero lamina) {
		 this.x = x;
		 this.y = y;
		 this.lamina = lamina;
	 }
	/**
	 * Devuelve la pelota con el tamaño indicado en la posición actual
	 * @param ballSize Tamaño de la pelota
	 * @return Pelota en la posición indicada
	 */
	 public Ellipse2D getPelota(double ballSize) {
		 this.ballSize = ballSize;
		 return new Ellipse2D.Double(x,y,ballSize,ballSize);
	 }
	 /**
	  * Permite que la pelota rebote en los bordes superior e inferior, y en las raquetas
	  * En caso de rebotar con laguno de los bordes laterales de la ventana, se otorga un punto al jugador del lado contrario
	  * @param limites Los bordes de la ventana de juego
	  * @param colisionR1 Evalua si ha de rebotar en la raqueta del jugador 1
	  * @param colisionR2 Evalua si ha de rebotar en la raqueta del jugador 2
	  */
	 public void mover(Rectangle limites, boolean colisionR1, boolean colisionR2) {
		 int yRandom = r.nextInt(450);
		  x += dx;
		  y += dy;
		  if (colisionR1) {
			  dx = -dx;
			  x = 150;
		  }
		  else if (colisionR2) {
			  dx = -dx;
			  x = 850;
		  }
		  
		  if (x > limites.getMaxX() - ballSize) {
			  dx = -dx;
			  x = 500;
			  y = yRandom;
			  lamina.puntoR1();
		  }
		  else if (x < 0) {
			  dx = -dx;
			  x = 500;
			  y = yRandom;
			  lamina.puntoR2();
		  }
		  if (y > limites.getMaxY() - ballSize) {
			  dy = -dy;
		  }
		  else if (y < 0) {
			  dy = -dy;
		  }		  
	 }
	 /**
	  * Evalua si la pelota golpea alguno de los bloques,
	  * Depende de si lo golpea arriba, abajo o alguno de los lados, cambia su dirección
	  * @param bloque Rectangle Idiccando los limites de cada bloque generado en Tablero
	  */
	 public void choque(Rectangle bloque) {
		 if (this.y > bloque.y & this.y < bloque.getMaxY()) {
			 if (this.x == bloque.getMaxX()) {
				 dx = -dx;
			 }
			 else if (this.x == bloque.x) {
				 dx = -dx;
			 }
		 }
		 if (this.x > bloque.x & this.x < bloque.getMaxX()) {
			 if (this.y == bloque.getMaxY()) {
				 dy = -dy;
			 }
			 else if (this.y == bloque.y) {
				 dy = -dy;
			 }
		 } 
	 }
	 /**
	  * @return int La posición en X de la pelota
	  */
	 public int getX() {
		 return x;
	 }
	 /**
	  * @return int La posición en Y de la pelota
	  */
	 public int getY() {
		 return y;
	 }
	 /**
	  * @return int la dirección a la que se dirige la pelota
	  */
	 public int getDX() {
		 return dx;
	 }
}
