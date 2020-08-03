package presentacion;
import aplicacion.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.border.*;
import javax.imageio.ImageIO;
import java.util.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class POOngGUI extends JFrame{
	//General
	private POOng tablero;
	private int puntos = 5;
	private int speed = 1;
	
	//Principal
	private JPanel panel;
	private JPanel titulo;
	
	private JButton jugar;
	private JButton configurar;
	private JButton salir;
	
	private ImageIcon iconTitulo;
	private ImageIcon iconJuega;
	private ImageIcon iconConfig;
	private ImageIcon iconSalir;
	private ImageIcon iconBack;
	
	//Jugar
	private JFrame modos;
	
	private JButton pvp;
	private JButton pvc;
	private JButton cvc;
	private JButton volverModos;
	
	private ImageIcon iconTituloModos;
	private ImageIcon iconPvP;
	private ImageIcon iconPvC;
	private ImageIcon iconCvC;
	private ImageIcon iconVolver;
	
	//PvP
	private JFrame pvpFrame;
	
 	public POOngGUI() {
		super("POOng");
		changeSize(this);
		prepareElementos();
		prepareAcciones();
	}
	/**
	 * Crea los iconos necesarios para la presentación, obteniendo la dirección de este archivo .java
	 * Y modificandolo para conseguir las imagenes
	 */
	private void getIconos() {
		File n = new File("POOngGUI.java");
		String m = "";
		char lin = '\\';
		String temp = n.getAbsolutePath();
		for (int i = 0; i < n.getAbsolutePath().length() - "POOngGUI.java".length(); i++) {
			if(temp.charAt(i) == lin) {
				m += '\\';
			}
			else {
				m += temp.charAt(i);
			}
		}
		try {
			//general
			iconVolver = new ImageIcon(m + "src\\presentacion\\iconVolver.png");
			iconBack = new ImageIcon(m + "src\\presentacion\\iconBack.jpg");
			
			//principal
			iconTitulo = new ImageIcon(m + "src\\presentacion\\iconTitulo.png");
			iconJuega = new ImageIcon(m + "src\\presentacion\\iconJuega.png");
			iconConfig = new ImageIcon(m + "src\\presentacion\\iconConfig.png");
			iconSalir = new ImageIcon(m + "src\\presentacion\\iconSalir.png");
			
			//modos de juego
			iconTituloModos = new ImageIcon(m + "src\\presentacion\\iconTituloModos.png");
			iconPvP = new ImageIcon(m + "src\\presentacion\\iconPvP.png");
			iconPvC = new ImageIcon(m + "src\\presentacion\\iconPvC.png");
			iconCvC = new ImageIcon(m + "src\\presentacion\\iconCvC.png");
		}
		catch (NullPointerException e) {
			System.out.println("Hace falta algun archivo .png");
		}
	}
	/**
	 * @param n El JFrame al cual se le desea cambiar el tamaño
	 * Usado principalmente para cambiar el tamaño del JFrame actual
	 */
	private void changeSize(JFrame n) {		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = screenSize.width - 100;
		int height = screenSize.height - 100;
		n.setSize(width,height);
		n.setLocation(75,50);
		n.setLayout(new FlowLayout());
	}
	/**
	 * Prepara los elementos de todas las ventanas
	 */
	private void prepareElementos() {
		getIconos();
		prepareElementosPrincipal();
		prepareElementosModos();
	}
	/**
	 * Prepara todos los elementos de la ventana principal
	 */
	private void prepareElementosPrincipal() {
		panel = new JPanel();
		titulo = new JPanel();
		JLabel jTitulo = new JLabel(iconTitulo);
		jTitulo.setSize(iconTitulo.getIconWidth(),iconTitulo.getIconHeight());
		titulo.add(jTitulo);
		panel.setLayout(new GridLayout(0,1));
		jugar = new JButton(iconJuega);
		configurar = new JButton(iconConfig);
		salir = new JButton(iconSalir);
		jugar.setPreferredSize(new Dimension(iconJuega.getIconWidth(),iconJuega.getIconHeight()));
		configurar.setPreferredSize(new Dimension(iconConfig.getIconWidth(),iconConfig.getIconHeight()));
		salir.setPreferredSize(new Dimension(iconSalir.getIconWidth(),iconSalir.getIconHeight()));
		panel.add(jugar);
		panel.add(configurar);
		panel.add(salir);
		add(titulo);
		add(panel);
	}
	/**
	 * Prepara todos los elementos de la ventana de modos de juego
	 */
	private void prepareElementosModos() {
		modos = new JFrame("POOng - Modos de juego");
		changeSize(modos);
		JPanel tituloModosJ = new JPanel();
		JLabel tituloModos = new JLabel(iconTituloModos);
		tituloModosJ.add(tituloModos);
		JPanel panelModos = new JPanel();
		panelModos.setLayout(new GridLayout(0,1));
		pvp = new JButton(iconPvP);
		pvc = new JButton(iconPvC);
		cvc = new JButton(iconCvC);
		volverModos = new JButton(iconVolver);
		pvp.setPreferredSize(new Dimension(iconPvP.getIconWidth(),iconPvP.getIconHeight()));
		pvc.setPreferredSize(new Dimension(iconPvC.getIconWidth(),iconPvC.getIconHeight()));
		cvc.setPreferredSize(new Dimension(iconCvC.getIconWidth(),iconCvC.getIconHeight()));
		volverModos.setPreferredSize(new Dimension(iconVolver.getIconWidth(),iconVolver.getIconHeight()));
		panelModos.add(pvp);
		panelModos.add(pvc);
		panelModos.add(cvc);
		panelModos.add(volverModos);
		modos.add(tituloModosJ);
		modos.add(panelModos);
	}
	/**
	 * Prepara la ventana en la que se juega la partida de jugador contra jugador
	 */
	private void prepareElementosModospvp(){
		pvpFrame = new JFrame();
		changeSize(pvpFrame);
		pvpFrame.addKeyListener(
				new KeyAdapter(){
					public void keyPressed(KeyEvent e) {
						tablero.moverBarras(e.getKeyCode());
					}
				});
		tablero = new POOng(pvpFrame,'H','H',speed);
		tablero.iniciar();
	}
	/**
	 * 	Prepara la accion salir del boton Salir de la ventana principal
	 */
	private void accionSalir() {
		int confirmed = JOptionPane.showConfirmDialog(null, 
		        "¿Estas seguro que quieres salir del programa?", "Salir del programa",
		        JOptionPane.YES_NO_OPTION);

		    if (confirmed == JOptionPane.YES_OPTION) {
		      dispose();
		    }
	}
	private void prepareAcciones() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		//Principal
		//Salir
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				accionSalir();
			}
		});
		//jugar
		jugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				if (!(modos.isActive())) {
					modos.setVisible(true);
				}
			}
		});
		//Modos de juego
		pvp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				prepareElementosModospvp();
			}
		});
		volverModos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				modos.setVisible(false);
				modos.setLocation(75,50);
			}
		});
	}
	public static void main(String[] args) {
		POOngGUI gui = new POOngGUI();
		gui.setVisible(true);
	}
}