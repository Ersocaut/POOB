package aplicacion;

import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Personajes {
	public ImageIcon jugador1;
	public ImageIcon jugador2;
	//Superheroes
	public ImageIcon spider;
	public ImageIcon spiderLeft;
	public ImageIcon flash;
	public ImageIcon flashLeft;
	public ImageIcon batman;
	public ImageIcon batmanLeft;
	
	//Terror
	public ImageIcon fredy;
	public ImageIcon fredyLeft;
	public ImageIcon slender;
	public ImageIcon slenderLeft;
	public ImageIcon it;
	public ImageIcon itLeft;
	
	//Destiny (Tema libre)
	public ImageIcon hunter;
	public ImageIcon hunterLeft;
	public ImageIcon warlock;
	public ImageIcon warlockLeft;
	public ImageIcon titan;
	public ImageIcon titanLeft;
	
	//Canchas
	public ArrayList<ImageIcon> fields = new ArrayList<ImageIcon>();
	public ImageIcon field;
	public ImageIcon field1;
	public ImageIcon field2;
	public ImageIcon field3;
	
	//Sorpresas
	public ImageIcon sorpresaBox;
	public ImageIcon bloque;
	
	//Marcador
	public ArrayList<ImageIcon> puntajes;
	
	public Personajes() {
		File n = new File("POOngGUI.java");
		String m = "";
		char lin = '\\';
		String temp = n.getAbsolutePath();
		for (int i = 0; i < n.getAbsolutePath().length() - "POOngGUI.java".length(); i++) {
			if(temp.charAt(i) == lin) {
				m += '\\';
			}
			else {
				m += temp.charAt(i);
			}
		}
		//Superheroes
		spider = new ImageIcon(m + "resources\\iconSpider.png");
		spiderLeft = new ImageIcon(m + "resources\\iconSpiderLeft.png");
		flash = new ImageIcon(m + "resources\\iconFlash.png");
		flashLeft = new ImageIcon(m + "resources\\iconFlashLeft.png");
		batman = new ImageIcon(m + "resources\\iconBatman.png");
		batmanLeft = new ImageIcon(m + "resources\\iconBatmanLeft.png");
		//Terror
		fredy = new ImageIcon(m + "resources\\iconFredy.png");
		fredyLeft = new ImageIcon(m + "resources\\iconFredyLeft.png");
		slender = new ImageIcon(m + "resources\\iconslender.png");
		slenderLeft = new ImageIcon(m + "resources\\iconSlenderLeft.png");
		it = new ImageIcon(m + "resources\\iconIT.png");
		itLeft = new ImageIcon(m + "resources\\iconITLeft.png");
		//Destiny
		hunter = new ImageIcon(m + "resources\\iconHunter.png");
		hunterLeft = new ImageIcon(m + "resources\\iconHunterLeft.png");
		warlock = new ImageIcon(m + "resources\\iconWarlock.png");
		warlockLeft = new ImageIcon(m + "resources\\iconWarlockLeft.png");
		titan = new ImageIcon(m + "resources\\iconTitan.png");
		titanLeft = new ImageIcon(m + "resources\\iconTitanLeft.png");
		//Canchas
		field = new ImageIcon(m + "resources\\iconField.png");
		field1 = new ImageIcon(m + "resources\\iconField1.png");
		field2 = new ImageIcon(m + "resources\\iconField2.png");
		field3 = new ImageIcon(m + "resources\\iconField3.png");
		fields.add(field);
		fields.add(field1);
		fields.add(field2);
		fields.add(field3);
		//Sorpresa
		sorpresaBox = new ImageIcon(m + "resources\\iconSorpresa.png");
		bloque = new ImageIcon(m + "resources\\iconBloque.png");
		
		//Marcador
		puntajes = new ArrayList<ImageIcon>();
		for (int i = 0; i < 10; i++) {
			ImageIcon act = new ImageIcon(m + "resources\\icon" + i + ".png");
			puntajes.add(act);
		}
		}
	
	public void setJugador1(ImageIcon n) {
		jugador1 = n;
	}
	public void setJugador2(ImageIcon n) {
		jugador2 = n;
	}

}
