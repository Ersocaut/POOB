package aplicacion;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 * Clase principal de POOng, es quien maneja el juego en su totalidad, sin interfaz gráfica
 */
public class POOng implements Serializable{
	
	public int puntaje;
	public double ballSpeed;
	public int ballSize;
	
	public int puntaje1 = 0,puntaje2 = 0;
	
	public int cont = 0;
	
	public Pelota pelota;
	public Raqueta r1;
	public Raqueta r2;
	public Sorpresa sorpresa;
	public Random r = new Random();
	protected Rectangle bordes;
	public Hilo hilo;
	public ArrayList<Rectangle2D> bloques = new ArrayList<Rectangle2D>();
	public Objetivo objetivo;
	
	private static POOng poong;
	
	public POOng(int puntaje, double ballSpeed, int ballSize) {
		this.ballSize = ballSize;
		this.ballSpeed = ballSpeed;
		this.puntaje = puntaje;
		hilo = new Hilo(this);
		EventoTeclado eventoTeclado = new EventoTeclado();
		bordes = new Rectangle(1000,500);
		pelota = new Pelota(100,100,this);
		r1 = new Raqueta(10,200);
		r2 = new Raqueta(900,200);
		sorpresa = null;
		objetivo = null;
	}
	/**
	 * Método que indica el inicio del juego
	 */
	public void inicia() {
		hilo.start();
	}
	/**
	 * Método encargado de actualizar el movimiento de las rauqetas y la pelota
	 * Es el método repetido constantemente por el Hilo
	 */
	public void actualizar() {
		if (sorpresa == null) {
			this.creaSorpresa();
		}
		int borra = -1;
		for (int i = 0; i < bloques.size(); i++) {
			Rectangle2D act = bloques.get(i);
			if (pelota.choque(act.getBounds()) & (pelota.rompe)) {
				borra = i;
				pelota.cambiaEstado();
				break;
			}
		}
		if (borra != -1) {
			bloques.remove(borra);
		}
		int n = r.nextInt(5);
		pelota.mover(bordes.getBounds(),colision(r1.getRaqueta()),colision(r2.getRaqueta()));
		if (!(r1.isFreeze)) {
			r1.moverR1(bordes.getBounds());
		}
		if (!(r2.isFreeze)) {
			r2.moverR2(bordes.getBounds());
		}
		if (sorpresa != null) {
			if (pelota.getPelota(ballSize).intersects(sorpresa.getSorpresa())) {
				sorpresa.generaSorpresa(n);
				sorpresa = null;
			}
		}
		if (objetivo != null) {
			if (pelota.getPelota(ballSize).intersects(objetivo.getObjetivo())) {
				System.out.println("Golpea un objetivo");
				if (pelota.getDX() > 0) {
					puntoR1();
				}
				else {
					puntoR2();
				}
				objetivo = null;
			}
		}
	}
	/**
	 * Indica si la pelota rebota con algún otro elemento del juego
	 * @param r Rectangle2D que representa el objeto con el que se desea evaluar si choca o no
	 * @return true: si choca con el elemento r, false: d.l.c
	 */
	protected boolean colision(Rectangle2D r) {
		return pelota.getPelota(ballSize).intersects(r);
	}
	
	/**
	 * Método encargado de otorgar un punto al jugador 1
	 */
	public void puntoR1() {
		puntaje1++;
	}
	/**
	 * Método encargado de otorgar un punto al jugador 2
	 */
	public void puntoR2() {
		puntaje2++;
	}
	/**
	 * Método encargado de crear una sorpresa
	 * Para hacerlo independiente del tiempo, se generan dos números aleatorios entre 0 y 499
	 * De ser iguales, y en caso de que no haya otra sorpresa existente, crea una sorpresa
	 */
	protected void creaSorpresa() {
		int n = r.nextInt(500);
		int m = r.nextInt(500);
		if ((m==n) & sorpresa == null) {
			sorpresa = new Sorpresa(470,n, this);
			System.out.println("Genera sorpresa");
		}
		else if (m==n){
			System.out.println("Iguales pero ya existe una sorpresa");
		}
	}
	/**
	 * @param r Raqueta que se desea obtener
	 * @return Raqueta deseada
	 */
	public Rectangle2D getRaqueta(Raqueta r) {
		return r.getRaqueta();
	}
	/**
	 * Método encargado de incrementar el contador que indica qué cancha se debe de mostrar
	 */
	public void addCont() {
		cont++;
	}
	/**
	 * Método encargado de agregar un bloque al ArrayList de los mismos
	 */
	public void addBloque() {
		int low, max;
		if (pelota.getDX() > 0) {
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
	 * Método encargado de crear un Objetivo en la partida
	 */
	public void creaObjetivo() {
		int n = r.nextInt(500);
		objetivo = new Objetivo(470,n);
	}
	/**
	 * @return true: en caso de que alguno de los dos jugadores alcance el puntaje requerido para ganar, flase: d.l.c
	 */
	public boolean evalGanador() {
		return ((puntaje1 == puntaje) | (puntaje2 == puntaje));
	}
	/**
	 * Método encargado de mostrar un mensaje a la hora de terminar la partida, mostrando al ganador y el puntaje final
	 */
	public void termina() {
		if (puntaje1 == puntaje) {
			JOptionPane.showMessageDialog(null, "El ganador ha sido el jugador 1, con un marcador final de " + puntaje1 + " VS " + puntaje2);
		}
		else if(puntaje2 == puntaje) {
			JOptionPane.showMessageDialog(null, "El ganador ha sido el jugador 2, con un marcador final de " + puntaje2 + " VS " + puntaje1);
		}
	}
	/**
	 * 
	 * @param poong1
	 */
    public static void cambiarPOOng(POOng poong1) {
    	poong =poong1;
    }
    /**
     * devuelve el POOng que ya existia y si no, crea una nueva
     * @return POOng
     */
    public static POOng antiguoPOOng(int puntaje, double ballSpeed, int ballSize) {
        if (poong==null){
        	poong=new POOng(puntaje,ballSpeed,ballSize);
        }
       
        return poong;
    }
        /**
         * crea directamente una nueva POOng
         */
    public static void nuevoPOOng(int puntaje, double ballSpeed, int ballSize) {
        	poong=new POOng(puntaje,ballSpeed,ballSize);
    }
	/**
	 * se encarga de guardar el juego y en caso de no hacerlo propaga una excepcion
	 * @param file
	 * @throws POOngExcepcion
	 * @throws IOException
	 */
	public void salvar(File file) throws POOngExcepcion, IOException{
		ObjectOutputStream pw;
		if(this==null) {
			pw = new ObjectOutputStream(new FileOutputStream(file));
			pw.writeObject(this);
			pw.close();
		}else {
			throw new POOngExcepcion(POOngExcepcion.JUEGO_VACIO);
		}
	 }	
	/**
     * se encarga de abrir la aplicacion y en caso de no hacerlo propaga una excepcion
     * @param file
     * @throws POOngExcepcion
     * @throws IOException
     * @throws ClassNotFoundException
     */
	
    public void abrir(File file) throws POOngExcepcion, IOException, ClassNotFoundException{
    	ObjectInputStream in;
    	if(file.getName().endsWith(".dat")) {
			in = new ObjectInputStream(new FileInputStream(file));
			POOng s =  (POOng) in.readObject();
			cambiarPOOng(s);
    	}else {
    		throw new POOngExcepcion(POOngExcepcion.FORMATO_INCORRECTO);
    	}
    }
    /**
     * Cambia el booleano de la pelota que le permite romper bloques
     */
    public void fastBall() {
    	pelota.cambiaEstado();
    }
    /**
     * Congela al jugador contrario, se sabe a quién congelar dependiendo del signo del DX de la pelota
     */
    public void congela() {
    	if (pelota.getDX() > 0) {
    		r2.cambiaEstado();
    		hilo.r2Freeze = true;
    	}
    	else {
    		r1.cambiaEstado();
    		hilo.r1Freeze = true;
    	}
    }
    
}
