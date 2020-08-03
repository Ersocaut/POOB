package aplicacion;

public class Hilo extends Thread{
	public Tablero lamina;
	private long speed;
	private boolean isPaused;
	public Hilo(Tablero lamina) {
		this.lamina = lamina;
		speed = lamina.ballSpeed;
		isPaused = false;
	}
	/**
	 * Permite que el juego se actualize cada cierta cantidad de tiempo, lo que viene siendo la velocidad del mismo
	 */
	@Override
	synchronized public void run() {
		while(!(lamina.evalGanador())) {
			if(isPaused) {
				try {
					Thread.sleep(0);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (EventoTeclado.c) {
					isPaused = false;
				}
			}
			else {
				try {
					Thread.sleep(speed);
				} catch (InterruptedException e) {
					
				}
				lamina.repaint();
				if(EventoTeclado.p) {
					isPaused = true;
				}
			}
		}
		lamina.termina();
	}
}