package presentacion;
import aplicacion.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;


public class POOngGUI extends JFrame implements Serializable{
	//General
	private int puntos = 5;
	private double speedBall = 1.0;
	private int sizeBall = 25;

	private Iconos iconos = new Iconos();
	private POOngGUI poong = null;
	
	//Principal
	private JPanel panel;
	private JPanel titulo;
	
	private JButton jugar;
	private JButton configurar;
	private JButton salir;
	
	
	//Jugar
	public VentanaModos modos;
	
	//
	public static VentanaJuego juegoActual;
	
	//Configurar
	private VentanaConfiguracion configuracion;
	
    
    //Elegir personaje
    public seleccionPersonajes personajesGUI;
    
 	public POOngGUI() {
 		
		super("POOng_");
		changeSize(this);
		prepareElementos();
		prepareAcciones();
	}

	/**
	 * Usado para cambiar el tamaño del JFrame actual
	 * @param n El JFrame al cual se le desea cambiar el tamaño
	 */
	private void changeSize(JFrame n) {		
		n.setSize(1275,700);
		n.setLocation(75,50);
		n.setLayout(new FlowLayout());
		n.getContentPane().setBackground(Color.white);
		n.setResizable(false);
	}
	
	/**
	 * Cambia el estilo del JPanel para que sea acorde al resto
	 * @param n JPanel al cual se le desea cambiar el estilo
	 */
	public void setStylePanel(JPanel n) {
		n.setBackground(Color.white);
	}
	/**
	 * Cambia el diseño del botón al general para que sea acorde a los demás
	 * @param n El boton que se desea modificar
	 * @param m La imagen que lleva el correspondiente boton, para modificarlo a medida del mismo
	 */
	public void setStyleButton(JButton n, ImageIcon m) {
		Border empty = BorderFactory.createEmptyBorder();
		n.setBorder(empty);
		n.setBackground(Color.white);
		n.setPreferredSize(new Dimension(m.getIconWidth(),m.getIconHeight()));
	}
	/**
	 * Prepara los elementos de todas las ventanas
	 */
	private void prepareElementos() {
		prepareElementosPrincipal();
		prepareElementosModos();
		prepareElementosConfiguracion();
		prepareElementosPersonaje();

	}
	/**
	 * Prepara la ventana de elección de personajes
	 */
	private void prepareElementosPersonaje() {
		personajesGUI = new seleccionPersonajes(this);
		changeSize(personajesGUI);
	}
	
	
	/**
	 * Prepara todos los elementos de la ventana principal
	 */
	private void prepareElementosPrincipal() {
		panel = new JPanel();
		titulo = new JPanel();
		JLabel jTitulo = new JLabel(iconos.iconTitulo);
		jTitulo.setSize(iconos.iconTitulo.getIconWidth(),iconos.iconTitulo.getIconHeight());
		titulo.add(jTitulo);
		panel.setLayout(new GridLayout(0,1));
		jugar = new JButton(iconos.iconJuega);
		configurar = new JButton(iconos.iconConfig);
		salir = new JButton(iconos.iconSalir);
		setStyleButton(jugar,iconos.iconJuega);
		setStyleButton(configurar,iconos.iconConfig);
		setStyleButton(salir,iconos.iconSalir);
		panel.add(jugar);
		panel.add(configurar);
		panel.add(salir);
		add(titulo);
		add(panel);
		setStylePanel(panel);
		setStylePanel(titulo);
	}
	/**
	 * Prepara la ventana de modos de juego
	 */
	private void prepareElementosModos() {
		modos = new VentanaModos(this);
		changeSize(modos);

	}
	/**
	 * Prepara la ventna de configuración
	 */
	private void prepareElementosConfiguracion() {
		configuracion = new VentanaConfiguracion(this);
		changeSize(configuracion);

	}
	/**
	 * Prepara la ventana en la que se juega la partida de jugador contra jugador
	 */
	public void preparePartidapvp(){
		POOng pvp = new POOng(puntos, speedBall, sizeBall);
		juegoActual = new VentanaJuego(pvp);
		pvp.inicia();
		
	}
	/**
	 * Prepara la ventana de juego Jugador contra máquina
	 */
	public void preparePartidapve() {
		ContraMaquina pve = new ContraMaquina(puntos,speedBall,sizeBall);
		juegoActual = new VentanaJuego(pve);
		pve.inicia();
	}
	/**
	 * Prepara la ventana de juego para máquina contra máquina
	 */
	public void preparePartidacvc() {
		EntreMaquinas eve = new EntreMaquinas(puntos,speedBall,sizeBall);
		juegoActual = new VentanaJuego(eve);
		eve.inicia();
	}
	/**
	 * 	Prepara la accion salir (Cerrar ventana y detener ejecución)
	 */
	private void accionSalir() {
		int confirmed = JOptionPane.showConfirmDialog(null, 
		        "¿Estas seguro que quieres salir del programa?", "Salir del programa",
		        JOptionPane.YES_NO_OPTION);

		    if (confirmed == JOptionPane.YES_OPTION) {
		      dispose();
		      System.exit(0);
		    }
	}
	/**
	 * Cambia el valor del puntaje necesario para ganar, inicia predeterminado en 5
	 * @param n Numero del nuevo puntaje final
	 */
	public void setPuntos(Integer n) {
		puntos = n;
	}
	/**
	 * Cambia la velocidad de la pelota al indicado, predeterminado a Media
	 * @param n String que evalua cuál de los tres valores se aplican a speedBall
	 */
	public void setSpeedBall(String n) {
		if (n == "Baja") {
			speedBall = 1;
			}
		else if (n == "Media") {
			speedBall = 0.1;
		}
		else {
			speedBall = 0.00001;
		}
	}
	/**
	 * Cambia el tamaño de la pelota al indicado, predeterminado a pequeña
	 * @param n String que indica el valor asignado al size de la pelota
	 */
	public void setSizeBall(String n) {
		if (n == "Pequeña") {
			sizeBall = 25;
		}
		else if (n == "Media") {
			sizeBall = 35;
		}
		else {
			sizeBall = 45;
		}
	}
	/**
	 * Prepara las acciones de toda la presentación
	 */
	private void prepareAcciones() {
		//Configuración para pedir confirmación a la hora de cerrar la ventana principal
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			  @Override
			  public void windowClosing(WindowEvent we)
			  { 
			    accionSalir();
			  }
			});
		prepareAccionesPrincipal();
	}
	

	/**
	 * Prepara las aciiones de la ventana principal
	 */
	private void prepareAccionesPrincipal() {
		//jugar
		//Abre la ventana de modos de juego
		jugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				if (!(modos.isActive())) {
					personajesGUI.setVisible(true);
				}
			}
		});
		//configuracion
		//Abre la ventana de configuracion
		configurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				if (!(configuracion.isActive())){
					configuracion.setVisible(true);
				}
			}
		});
		//Salir
		//Sale del programa en su totalidad
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				accionSalir();
			}
		});
	}
	
	/**
	 * Define la imagen del jugador 1
	 * @param n ImageIcon correspondiente a la selección del jugador
	 */
	public void setJugador1(ImageIcon n) {
		Iconos.jugador1 = n;
	}
	/**
	 * 
	 * Define la imagen del jugador 2
	 * @param n ImageIcon correspondiente a la selección
	 */
	public void setJugador2(ImageIcon n) {
		Iconos.jugador2 = n;
	}
	public static void main(String[] args) {
		POOngGUI gui = new POOngGUI();
		gui.setVisible(true);
	}
}