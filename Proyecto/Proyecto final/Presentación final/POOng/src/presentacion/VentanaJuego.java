package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import aplicacion.EventoTeclado;
import aplicacion.Hilo;
import aplicacion.POOng;
import aplicacion.POOngExcepcion;

public class VentanaJuego extends JFrame implements Serializable{

	private static final long serialVersionUID = 1L;
	private TableroJuego lamina;
	private POOng poong;
	private JMenuBar barraMenu;
	private JMenu menu;
	private JMenuItem salvar;
	private JMenuItem abrir;
	
	
	public VentanaJuego(POOng poong) {
		prepareElementosSyA();
		prepareAccionesSyA();
		setSize(1100, 600);
		setLocation(75,50);
		setResizable(false);
		this.poong = poong;
		lamina = new TableroJuego(this,poong);
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
	}
	private void prepareElementosSyA() {

	barraMenu=new JMenuBar();
	menu=new JMenu("Menu");
	salvar=new JMenuItem("Guardar");
	abrir=new JMenuItem("Abrir");
	menu.add(salvar);
	menu.add(abrir);
	barraMenu.add(menu);
	setJMenuBar(barraMenu);
	add(barraMenu);
	
}
	
	private void prepareAccionesSyA() {
		salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				opcionSalvar();
			}
		});
		abrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					opcionAbrir();
				} catch (POOngExcepcion e1) {
					e1.printStackTrace();
				}
			}
		});
	}
	/**
	 * se encarga de unir el boton de salvar con  su aplicacion , si no es posible lanza una excepcion
	 */
	public void opcionSalvar()  {
		JFileChooser salvar = new JFileChooser();
		salvar.showSaveDialog(null);
		File f = salvar.getSelectedFile();
		try {
			poong.salvar(f);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "No se pudo salvar.");
		}
	}

	/**
	 * se encarga de unir el boton de Abrir con  su aplicacion , si no es posible lanza una excepcion
	 * @throws AutomataExcepcion
	 */
	public void opcionAbrir()  throws POOngExcepcion {
		JFileChooser a = new JFileChooser();
		int returnVal = a.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
	        File file = a.getSelectedFile();
	        try {
	        	poong.abrir(file);
			} catch (IOException | ClassNotFoundException e) {
				JOptionPane.showMessageDialog(this, "No se puede abrir este archivo");
			}
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
		    	poong.termina();
		    	poong.hilo.stop();
		    	this.dispose();
		    	POOngGUI.juegoActual = null;
		    }
	}

}