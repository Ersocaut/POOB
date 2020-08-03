package aplicacion;


import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Ventana extends JFrame {
	
	private Tablero lamina;
	public Hilo hilo;
	public HiloPausa hiloPausa;
	private POOng poong;
	
	
	public Ventana(int ballSize,double ballSpeed, int puntaje,ImageIcon j1, ImageIcon j2,POOng poong) {
		setSize(1000, 500);
		setLocation(75,50);
		setResizable(false);
		this.poong = poong;
		lamina = new Tablero(ballSize, (long) ballSpeed, puntaje, this);
		lamina.personajes.jugador1 = j1;
		lamina.personajes.jugador2 = j2;
		add(lamina);
		addKeyListener(new EventoTeclado());
		setVisible(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			  @Override
			  public void windowClosing(WindowEvent we)
			  { 
			    accionSalir();
			  }
			});
		hilo = new Hilo(lamina);
		hiloPausa = new HiloPausa(lamina);
		comienza();
	}
	public void guardar() {
		hilo.stop();
		poong.guardar();
	}
	synchronized public void comienza() {
		hilo.start();
		try {
			hiloPausa.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Acción que permite salir de la ventana de juego
	 */
	@SuppressWarnings("deprecation")
	private void accionSalir() {
		int confirmed = JOptionPane.showConfirmDialog(null, 
		        "¿Estas seguro que quieres salir?", "Salir de la partida.",
		        JOptionPane.YES_NO_OPTION);

		    if (confirmed == JOptionPane.YES_OPTION) {
		    	lamina.termina();
		    	hilo.stop();
		    	this.dispose();
		    }
	}

}