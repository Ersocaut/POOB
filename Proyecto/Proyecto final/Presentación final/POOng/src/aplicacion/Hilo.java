package aplicacion;

import presentacion.POOngGUI;
/**
 * Hilo encargado de actualizar la posición de la pelota y las raquetas
 * Mantiene el juego corriendo o en pausa y mantiene el control sobre el tiempo que duran los objetivos
 */
public class Hilo extends Thread{
	private int poderBall = 0;
	public boolean r1Freeze = false;
	public boolean r2Freeze = false;
	private int contR1 = 0;
	private int contR2 = 0;
	private long speed;
	private boolean isPaused;
	private POOng comands;
	private int vidaObjetivo = 0;
	public Hilo(POOng comands) {
		speed = (long) comands.ballSpeed;
		isPaused = false;
		this.comands = comands;
	}
	/**
	 * Permite que el juego se actualize cada cierta cantidad de tiempo, lo que viene siendo la velocidad del mismo
	 */
	@Override
	synchronized public void run() {
		while(!(comands.evalGanador())) {
			//Si el juego entra en pausa, solo se ocupa de dormir el Thread y leer si la tecla C es presionada
			if(isPaused) {
				try {
					Thread.sleep(0);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (EventoTeclado.c) {
					isPaused = false;
				}
			}
			/*Si el juego no está en pausa
			 *Evalua si existe o no objetivo y si debe de ser destruido o no
			 *Si hay un juego corriendo desde POOngGUI, muestra el tablero, en caso contrario, "Core solo por consola" 
			 */
			else {
				try {
					Thread.sleep(speed);
				} catch (InterruptedException e) {
				}
				comands.actualizar();
				//Freeze
				if (r1Freeze) {
					contR1++;
				}
				if (r2Freeze) {
					contR2++;
				}
				if(contR1 == 1000) {
					comands.r1.cambiaEstado();
					contR1 = 0;
					r1Freeze = !(r1Freeze);
				}
				if(contR2 == 1000) {
					comands.r2.cambiaEstado();
					contR2 = 0;
					r2Freeze = !(r2Freeze);
				}
				//Objetivo
				if (comands.objetivo != null) {
					vidaObjetivo++;
				}
				if ((vidaObjetivo == 7500) | (comands.objetivo == null)) {
					comands.objetivo = null;
					vidaObjetivo = 0;
				}
				//FastBall
				if (comands.pelota.rompe) {
					poderBall++;
				}
				else {
					poderBall = 0;
				}
				if (poderBall == 10000) {
					comands.pelota.cambiaEstado();
				}
				//Interfaz gráfica
				if (POOngGUI.juegoActual != null) {
					POOngGUI.juegoActual.repaint();
				}
				//Pausa
				if(EventoTeclado.p) {
					isPaused = true;
				}
			}
		}
		comands.termina();
	}
}