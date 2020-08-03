package aplicacion;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class EventoTeclado extends KeyAdapter {
	static boolean w,s,up,down,g,c,p;
	@Override
	public void keyPressed(KeyEvent e) {
		int id = e.getKeyCode();
		if (id == KeyEvent.VK_W) {
			w = true;
		}
		else if (id == KeyEvent.VK_S) {
			s = true;
		}
		if (id == KeyEvent.VK_UP) {
			up = true;
		}
		else if (id == KeyEvent.VK_DOWN) {
			down = true;
		}
		if (id == KeyEvent.VK_P) {
			p = true;
		}
		if (id == KeyEvent.VK_C) {
			c = true;
		}
		if (id == KeyEvent.VK_G) {
			g = true;
		}
	}
	 @Override
	 public void keyReleased(KeyEvent e) {
		 int id = e.getKeyCode();
			if (id == KeyEvent.VK_W) {
				w = false;
			}
			else if (id == KeyEvent.VK_S) {
				s = false;
			}
			if (id == KeyEvent.VK_UP) {
				up = false;
			}
			else if (id == KeyEvent.VK_DOWN) {
				down = false;
			}
			if (id == KeyEvent.VK_P) {
				p = false;
			}
			if (id == KeyEvent.VK_C) {
				c = false;
			}
			if (id == KeyEvent.VK_G) {
				g = false;
			}
	 }
}
