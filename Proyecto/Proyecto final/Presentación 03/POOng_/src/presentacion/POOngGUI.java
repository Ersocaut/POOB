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


public class POOngGUI extends JFrame{
	//
	private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private final int width = screenSize.width - 100;
	private final int height = screenSize.height - 100;
	//General
	
	private int puntos = 5;
	private double speedBall = 1.0;
	private int sizeBall = 25;
	private ImageIcon jugador1 = null;
	private ImageIcon jugador2 = null;
	
	
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
	
	//Jugar
	private JFrame modos = null;
	
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
	
	//Configurar
	private JFrame configuracion;

	private ImageIcon iconTituloConfiguracion;
	private ImageIcon iconAplicar;
	private ImageIcon iconSpeedBall;
	private ImageIcon iconPuntaje;
	private ImageIcon iconSizeBall;
	
	private JButton aplicar;
	private JButton volverConfig;
	
	private JComboBox<String> ballSpeed;
	private JComboBox<Integer> puntajes;
	private JComboBox<String> ballSize;
	
	//JMenu guardar y cargar
	private JMenuBar barraMenu;
	private JMenu menu;
	private JMenuItem salvar;
	private JMenuItem abrir;
    private POOng poong=null;
    
    //Elegir personaje
    private JFrame personajesGUI;
    
    private ImageIcon iconTituloPersonajes;
    private ImageIcon iconSepara;
    private ImageIcon iconContinuar;
    private ImageIcon iconShowJ1;
    private ImageIcon iconShowJ2;
    
    private Personajes personajes;
    
    private JButton continuar;
    private JButton volverPersonajes;
    
    private JButton batmanButton;
    private JButton batmanLeftButton;
    private JButton spiderButton;
    private JButton spiderLeftButton;
    private JButton flashButton;
    private JButton flashLeftButton;
    
    private JButton fredyButton;
    private JButton fredyLeftButton;
    private JButton slenderButton;
    private JButton slenderLeftButton;
    private JButton ITButton;
    private JButton ITLeftButton;
    
    private JButton hunterButton;
    private JButton hunterLeftButton;
    private JButton warlockButton;
    private JButton warlockLeftButton;
    private JButton titanButton;
    private JButton titanLeftButton;
    
 	public POOngGUI() {
		super("POOng_");
		changeSize(this);
		prepareElementos();
		prepareAcciones();
	}
	/**
	 * Crea los iconos necesarios para la presentación, obteniendo la dirección de este archivo .java
	 * Y modificandolo para conseguir las imagenes
	 */
	private void setIconos() {
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
			iconVolver = new ImageIcon(m + "resources\\iconVolver.png");
			
			//principal
			iconTitulo = new ImageIcon(m + "resources\\iconTitulo.png");
			iconJuega = new ImageIcon(m + "resources\\iconJuega.png");
			iconConfig = new ImageIcon(m + "resources\\iconConfig.png");
			iconSalir = new ImageIcon(m + "resources\\iconSalir.png");
			
			//modos de juego
			iconTituloModos = new ImageIcon(m + "resources\\iconTituloModos.png");
			iconPvP = new ImageIcon(m + "resources\\iconPvP.png");
			iconPvC = new ImageIcon(m + "resources\\iconPvC.png");
			iconCvC = new ImageIcon(m + "resources\\iconCvC.png");
			
			//Configuración
			iconTituloConfiguracion = new ImageIcon(m + "resources\\iconTituloConfig.png");
			iconAplicar = new ImageIcon(m + "resources\\iconAplicar.png");
			iconSpeedBall = new ImageIcon(m + "resources\\iconSpeedBall.png");
			iconPuntaje = new ImageIcon(m + "resources\\iconPuntaje.png");
			iconSizeBall = new ImageIcon(m + "resources\\iconSizeBall.png");
			
			//Personajes
			personajes = new Personajes();
			iconSepara = new ImageIcon(m + "resources\\iconSepara.png");
			iconTituloPersonajes = new ImageIcon(m + "resources\\iconTituloPersonajes.png");
			iconContinuar = new ImageIcon(m + "resources\\iconContinuar.png");
			iconShowJ1 = new ImageIcon(m + "resources\\iconJ1.png");
			iconShowJ2 = new ImageIcon(m + "resources\\iconJ2.png");
		}
		catch (NullPointerException e) {
			System.out.println("Hace falta algun archivo .png");
		}
	}
	/**
	 * Usado para cambiar el tamaño del JFrame actual
	 * @param n El JFrame al cual se le desea cambiar el tamaño
	 */
	private void changeSize(JFrame n) {		
		n.setSize(width,height);
		n.setLocation(75,50);
		n.setLayout(new FlowLayout());
		n.getContentPane().setBackground(Color.white);
		n.setResizable(false);
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
	        	//tablero.actualice();
			} catch (IOException | ClassNotFoundException e) {
				JOptionPane.showMessageDialog(this, "No se puede abrir este archivo");
			}
	    } 
		
	}
	private void setStylePanel(JPanel n) {
		n.setBackground(Color.white);
	}
	/**
	 * Cambia el diseño del botón al general para que sea acorde a los demás
	 * @param n El boton que se desea modificar
	 * @param m La imagen que lleva el correspondiente boton, para modificarlo a medida del mismo
	 */
	private void setStyleButton(JButton n, ImageIcon m) {
		Border empty = BorderFactory.createEmptyBorder();
		n.setBorder(empty);
		n.setBackground(Color.white);
		n.setPreferredSize(new Dimension(m.getIconWidth(),m.getIconHeight()));
	}
	/**
	 * Prepara los elementos de todas las ventanas
	 */
	private void prepareElementos() {
		setIconos();
		prepareElementosPrincipal();
		prepareElementosModos();
		prepareElementosConfiguracion();
		prepareElementosPersonaje();
		prepareElementosSyA();
	}
	/**
	 * Prepara elementos de la selección de personajes
	 */
	private void prepareElementosPersonaje() {
		personajesGUI = new JFrame();
		changeSize(personajesGUI);
		JPanel J1 = new JPanel();
		JLabel show = new JLabel(iconShowJ1);
		J1.add(show);
		setStylePanel(J1);

		JPanel tituloPer = new JPanel();
		JLabel tituloIcon = new JLabel(iconTituloPersonajes);
		setStylePanel(tituloPer);
		tituloPer.add(tituloIcon);
		personajesGUI.add(tituloPer);
		personajesGUI.add(J1);
		prepareSeleccionJ1(personajesGUI);
		JPanel separa = new JPanel();
		JLabel separaI = new JLabel(iconSepara);
		setStylePanel(separa);
		separa.add(separaI);
		personajesGUI.add(separa);
		prepareSeleccionJ2(personajesGUI);
		JPanel J2 = new JPanel();
		JLabel show2 = new JLabel(iconShowJ2);
		J2.add(show2);
		setStylePanel(J2);
		personajesGUI.add(J2);
		JPanel solo = new JPanel();
		personajesGUI.add(solo);
		continuar = new JButton(iconContinuar);
		volverPersonajes = new JButton(iconVolver);
		setStyleButton(volverPersonajes,iconVolver);
		setStyleButton(continuar,iconContinuar);
		solo.add(volverPersonajes);
		solo.add(continuar);
		personajesGUI.add(solo);
	}
	/**
	 * Agrega los personajes a elegir para el Jugador 1
	 * @param personajesGUI JFrame al que se le agrega el grid de personajes
	 */
	private void prepareSeleccionJ1(JFrame personajesGUI) {
		JPanel seleccionJ1 = new JPanel();
		seleccionJ1.setLayout(new GridLayout(3,3));
		batmanButton = new JButton(personajes.batman);
		setStyleButton(batmanButton,personajes.batman);
		spiderButton = new JButton(personajes.spider);
		setStyleButton(spiderButton,personajes.spider);
		flashButton = new JButton(personajes.flash);
		setStyleButton(flashButton,personajes.flash);
		
		fredyButton = new JButton(personajes.fredy);
		setStyleButton(fredyButton,personajes.fredy);
		slenderButton = new JButton(personajes.slender);
		setStyleButton(slenderButton,personajes.slender);
		ITButton = new JButton(personajes.it);
		setStyleButton(ITButton,personajes.it);
		
		hunterButton = new JButton(personajes.hunter);
		setStyleButton(hunterButton,personajes.hunter);
		warlockButton = new JButton(personajes.warlock);
		setStyleButton(warlockButton,personajes.warlock);
		titanButton = new JButton(personajes.titan);
		setStyleButton(titanButton,personajes.titan);
		
		seleccionJ1.add(batmanButton);
		seleccionJ1.add(spiderButton);
		seleccionJ1.add(flashButton);
		
		seleccionJ1.add(fredyButton);
		seleccionJ1.add(slenderButton);
		seleccionJ1.add(ITButton);
		
		seleccionJ1.add(hunterButton);
		seleccionJ1.add(warlockButton);
		seleccionJ1.add(titanButton);
		personajesGUI.add(seleccionJ1);
	}
	/**
	 * Crea y a agrega la selección de personaje para el jugador 2
	 * @param personajesGUI JFrame al que se agrega el Grid de la selección de personajes del Juagdor 2
	 */
	private void prepareSeleccionJ2(JFrame personajesGUI) {
		JPanel seleccionJ2 = new JPanel();
		seleccionJ2.setLayout(new GridLayout(3,3));
		batmanLeftButton = new JButton(personajes.batmanLeft);
		setStyleButton(batmanLeftButton,personajes.batmanLeft);
		spiderLeftButton = new JButton(personajes.spiderLeft);
		setStyleButton(spiderLeftButton,personajes.spiderLeft);
		flashLeftButton = new JButton(personajes.flashLeft);
		setStyleButton(flashLeftButton,personajes.flashLeft);
		
		fredyLeftButton = new JButton(personajes.fredyLeft);
		setStyleButton(fredyLeftButton,personajes.fredyLeft);
		slenderLeftButton = new JButton(personajes.slenderLeft);
		setStyleButton(slenderLeftButton,personajes.slenderLeft);
		ITLeftButton = new JButton(personajes.itLeft);
		setStyleButton(ITLeftButton,personajes.itLeft);
		
		hunterLeftButton = new JButton(personajes.hunterLeft);
		setStyleButton(hunterLeftButton,personajes.hunterLeft);
		warlockLeftButton = new JButton(personajes.warlockLeft);
		setStyleButton(warlockLeftButton,personajes.warlockLeft);
		titanLeftButton = new JButton(personajes.titanLeft);
		setStyleButton(titanLeftButton,personajes.titanLeft);
		
		
		seleccionJ2.add(flashLeftButton);
		seleccionJ2.add(spiderLeftButton);
		seleccionJ2.add(batmanLeftButton);
		
		seleccionJ2.add(ITLeftButton);
		seleccionJ2.add(slenderLeftButton);
		seleccionJ2.add(fredyLeftButton);


		seleccionJ2.add(titanLeftButton);
		seleccionJ2.add(warlockLeftButton);
		seleccionJ2.add(hunterLeftButton);


		personajesGUI.add(seleccionJ2);
	}
	private void prepareElementosSyA() {

    	barraMenu=new JMenuBar();
    	menu=new JMenu("Menu");
    	salvar=new JMenuItem("Salvar");
    	abrir=new JMenuItem("Abrir");
    	menu.add(salvar);
    	menu.add(abrir);
    	barraMenu.add(menu);
    	setJMenuBar(barraMenu);
    	
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
		setStyleButton(jugar,iconJuega);
		setStyleButton(configurar,iconConfig);
		setStyleButton(salir,iconSalir);
		panel.add(jugar);
		panel.add(configurar);
		panel.add(salir);
		add(titulo);
		add(panel);
		setStylePanel(panel);
		setStylePanel(titulo);
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
		setStylePanel(tituloModosJ);
		setStylePanel(panelModos);
		pvp = new JButton(iconPvP);
		pvc = new JButton(iconPvC);
		cvc = new JButton(iconCvC);
		volverModos = new JButton(iconVolver);
		setStyleButton(pvp,iconPvP);
		setStyleButton(pvc,iconPvC);
		setStyleButton(cvc,iconCvC);
		setStyleButton(volverModos,iconVolver);
		panelModos.add(pvp);
		panelModos.add(pvc);
		panelModos.add(cvc);
		panelModos.add(volverModos);
		modos.add(tituloModosJ);
		modos.add(panelModos);
	}
	/**
	 * Prepara todos los elementos de la ventana de configuración
	 */
	private void prepareElementosConfiguracion() {
		configuracion = new JFrame();
		changeSize(configuracion);
		aplicar = new JButton(iconAplicar);
		volverConfig = new JButton(iconVolver);
		JPanel tituloConfigPanel = new JPanel();
		JLabel tituloConfig = new JLabel(iconTituloConfiguracion);
		JPanel opciones = new JPanel();
		String[] speeds = {"Baja", "Media","Alta"};
		String[] size = {"Pequeña","Media","Grande"};
		Integer[] scores = {3,5,7,9};
		ballSpeed = new JComboBox<String>(speeds);
		ballSize = new JComboBox<String>(size);
		puntajes = new JComboBox<Integer>(scores);
		ballSpeed.setBackground(Color.white);
		ballSize.setBackground(Color.white);
		puntajes.setBackground(Color.white);
		setStyleButton(aplicar, iconAplicar);
		setStylePanel(tituloConfigPanel);
		tituloConfigPanel.add(tituloConfig);
		JLabel icon1 = new JLabel(iconSpeedBall);
		JLabel icon2 = new JLabel(iconSizeBall);
		JLabel icon3 = new JLabel(iconPuntaje);
		opciones.add(icon1);
		opciones.add(ballSpeed);
		opciones.add(icon2);
		opciones.add(ballSize);
		opciones.add(icon3);
		opciones.add(puntajes);
		setStylePanel(opciones);
		opciones.setLayout(new GridLayout(3,1));
		setStyleButton(volverConfig, iconVolver);
		configuracion.add(tituloConfigPanel);
		configuracion.add(opciones);
		configuracion.add(aplicar);
		configuracion.add(volverConfig);
	}
	/**
	 * Prepara la ventana en la que se juega la partida de jugador contra jugador
	 */
	private void preparePartidapvp(){
		POOng pvp = new POOng(puntos, speedBall, sizeBall);
		pvp.setJ1(jugador1);
		pvp.setJ2(jugador2);
		pvp.inicia();
		
		
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
	 * Prepara la accion de volver de cualquiera de los menus
	 */
	private void accionVolver(JFrame n) {
		n.setVisible(false);
		n.setLocation(75,50);
	}
	/**
	 * Cambia el valor del puntaje necesario para ganar, inicia predeterminado en 5
	 * @param n Numero del nuevo puntaje final
	 */
	private void setPuntos(Integer n) {
		puntos = n;
	}
	/**
	 * Cambia la velocidad de la pelota al indicado, predeterminado a Media
	 * @param n String que evalua cuál de los tres valores se aplican a speedBall
	 */
	private void setSpeedBall(String n) {
		if (n == "Baja") {
			speedBall = 5;
			}
		else if (n == "Media") {
			speedBall = 2.5;
		}
		else {
			speedBall = 1;
		}
	}
	/**
	 * Cambia el tamaño de la pelota al indicado, predeterminado a pequeña
	 * @param n String que indica el valor asignado al size de la pelota
	 */
	private void setSizeBall(String n) {
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
		prepareAccionesPersonajes();
		//Modos de juego
		pvp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				if (pvpFrame == null) {
					preparePartidapvp();
				}
				else {
					System.out.println("Juego activo");
				}
			}
		});
		volverModos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				accionVolver(modos);
				personajesGUI.setVisible(true);
			}
		});
		prepareAccionesConfiguracion();
		prepareAccionesSyA();
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
	 * Prepara las acciones de los botones de la ventana de Configuración
	 */
	private void prepareAccionesConfiguracion() {
		configuracion.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		configuracion.addWindowListener(new WindowAdapter() {
			  @Override
			  public void windowClosing(WindowEvent we)
			  { 
			    accionVolver(configuracion);
			  }
			});
		aplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				String newBallSpeed = (String) ballSpeed.getSelectedItem();
				setSpeedBall(newBallSpeed);
				String newBallSize = (String) ballSize.getSelectedItem();
				setSizeBall(newBallSize);
				Integer newScore = (Integer) puntajes.getSelectedItem();
				setPuntos(newScore);
				JOptionPane.showMessageDialog(null, "Cambios aplicados correctamente.");
			}
		});
		volverConfig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				accionVolver(configuracion);
			}
		});
	}
		//jugar
		//Abre la ventana de modos de juego
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

	private void prepareAccionesPersonajes() {
		batmanButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				setJugador1(personajes.batman);
				JOptionPane.showMessageDialog(null, "Personaje para el jugador 1 elegido.");
			}
		});;
		
	    batmanLeftButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent ev) {
	    		setJugador2(personajes.batmanLeft);
	    		JOptionPane.showMessageDialog(null, "Personaje para el jugador 2 elegido.");
	    	}
	    });
	    spiderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				setJugador1(personajes.spider);
				JOptionPane.showMessageDialog(null, "Personaje para el jugador 1 elegido.");
			}
		});;
	    spiderLeftButton.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent ev) {
    		setJugador2(personajes.spiderLeft);
    		JOptionPane.showMessageDialog(null, "Personaje para el jugador 2 elegido.");
    	}
    });
	    flashButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				setJugador1(personajes.flash);
				JOptionPane.showMessageDialog(null, "Personaje para el jugador 1 elegido.");
			}
		});;
	    flashLeftButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent ev) {
	    		setJugador2(personajes.flashLeft);
	    		JOptionPane.showMessageDialog(null, "Personaje para el jugador 2 elegido.");
	    	}
	    });
	    
	    fredyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				setJugador1(personajes.fredy);
				JOptionPane.showMessageDialog(null, "Personaje para el jugador 1 elegido.");
			}
		});;
	    fredyLeftButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent ev) {
	    		setJugador2(personajes.fredyLeft);
	    		JOptionPane.showMessageDialog(null, "Personaje para el jugador 2 elegido.");
	    	}
	    });
	    slenderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				setJugador1(personajes.slender);
				JOptionPane.showMessageDialog(null, "Personaje para el jugador 1 elegido.");
			}
		});;
	    slenderLeftButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent ev) {
	    		setJugador2(personajes.slenderLeft);
	    		JOptionPane.showMessageDialog(null, "Personaje para el jugador 2 elegido.");
	    	}
	    });
	    ITButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				setJugador1(personajes.it);
				JOptionPane.showMessageDialog(null, "Personaje para el jugador 1 elegido.");
			}
		});
	    ITLeftButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent ev) {
	    		setJugador2(personajes.itLeft);
	    		JOptionPane.showMessageDialog(null, "Personaje para el jugador 2 elegido.");
	    	}
	    });
	    
	    hunterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				setJugador1(personajes.hunter);
				JOptionPane.showMessageDialog(null, "Personaje para el jugador 1 elegido.");
			}
		});;
	    hunterLeftButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent ev) {
	    		setJugador2(personajes.hunterLeft);
	    		JOptionPane.showMessageDialog(null, "Personaje para el jugador 2 elegido.");
	    	}
	    });
	    warlockButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				setJugador1(personajes.warlock);
				JOptionPane.showMessageDialog(null, "Personaje para el jugador 1 elegido.");
			}
		});;
	    warlockLeftButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent ev) {
	    		setJugador2(personajes.warlockLeft);
	    		JOptionPane.showMessageDialog(null, "Personaje para el jugador 2 elegido.");
	    	}
	    });
	    titanButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				setJugador1(personajes.titan);
				JOptionPane.showMessageDialog(null, "Personaje para el jugador 1 elegido.");
			}
		});;
	    titanLeftButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent ev) {
	    		setJugador2(personajes.titanLeft);
	    		JOptionPane.showMessageDialog(null, "Personaje para el jugador 2 elegido.");
	    	}
	    });
	    volverPersonajes.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent ev) {
	    		accionVolver(personajesGUI);
	    	}
	    });
	    continuar.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent ev) {
	    		if ((jugador1 != null)&(jugador2 != null)) {
	    			personajesGUI.setVisible(false);
	    			modos.setVisible(true);
	    		}
	    		else {
	    			JOptionPane.showMessageDialog(null, "Elige un personaje para cada jugador.");
	    		}
	    	}
	    });
	}
	private void setJugador1(ImageIcon n) {
		jugador1 = n;
	}
	private void setJugador2(ImageIcon n) {
		jugador2 = n;
	}
	public static void main(String[] args) {
		POOngGUI gui = new POOngGUI();
		gui.setVisible(true);
	}
}