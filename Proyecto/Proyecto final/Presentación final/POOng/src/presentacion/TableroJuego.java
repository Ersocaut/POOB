package presentacion;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import aplicacion.*;

public class TableroJuego extends JPanel implements Serializable{

	private POOng comands;
	private static final long serialVersionUID = 1L;
	public long ballSpeed;
	public VentanaJuego frame;
	public Iconos personajes;
	public Random r = new Random();
	
	public TableroJuego(VentanaJuego frame,POOng comands) {
		this.frame = frame;
		this.comands = comands;
		setBackground(Color.white);
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.green);
		dibujar(g2);
	}
	/**
	 * Dibuja cada uno de los elementos frame a frame en el siguiente orden:
	 * Dibuja el campo correspondiente en el ArrayList de canchas
	 * Recorre el ArrayList de bloques y dibuja el correspondiente icono en ese lugar
	 * Dibuja los puntajes de los jugadores
	 * Dibuja la pelota
	 * Dibuja a los personajes
	 * Si existe, dibuja el bloque sorpresa
	 * @param g Graphics2D que grafica el movimiento
	 */
	public void dibujar(Graphics2D g) {
		Rectangle2D r1 = comands.getRaqueta(comands.r1);
		Rectangle2D r2 = comands.getRaqueta(comands.r2);
		if (comands.cont == Iconos.fields.size()) {
			comands.cont = 0;
		}
		Iconos.fields.get(comands.cont).paintIcon(this, g, 0, -10);
		for (int i = 0; i < comands.bloques.size(); i++) {
			Rectangle2D act = comands.bloques.get(i);
			Iconos.bloque.paintIcon(this, g, (int) act.getX(),(int) act.getY());
		}
		Iconos.puntajes.get(comands.puntaje1).paintIcon(this, g, 427, 15);
		Iconos.puntajes.get(comands.puntaje2).paintIcon(this, g, 500, 15);
		if (comands.pelota.rompe) {
			g.setColor(Color.red);
		}
		else {
			g.setColor(Color.green);
		}
		g.fill(comands.pelota.getPelota(comands.ballSize));
		//Player 2
		if ((comands instanceof ContraMaquina)|(comands instanceof EntreMaquinas)) {
			if (comands.r2.isFreeze) {
				Iconos.hielo.paintIcon(this,g, (int) r2.getX(),(int) r2.getY());
			}
			else {
				Iconos.maquinaLeft.paintIcon(this, g, (int) r2.getX(),(int) r2.getY());
			}
		}
		else {
			if (comands.r2.isFreeze) {
				Iconos.hielo.paintIcon(this,g, (int) r2.getX(),(int) r2.getY());
			}
			else {
				Iconos.jugador2.paintIcon(this, g, (int) r2.getX(),(int) r2.getY());
			}
		}
		//Player 1
		if (comands instanceof EntreMaquinas) {
			if (comands.r1.isFreeze) {
				Iconos.hielo.paintIcon(this,g, (int) r1.getX(),(int) r1.getY());
			}
			else {
				Iconos.maquina.paintIcon(this, g, (int) r1.getX(),(int) r1.getY());
			}
		}
		else {
			if (comands.r1.isFreeze) {
				Iconos.hielo.paintIcon(this,g, (int) r1.getX(),(int) r1.getY());
			}
			else {
				Iconos.jugador1.paintIcon(this, g, (int) r1.getX(),(int) r1.getY());
			}
		}
		if (comands.sorpresa != null) {
			Sorpresa s = comands.sorpresa;
			Iconos.sorpresaBox.paintIcon(this, g, s.x, s.y);
		}
		if (comands.objetivo != null) {
			Objetivo o = comands.objetivo;
			Iconos.objetivo.paintIcon(this, g, o.getX(), o.getY());
		}
	}
}