package Pruebas;
import aplicacion.*;
import static org.junit.Assert.*;

import presentacion.*;
import org.junit.Test;

import java.awt.Rectangle;

public class Pruebas {
	
	@Test
	public void raquetasSeCreanEnElCentro() {
		POOng j  =new POOng(5,1.0,25);
		assertEquals(200, j.r1.y);
		j.termina();
	}
	
	@Test
	public void raquetaMuevearriba() {
		POOng j  = new POOng(5,1.0,25);
		j.r1.moverR1(new Rectangle());
		//j.raqueta.moverArriba();
		assertEquals(200, j.r1.y);
		j.termina();
	}
	
	@Test
	public void ElegirPersonaje() {
		Iconos j  = new Iconos();
		assertTrue(j.jugador1==null);
		assertTrue(j.jugador2==null);
	}
	@Test
	public void respetaLimitesRaquetaYbolas() {
		POOng j  = new POOng(5,1.0,25);
		for(int i=0; i<21; i++) {
			j.r1.moverR1(new Rectangle());
		}
		assertEquals(200,  j.r1.y);
		j.r1.moverR1(new Rectangle());
		//Se comprueba que no supera su limite
		assertEquals(10,  j.r1.x);
		
		for(int i=0; i<45; i++) {
			j.r1.moverR2(new Rectangle());
		}
		assertEquals(900,  j.r2.x);
		j.r1.moverR2(new Rectangle());
		//Se comprueba que no supera su limite
		assertEquals(200,  j.r2.y);
		j.termina();
	}
	
}
