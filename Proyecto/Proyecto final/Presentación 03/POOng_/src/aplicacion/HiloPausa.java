package aplicacion;

public class HiloPausa extends Thread {
	public Tablero lamina;
	public HiloPausa(Tablero lamina) {
		this.lamina = lamina;
	}
	
	@Override
	synchronized public void run() {
		while (!(EventoTeclado.c)) {
			lamina.repaint();
		}
		try {
			this.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lamina.frame.hilo.start();
	}
}
