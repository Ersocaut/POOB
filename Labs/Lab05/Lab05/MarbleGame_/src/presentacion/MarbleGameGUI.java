package presentacion;
//Aplicacion MarbleGame
import aplicacion.*;
//.awt
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
//.swing Ventanas y eventos
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.border.*;
import javax.imageio.ImageIO;
import java.util.*;
import java.io.File;
import java.io.IOException;


public class MarbleGameGUI extends JFrame{
	private MarbleGame marbleGame;
	//Panel_Botones
	private JPanel panelBotones = new JPanel();
	private JButton realizarMovimiento = new JButton("Mover");
	private JButton cambiarColores = new JButton("Cambiar color");
	private JButton obtenerDetalles = new JButton("Detalles del juego");
	private JButton modificarTablero = new JButton("Modificar tablero");
	private JButton solucionar = new JButton("Solucionar");
	private JButton guardar = new JButton("Guardar");
	private JButton guardarComo = new JButton("Guardar Como");
	private JButton cargar = new JButton("Cargar");
	private JButton botonSalga = new JButton("Salir");
	//Panel Tablero
	private JPanel panelTablero = new JPanel();
	public MarbleGameGUI() {
		super("MarbleGamePOOB");
		marbleGame = new MarbleGame(5,1,1);
		prepareElementos();
		prepareAcciones();
		//inicie();
	}
	private void changeSize() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = screenSize.width/2 - 200;
		int height = screenSize.height/2 + 200;
		setSize(width,height);
		setLocation(screenSize.width/2-this.getSize().width/2, screenSize.height/2-this.getSize().height/2);
		setLayout(new FlowLayout());
		getContentPane().setBackground(new Color(0,0,0));
	}
	private void changeSize(JFrame n) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = screenSize.width/2 + 200;
		int height = screenSize.height/2 + 100;
		n.setSize(width,height);
		n.setLocation(screenSize.width/2-this.getSize().width/2, screenSize.height/2-this.getSize().height/2);
		n.setLayout(new FlowLayout());
	}
	private void prepareElementos(){
		prepareMenu();
	}
	private void prepareMenu() {
		changeSize();
		prepareElementosTablero();
		prepareOpciones();
		add(panelTablero);
		add(panelBotones);
	}
	private void prepareElementosTablero() {
		try {
			BufferedImage myPicture = ImageIO.read(new File("C:\\Users\\leona\\OneDrive\\Imágenes\\Marble.png"));
			JLabel picLabel = new JLabel();
			picLabel.setIcon(new ImageIcon(myPicture));
			panelTablero.add(picLabel);
		}catch (IOException ex) {
			System.out.println("Coloque el path de una imagen prri");
		}
		finally {
			TitledBorder nTitle = BorderFactory.createTitledBorder("Tablero");
			panelTablero.setBorder(nTitle);
		}
	}
	private void prepareOpciones() {
		TitledBorder border = BorderFactory.createTitledBorder("Botones");
		panelBotones.setLayout(new GridLayout(5,1,1,2));
		panelBotones.setBorder(border);
		panelBotones.add(realizarMovimiento);
		panelBotones.add(cambiarColores);
		panelBotones.add(obtenerDetalles);
		panelBotones.add(modificarTablero);
		panelBotones.add(solucionar);
		panelBotones.add(guardar);
		panelBotones.add(guardarComo);
		panelBotones.add(cargar);
		panelBotones.add(botonSalga);
	}
	private void accionSalir() {
		int confirmed = JOptionPane.showConfirmDialog(null, 
		        "¿Estas seguro que quieres salir del programa?", "Salir del programa",
		        JOptionPane.YES_NO_OPTION);

		    if (confirmed == JOptionPane.YES_OPTION) {
		      dispose();
		    }
	}

	private void prepareAcciones() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			  public void windowClosing(WindowEvent e) {
			    accionSalir();
			  }
			});
		/*Salga*/
		botonSalga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				accionSalir();
			}
		});
		/*Cargar*/
		cargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				JFrame cargar = new JFrame("Cargar");
				JFileChooser chooser = new JFileChooser();
				cargar.add(chooser);
				int returnVal = chooser.showOpenDialog(cargar);
			    if(returnVal == JFileChooser.APPROVE_OPTION) {
			       System.out.println("Elegiste el archivo: " +
			            chooser.getSelectedFile().getName());
			}
			}});
		guardarComo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				JFrame guardar = new JFrame("Guardar Como");
				JFileChooser chooser = new JFileChooser();
				guardar.add(chooser);
				chooser.showSaveDialog(guardar);
			}
		});
		cambiarColores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				JFrame cambia = new JFrame("Cambia color");
				JColorChooser color = new JColorChooser();
				cambia.add(color);
				Color colorN = color.showDialog(null, "Seleccione color", Color.black);
				getContentPane().setBackground(colorN);
			}
		});
	
	}
	public static void main(String[] args) {
		MarbleGameGUI gui = new MarbleGameGUI();
		gui.setVisible(true);
	}
}