package aplicacion;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Tablero extends JPanel{
	private int ballSize;
	public Pelota pelota;
	private Raqueta r1;
	private Raqueta r2;
	public long ballSpeed;
	private int puntaje,puntaje1 = 0,puntaje2 = 0;
	private int cont = 0;
	public Ventana frame;
	public Personajes personajes = new Personajes();
	private Sorpresa sorpresa;
	public Random r = new Random();
	private ArrayList<Rectangle2D> bloques = new ArrayList<Rectangle2D>();
	
	public Tablero(int ballSize, long ballSpeed, int puntaje, Ventana frame) {
		this.frame = frame;
		pelota = new Pelota(0,0,this);
		this.ballSpeed = ballSpeed;
		this.ballSize = ballSize;
		this.puntaje = puntaje;
		setBackground(Color.white);
		r1 = new Raqueta(10,200);
		r2 = new Raqueta(900,200);
		sorpresa = null;
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.red);
		dibujar(g2);
		actualizar();
	}
	/**
	 * Dibuja en un primer momento la pelota y las raquetas
	 * @param g Graphics2D que grafica el movimiento
	 */
	public void dibujar(Graphics2D g) {
		if (cont == personajes.fields.size()) {
			cont = 0;
		}
		personajes.fields.get(cont).paintIcon(this, g, 0, -10);
		for (int i = 0; i < bloques.size(); i++) {
			Rectangle2D act = bloques.get(i);
			personajes.bloque.paintIcon(this, g, (int)act.getX(),(int) act.getY());
		}
		personajes.puntajes.get(puntaje1).paintIcon(this, g, 427, 0);
		personajes.puntajes.get(puntaje2).paintIcon(this, g, 500, 0);
		g.fill(pelota.getPelota(ballSize));
		personajes.jugador2.paintIcon(this, g, r2.x, r2.y);
		personajes.jugador1.paintIcon(this, g, r1.x, r1.y);
		if (sorpresa != null) {
			personajes.sorpresaBox.paintIcon(this, g, sorpresa.x, sorpresa.y);
		}
	}
	/**
	 * Actualiza el movimiento de las raquetas y la pelota
	 */
	public void actualizar() {
		evalGuardar();
		if (sorpresa == null) {
			this.creaSorpresa();
		}
		for (int i = 0; i < bloques.size(); i++) {
			Rectangle2D act = bloques.get(i);
			pelota.choque(act.getBounds());
		}
		int n = r.nextInt(2);
		pelota.mover(this.getBounds(),colision(r1.getRaqueta()),colision(r2.getRaqueta()));
		r1.moverR1(this.getBounds());
		r2.moverR2(this.getBounds());
		if (sorpresa != null) {
			if (pelota.getPelota(ballSize).intersects(sorpresa.getSorpresa())) {
				sorpresa.generaSorpresa(n);
				sorpresa = null;
			}
		}
		
	}
	private void creaSorpresa() {
		int n = r.nextInt(500);
		int m = r.nextInt(500);
		if ((m==n) & sorpresa == null) {
			sorpresa = new Sorpresa(470,n, this);
			System.out.println("Genera sorpresa");
		}
	}
	/**
	 * Evalua si la pelota golpea en alguna de las raquetas
	 * @param r El rectangulo que forma la raqueta, usamos sus bordes
	 * @return true: la pelota esta golpeando la raqueta
	 * false: la pelota no rebota
	 */
	private boolean colision(Rectangle2D r) {
		return pelota.getPelota(ballSize).intersects(r);
	}
	public void addBloque() {
		int low, max;
		if (pelota.getX() < 500) {
			low = 540;
			max = 780;
		}
		else {
			low = 200;
			max = 440;
		}
		int newX = r.nextInt(max-low) + low;
		int newY = r.nextInt(460);
		bloques.add( new Rectangle2D.Double(newX,newY,40,40));
	}
	/**
	 * Otorga un punto al jugador 1
	 */
	public void puntoR1() {
		puntaje1++;
	}
	/**
	 * Otorga un punto al jugador 2
	 */
	public void puntoR2() {
		puntaje2++;
	}
	/**
	 * Evalua si ya hay un ganador en la partida
	 * @return true: si alguno de losp untajes es igual al puntaje final
	 */
	public boolean evalGanador() {
		return ((puntaje1 == puntaje) | (puntaje2 == puntaje));
	}
	/**
	 * Cuando haya un ganador, anuncia al mismo en un JOptionPane, y cierra la ventana de la partida
	 */
	public void termina() {
		if (puntaje1 == puntaje) {
			JOptionPane.showMessageDialog(null, "El ganador ha sido el jugador 1, con un marcador final de " + puntaje1 + " VS " + puntaje2);
		}
		else if(puntaje2 == puntaje) {
			JOptionPane.showMessageDialog(null, "El ganador ha sido el jugador 2, con un marcador final de " + puntaje2 + " VS " + puntaje1);
		}
		frame.dispose();
	}
	public void evalGuardar() {
		if (EventoTeclado.g) {
			frame.guardar();
		}
	}
		
	
	public void addCont() {
		cont++;
	}

}