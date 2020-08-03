package presentacion;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaModos extends JFrame implements Serializable{
	private POOngGUI father;
	
	private JButton pvp;
	private JButton pvc;
	private JButton cvc;
	private JButton volverModos;
	
	private Iconos iconos = new Iconos();
	
	public VentanaModos(POOngGUI father) {
		this.father = father;
		prepareElementos();
		prepareAcciones();
	}
	private void prepareAcciones() {
		pvp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				if (POOngGUI.juegoActual == null) {
					father.preparePartidapvp();
				}
				else {
					System.out.println("Juego activo");
				}
			}
		});
		pvc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				if (POOngGUI.juegoActual == null) {
					father.preparePartidapve();
				}
				else {
					System.out.println("JuegoActivo");
				}
			}
		});
		cvc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				if (POOngGUI.juegoActual == null) {
					father.preparePartidacvc();
				}
				else {
					System.out.println("Juego activo");
				}
			}
		});
		volverModos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				accionVolver();
				father.personajesGUI.setVisible(true);
			}
		});
	}
	private void prepareElementos() {
		JPanel tituloModosJ = new JPanel();
		JLabel tituloModos = new JLabel(iconos.iconTituloModos);
		tituloModosJ.add(tituloModos);
		JPanel panelModos = new JPanel();
		panelModos.setLayout(new GridLayout(0,1));
		father.setStylePanel(tituloModosJ);
		father.setStylePanel(panelModos);
		pvp = new JButton(iconos.iconPvP);
		pvc = new JButton(iconos.iconPvC);
		cvc = new JButton(iconos.iconCvC);
		volverModos = new JButton(iconos.iconVolver);
		father.setStyleButton(pvp,iconos.iconPvP);
		father.setStyleButton(pvc,iconos.iconPvC);
		father.setStyleButton(cvc,iconos.iconCvC);
		father.setStyleButton(volverModos,iconos.iconVolver);
		panelModos.add(pvp);
		panelModos.add(pvc);
		panelModos.add(cvc);
		panelModos.add(volverModos);
		this.add(tituloModosJ);
		this.add(panelModos);
	}
	private void accionVolver() {
		this.setVisible(false);
		this.setLocation(75,50);
	}
}