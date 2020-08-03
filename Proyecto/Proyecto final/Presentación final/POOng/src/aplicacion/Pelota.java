package aplicacion;

import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.util.Random;
/**
 * Clase encargada de crear la pelota del juego
 */
public class Pelota {
	
	private POOng comands;
	public boolean rompe = false;
	private int x;
	private int y;
	private int dx = 1, dy = 1;
	private double ballSize;
	Random r = new Random();
	
	public Pelota(int x, int y, POOng comands) {
		 this.x = x;
		 this.y = y;
		 this.comands = comands;
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
			  System.out.println("Choca con la raqueta del jugador 1");
		  }
		  else if (colisionR2) {
			  dx = -dx;
			  x = 850;
			  System.out.println("Choca con la raqueta del jugador 2");
		  }
		  
		  if (x > limites.getMaxX() - ballSize) {
			  dx = -dx;
			  x = 500;
			  y = yRandom;
			  comands.puntoR1();
			  System.out.println("Punto para el jugador 1");
		  }
		  else if (x < 0) {
			  dx = -dx;
			  x = 500;
			  y = yRandom;
			  comands.puntoR2();
			  System.out.println("Punto para el jugador 2");
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
	 public boolean choque(Rectangle bloque) {
		 if (this.y > bloque.y & this.y < bloque.getMaxY()) {
			 if (this.x == bloque.getMaxX()) {
				 dx = -dx;
				 System.out.println("Choca con un bloque");
				 return true;
			 }
			 else if (this.x == bloque.x) {
				 dx = -dx;
				 System.out.println("Choca con un bloque");
				 return true;
			 }
		 }
		 if (this.x > bloque.x & this.x < bloque.getMaxX()) {
			 if (this.y == bloque.getMaxY()) {
				 dy = -dy;
				 System.out.println("Choca con un bloque");
				 return true;
			 }
			 else if (this.y == bloque.y) {
				 dy = -dy;
				 System.out.println("Choca con un bloque");
				 return true;
			 }
		 }
		 return false;
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
	 public void cambiaEstado() {
		 rompe = !(rompe);
	 }
}
