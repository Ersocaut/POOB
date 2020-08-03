package excepciones;
import javax.swing.JOptionPane;


import java.lang.Exception;

public class SinapExcepcion extends Exception{
	public static final String NOMBRE_BLANCO = "El nombre del area está en blanco";
	public static final String NAME_BLANCO = "El nombre internacional esta en blanco";
	public static final String UBICACION_BLANCO ="La ubicacion no puede estar en blanco";
	public static final String AREA_INTEGER = "El area debe de ser un numero";
	public static final String DESC_BLANCO = "La descripcion no puede estar en blanco";
	public static final String NOMBRE_NUM = "El nombre no puede ser un numero";

	public SinapExcepcion(String message){
		switch(message){
			case(NOMBRE_BLANCO):
				JOptionPane.showMessageDialog(null,"El nombre del area está en blanco");
				break;
			case(NAME_BLANCO):
				JOptionPane.showMessageDialog(null,"El nombre internacional esta en blanco");
				break;
			case(UBICACION_BLANCO):
				JOptionPane.showMessageDialog(null,"La ubicacion no puede estar en blanco");
				break;
			case(AREA_INTEGER):
				JOptionPane.showMessageDialog(null,"El area debe de ser un numero");
				break;
			case(DESC_BLANCO):
				JOptionPane.showMessageDialog(null,"La descripcion no puede estar en blanco");
				break;
			}
			case(NOMBRE_NUM):
				JOptionPane.showMessageDialog(null,"El nombre no puede ser un numero");
		}
}