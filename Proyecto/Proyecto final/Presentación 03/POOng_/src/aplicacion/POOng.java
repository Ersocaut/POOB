package aplicacion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class POOng {
	
	private int puntaje;
	private double ballSpeed;
	private int ballSize;
	private ImageIcon j1;
	private ImageIcon j2;

    private static POOng poong= null;
	
	public POOng(int puntaje, double ballSpeed, int ballSize) {
		this.ballSize = ballSize;
		this.ballSpeed = ballSpeed;
		this.puntaje = puntaje;
	}
	/**
	 * Crea la ventana del juego, lugar en donde se emplea la mayoría de elementos
	 */
	public void inicia() {
		Ventana ventana = new Ventana(ballSize, ballSpeed, puntaje,j1,j2,this);
	}

	public void setJ1 (ImageIcon n) {
		j1 = n;
	}
	public void setJ2(ImageIcon n) {
		j2 = n;
	}
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
    public void guardar() {
		JFileChooser guardar = new JFileChooser();
		guardar.showSaveDialog(null);
		File f = guardar.getSelectedFile();
		try {
			this.salvar(f);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se pudo guardar.");
		}
		
    }
}
