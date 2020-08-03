package aplicacion;

public class Hilo extends Thread{
	public Tablero lamina;
	private long speed;
	public Hilo(Tablero lamina) {
		this.lamina = lamina;
		speed = lamina.ballSpeed;
	}
	/**
	 * Permite que el juego se actualize cada cierta cantidad de tiempo, lo que viene siendo la velocidad del mismo
	 */
	@Override
	synchronized public void run() {
		while(!(lamina.evalGanador()) & !(EventoTeclado.p)) {
			try {
				Thread.sleep(speed);
			} catch (InterruptedException e) {
				
			}
			lamina.repaint();
		}
		if(lamina.evalGanador()) {
			lamina.termina();
		}
		else if (EventoTeclado.p) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			lamina.frame.hiloPausa.start();
		}
	}
}