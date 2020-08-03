package presentacion;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class seleccionPersonajes extends JFrame implements Serializable{
	
	private POOngGUI father;
	
	private JButton continuar;
    private JButton volverPersonajes;
    
    private JButton batmanButton;
    private JButton batmanLeftButton;
    private JButton spiderButton;
    private JButton spiderLeftButton;
    private JButton flashButton;
    private JButton flashLeftButton;
    
    private JButton fredyButton;
    private JButton fredyLeftButton;
    private JButton slenderButton;
    private JButton slenderLeftButton;
    private JButton ITButton;
    private JButton ITLeftButton;
    
    private JButton hunterButton;
    private JButton hunterLeftButton;
    private JButton warlockButton;
    private JButton warlockLeftButton;
    private JButton titanButton;
    private JButton titanLeftButton;
    
    private Iconos iconos = new Iconos();
	
	public seleccionPersonajes(POOngGUI father) {
		this.father = father;
		prepareElementos();
		prepareAcciones();
	}
	private void prepareElementos() {
		JPanel J1 = new JPanel();
		JLabel show = new JLabel(iconos.iconShowJ1);
		J1.add(show);
		father.setStylePanel(J1);
		JPanel tituloPer = new JPanel();
		JLabel tituloIcon = new JLabel(iconos.iconTituloPersonajes);
		father.setStylePanel(tituloPer);
		tituloPer.add(tituloIcon);
		this.add(tituloPer);
		this.add(J1);
		prepareSeleccionJ1();
		JPanel separa = new JPanel();
		JLabel separaI = new JLabel(iconos.iconSepara);
		father.setStylePanel(separa);
		separa.add(separaI);
		this.add(separa);
		prepareSeleccionJ2();
		JPanel J2 = new JPanel();
		JLabel show2 = new JLabel(iconos.iconShowJ2);
		J2.add(show2);
		father.setStylePanel(J2);
		this.add(J2);
		JPanel solo = new JPanel();
		this.add(solo);
		continuar = new JButton(iconos.iconContinuar);
		volverPersonajes = new JButton(iconos.iconVolver);
		father.setStyleButton(volverPersonajes,iconos.iconVolver);
		father.setStyleButton(continuar,iconos.iconContinuar);
		solo.add(volverPersonajes);
		solo.add(continuar);
		this.add(solo);
	}
	private void prepareSeleccionJ1() {
		JPanel seleccionJ1 = new JPanel();
		seleccionJ1.setLayout(new GridLayout(3,3));
		batmanButton = new JButton(iconos.batman);
		father.setStyleButton(batmanButton,iconos.batman);
		spiderButton = new JButton(iconos.spider);
		father.setStyleButton(spiderButton,iconos.spider);
		flashButton = new JButton(iconos.flash);
		father.setStyleButton(flashButton,iconos.flash);
		
		fredyButton = new JButton(iconos.fredy);
		father.setStyleButton(fredyButton,iconos.fredy);
		slenderButton = new JButton(iconos.slender);
		father.setStyleButton(slenderButton,iconos.slender);
		ITButton = new JButton(iconos.it);
		father.setStyleButton(ITButton,iconos.it);
		
		hunterButton = new JButton(iconos.hunter);
		father.setStyleButton(hunterButton,iconos.hunter);
		warlockButton = new JButton(iconos.warlock);
		father.setStyleButton(warlockButton,iconos.warlock);
		titanButton = new JButton(iconos.titan);
		father.setStyleButton(titanButton,iconos.titan);
		
		seleccionJ1.add(batmanButton);
		seleccionJ1.add(spiderButton);
		seleccionJ1.add(flashButton);
		
		seleccionJ1.add(fredyButton);
		seleccionJ1.add(slenderButton);
		seleccionJ1.add(ITButton);
		
		seleccionJ1.add(hunterButton);
		seleccionJ1.add(warlockButton);
		seleccionJ1.add(titanButton);
		this.add(seleccionJ1);
	}
	private void prepareSeleccionJ2() {
		JPanel seleccionJ2 = new JPanel();
		seleccionJ2.setLayout(new GridLayout(3,3));
		batmanLeftButton = new JButton(iconos.batmanLeft);
		father.setStyleButton(batmanLeftButton,iconos.batmanLeft);
		spiderLeftButton = new JButton(iconos.spiderLeft);
		father.setStyleButton(spiderLeftButton,iconos.spiderLeft);
		flashLeftButton = new JButton(iconos.flashLeft);
		father.setStyleButton(flashLeftButton,iconos.flashLeft);
		
		fredyLeftButton = new JButton(iconos.fredyLeft);
		father.setStyleButton(fredyLeftButton,iconos.fredyLeft);
		slenderLeftButton = new JButton(iconos.slenderLeft);
		father.setStyleButton(slenderLeftButton,iconos.slenderLeft);
		ITLeftButton = new JButton(iconos.itLeft);
		father.setStyleButton(ITLeftButton,iconos.itLeft);
		
		hunterLeftButton = new JButton(iconos.hunterLeft);
		father.setStyleButton(hunterLeftButton,iconos.hunterLeft);
		warlockLeftButton = new JButton(iconos.warlockLeft);
		father.setStyleButton(warlockLeftButton,iconos.warlockLeft);
		titanLeftButton = new JButton(iconos.titanLeft);
		father.setStyleButton(titanLeftButton,iconos.titanLeft);
		
		
		seleccionJ2.add(flashLeftButton);
		seleccionJ2.add(spiderLeftButton);
		seleccionJ2.add(batmanLeftButton);
		
		seleccionJ2.add(ITLeftButton);
		seleccionJ2.add(slenderLeftButton);
		seleccionJ2.add(fredyLeftButton);


		seleccionJ2.add(titanLeftButton);
		seleccionJ2.add(warlockLeftButton);
		seleccionJ2.add(hunterLeftButton);


		this.add(seleccionJ2);
	}
	private void prepareAcciones() {
		batmanButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				father.setJugador1(iconos.batman);
				JOptionPane.showMessageDialog(null, "Personaje para el jugador 1 elegido.");
			}
		});;
		
	    batmanLeftButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent ev) {
	    		father.setJugador2(iconos.batmanLeft);
	    		JOptionPane.showMessageDialog(null, "Personaje para el jugador 2 elegido.");
	    	}
	    });
	    spiderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				father.setJugador1(iconos.spider);
				JOptionPane.showMessageDialog(null, "Personaje para el jugador 1 elegido.");
			}
		});;
	    spiderLeftButton.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent ev) {
    		father.setJugador2(iconos.spiderLeft);
    		JOptionPane.showMessageDialog(null, "Personaje para el jugador 2 elegido.");
    	}
    });
	    flashButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				father.setJugador1(iconos.flash);
				JOptionPane.showMessageDialog(null, "Personaje para el jugador 1 elegido.");
			}
		});;
	    flashLeftButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent ev) {
	    		father.setJugador2(iconos.flashLeft);
	    		JOptionPane.showMessageDialog(null, "Personaje para el jugador 2 elegido.");
	    	}
	    });
	    
	    fredyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				father.setJugador1(iconos.fredy);
				JOptionPane.showMessageDialog(null, "Personaje para el jugador 1 elegido.");
			}
		});;
	    fredyLeftButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent ev) {
	    		father.setJugador2(iconos.fredyLeft);
	    		JOptionPane.showMessageDialog(null, "Personaje para el jugador 2 elegido.");
	    	}
	    });
	    slenderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				father.setJugador1(iconos.slender);
				JOptionPane.showMessageDialog(null, "Personaje para el jugador 1 elegido.");
			}
		});;
	    slenderLeftButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent ev) {
	    		father.setJugador2(iconos.slenderLeft);
	    		JOptionPane.showMessageDialog(null, "Personaje para el jugador 2 elegido.");
	    	}
	    });
	    ITButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				father.setJugador1(iconos.it);
				JOptionPane.showMessageDialog(null, "Personaje para el jugador 1 elegido.");
			}
		});
	    ITLeftButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent ev) {
	    		father.setJugador2(iconos.itLeft);
	    		JOptionPane.showMessageDialog(null, "Personaje para el jugador 2 elegido.");
	    	}
	    });
	    
	    hunterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				father.setJugador1(iconos.hunter);
				JOptionPane.showMessageDialog(null, "Personaje para el jugador 1 elegido.");
			}
		});;
	    hunterLeftButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent ev) {
	    		father.setJugador2(iconos.hunterLeft);
	    		JOptionPane.showMessageDialog(null, "Personaje para el jugador 2 elegido.");
	    	}
	    });
	    warlockButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				father.setJugador1(iconos.warlock);
				JOptionPane.showMessageDialog(null, "Personaje para el jugador 1 elegido.");
			}
		});;
	    warlockLeftButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent ev) {
	    		father.setJugador2(iconos.warlockLeft);
	    		JOptionPane.showMessageDialog(null, "Personaje para el jugador 2 elegido.");
	    	}
	    });
	    titanButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				father.setJugador1(iconos.titan);
				JOptionPane.showMessageDialog(null, "Personaje para el jugador 1 elegido.");
			}
		});;
	    titanLeftButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent ev) {
	    		father.setJugador2(iconos.titanLeft);
	    		JOptionPane.showMessageDialog(null, "Personaje para el jugador 2 elegido.");
	    	}
	    });
	    volverPersonajes.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent ev) {
	    		accionVolver();
	    	}
	    });
	    continuar.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent ev) {
	    		if ((Iconos.jugador1 != null)&(Iconos.jugador2 != null)) {
	    			setVisible(false);
	    			father.modos.setVisible(true);
	    		}
	    		else {
	    			JOptionPane.showMessageDialog(null, "Elige un personaje para cada jugador.");
	    		}
	    	}
	    });
	}
	private void accionVolver() {
		this.setVisible(false);
		this.setLocation(75,50);
	}
}
