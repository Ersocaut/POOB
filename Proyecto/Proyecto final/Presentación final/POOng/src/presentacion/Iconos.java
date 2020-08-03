package presentacion;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.ImageIcon;
/**
 * Clase encargada de mantener y crear TODOS los iconos r¿necesarios para el GUI
 */
public class Iconos implements Serializable{
	//Jugadores
	public static ImageIcon jugador1;
	public static ImageIcon jugador2;
	
	//Maquina
	public static ImageIcon maquina;
	public static ImageIcon maquinaLeft;
	//Hielo
	public static ImageIcon hielo;
	//Principal
	public ImageIcon iconTitulo;
	public ImageIcon iconJuega;
	public ImageIcon iconConfig;
	public ImageIcon iconSalir;
	
	//Modos de Juego
	public ImageIcon iconTituloModos;
	public ImageIcon iconPvP;
	public ImageIcon iconPvC;
	public ImageIcon iconCvC;
	public ImageIcon iconVolver;
	
	//Configurar
	public ImageIcon iconTituloConfiguracion;
	public ImageIcon iconAplicar;
	public ImageIcon iconSpeedBall;
	public ImageIcon iconPuntaje;
	public ImageIcon iconSizeBall;
	
	//Elegir personaje
    public ImageIcon iconTituloPersonajes;
    public ImageIcon iconSepara;
    public ImageIcon iconContinuar;
    public ImageIcon iconShowJ1;
    public ImageIcon iconShowJ2;
    
	
	//Superheroes
	public ImageIcon spider;
	public ImageIcon spiderLeft;
	public ImageIcon flash;
	public ImageIcon flashLeft;
	public ImageIcon batman;
	public ImageIcon batmanLeft;
	
	//Terror
	public ImageIcon fredy;
	public ImageIcon fredyLeft;
	public ImageIcon slender;
	public ImageIcon slenderLeft;
	public ImageIcon it;
	public ImageIcon itLeft;
	
	//Destiny (Tema libre)
	public ImageIcon hunter;
	public ImageIcon hunterLeft;
	public ImageIcon warlock;
	public ImageIcon warlockLeft;
	public ImageIcon titan;
	public ImageIcon titanLeft;
	
	//Canchas
	public static ArrayList<ImageIcon> fields = new ArrayList<ImageIcon>();
	public ImageIcon field;
	public ImageIcon field1;
	public ImageIcon field2;
	public ImageIcon field3;
	
	//Sorpresas
	public static ImageIcon sorpresaBox;
	public static ImageIcon bloque;
	public static ImageIcon objetivo;
	
	//Marcador
	public static ArrayList<ImageIcon> puntajes;
	
	public Iconos() {
		setIconosVentanas();
		setPersonajes();
	}
	/**
	 * Crea los iconos necesarios para la presentación, obteniendo la dirección de este archivo .java
	 * Y modificandolo para conseguir las imagenes
	 */
	private void setIconosVentanas() {
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
			//Hielo
			hielo = new ImageIcon(m + "resources\\iconIce.png");
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
			
			//Selección de personajes
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
	
	private void setPersonajes() {
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
		//Maquina
		maquina = new ImageIcon(m + "resources\\iconMaquina.png");
		maquinaLeft = new ImageIcon(m + "resources\\iconMaquinaLeft.png");
		
		//Superheroes
		spider = new ImageIcon(m + "resources\\iconSpider.png");
		spiderLeft = new ImageIcon(m + "resources\\iconSpiderLeft.png");
		flash = new ImageIcon(m + "resources\\iconFlash.png");
		flashLeft = new ImageIcon(m + "resources\\iconFlashLeft.png");
		batman = new ImageIcon(m + "resources\\iconBatman.png");
		batmanLeft = new ImageIcon(m + "resources\\iconBatmanLeft.png");
		//Terror
		fredy = new ImageIcon(m + "resources\\iconFredy.png");
		fredyLeft = new ImageIcon(m + "resources\\iconFredyLeft.png");
		slender = new ImageIcon(m + "resources\\iconslender.png");
		slenderLeft = new ImageIcon(m + "resources\\iconSlenderLeft.png");
		it = new ImageIcon(m + "resources\\iconIT.png");
		itLeft = new ImageIcon(m + "resources\\iconITLeft.png");
		//Destiny
		hunter = new ImageIcon(m + "resources\\iconHunter.png");
		hunterLeft = new ImageIcon(m + "resources\\iconHunterLeft.png");
		warlock = new ImageIcon(m + "resources\\iconWarlock.png");
		warlockLeft = new ImageIcon(m + "resources\\iconWarlockLeft.png");
		titan = new ImageIcon(m + "resources\\iconTitan.png");
		titanLeft = new ImageIcon(m + "resources\\iconTitanLeft.png");
		//Canchas
		field = new ImageIcon(m + "resources\\iconField.png");
		field1 = new ImageIcon(m + "resources\\iconField1.png");
		field2 = new ImageIcon(m + "resources\\iconField2.png");
		field3 = new ImageIcon(m + "resources\\iconField3.png");
		fields.add(field);
		fields.add(field1);
		fields.add(field2);
		fields.add(field3);
		//Sorpresa
		sorpresaBox = new ImageIcon(m + "resources\\iconSorpresa.png");
		bloque = new ImageIcon(m + "resources\\iconBloque.png");
		objetivo = new ImageIcon(m + "resources\\iconObjetivo.png");
		
		//Marcador
		puntajes = new ArrayList<ImageIcon>();
		for (int i = 0; i < 10; i++) {
			ImageIcon act = new ImageIcon(m + "resources\\icon" + i + ".png");
			puntajes.add(act);
		}
	}
	/**
	 * @param n ImageIcon Elección del jugador para la raqueta 1
	 */
	public void setJugador1(ImageIcon n) {
		jugador1 = n;
	}
	/**
	 * @param n ImageIcon Elección del jugador para la raqueta 2
	 */
	public void setJugador2(ImageIcon n) {
		jugador2 = n;
	}
}
