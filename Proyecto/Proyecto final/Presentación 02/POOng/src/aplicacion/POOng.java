package aplicacion;
import presentacion.*;

import java.awt.event.KeyEvent;
import java.io.*;
import java.util.*;
import java.awt.*;
import javax.swing.Timer;
import java.awt.event.*;
import java.lang.*;

import javax.swing.*;

public class POOng implements Serializable {
	//Venatana de juego
	public static JFrame frame;
	private Canvas table;
	private Timer moveBall;
	private int speed;
	
	//Esenciales
	private int puntosGanar;
	private Ball ball;
	private PlayerA tennisPlayerA;
	private PlayerB tennisPlayerB;
	private int puntosA = 0;
	private int puntosB = 0;
	private int barreraA;
	private int barreraB;
	
	private JFrame mode;
	
	
	public POOng(JFrame frame,char J1,char J2,int speed) {
		this.frame = frame;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = screenSize.width - 100;
		int height = screenSize.height - 100;
		table = Canvas.setCanvas(width, height, frame);
		frame.setSize(width,height);
		if (speed == 1) {
			this.speed = 10;
		}
		else if (speed == 2) {
			this.speed = 10;
		}
		else {
			this.speed = 15;
		}
		if (J1 == 'H') {
			tennisPlayerA = new PlayerA(20, 110, 400,600);
		}
		if (J2 == 'H') {
			tennisPlayerB = new PlayerB(20, 110, 400,50);
		}
		ball = new Ball(tennisPlayerA.getX()+tennisPlayerA.getWidth()/2-10,tennisPlayerA.getY()-30,this.speed);
		barreraA = 580;
		barreraB = 70;
		}
	public void iniciar() {
		tennisPlayerA.confiBall(ball);
		moveBall = new Timer(50,new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (frame.isActive()) {
					jugar();
				}
		}
	});
	}
	public void jugar() {
		ball.jugar();
		System.out.println(tennisPlayerA.getX());
		eval();
	}
	private void eval() {
		int xA = tennisPlayerA.racket.getX();
		int xB = tennisPlayerB.racket.getX();
		if (ball.xPosition <= 0) {
			ball.rebote();
		}
		else if (ball.xPosition >= 580) {
			ball.rebote();
		}
		if (ball.yPosition == barreraA){
			if (ball.xPosition >= xA & ball.xPosition <= xA + 110){
				ball.cambioDireccion();
			}
			else {
				puntosB++;
				ball.reset();
				ball.cambioDireccion();
				ball.rebote();
			}
		}
		else if (ball.yPosition == barreraB) {
			if (ball.xPosition >= xB & ball.xPosition <= xB + 110) {
				ball.cambioDireccion();
			}
			else {
				puntosA++;
				ball.reset();
				ball.cambioDireccion();
				ball.rebote();
			}
		}
	}
	public void moverBarras(int i) {
		if (i == KeyEvent.VK_SPACE) {
			if (tennisPlayerA.existBall() != null) {
				tennisPlayerA.confiBall(null);
			}
			moveBall.start();
		}else if (i == KeyEvent.VK_P) {
			moveBall.stop();
			
		}
		tennisPlayerA.moverBarra(i);
		tennisPlayerB.moverBarra(i);
			
	}
}
