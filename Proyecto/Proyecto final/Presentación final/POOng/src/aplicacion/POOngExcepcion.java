package aplicacion;

public class POOngExcepcion extends Exception {
	public static final String JUEGO_VACIO = "no existe ningun juego";
	public static final String FORMATO_INCORRECTO = "El archivo debe ser de tipo DATA(.dat)";
	public POOngExcepcion(String message) {
		super(message);
	}
}
