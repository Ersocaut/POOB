package presentacion;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class VentanaConfiguracion  extends JFrame implements Serializable{
	
	private POOngGUI father;
	private JButton aplicar;
	private JButton volverConfig;
	
	private JComboBox<String> ballSpeed;
	private JComboBox<Integer> puntajes;
	private JComboBox<String> ballSize;
	
	
	private Iconos iconos = new Iconos();
	
	public VentanaConfiguracion(POOngGUI father) {
		this.father = father;
		prepareElementos();
		prepareAcciones();
	}
	private void prepareElementos() {
		aplicar = new JButton(iconos.iconAplicar);
		volverConfig = new JButton(iconos.iconVolver);
		JPanel tituloConfigPanel = new JPanel();
		JLabel tituloConfig = new JLabel(iconos.iconTituloConfiguracion);
		JPanel opciones = new JPanel();
		String[] speeds = {"Baja", "Media","Alta"};
		String[] size = {"Pequeña","Media","Grande"};
		Integer[] scores = {3,5,7,9};
		ballSpeed = new JComboBox<String>(speeds);
		ballSize = new JComboBox<String>(size);
		puntajes = new JComboBox<Integer>(scores);
		ballSpeed.setBackground(Color.white);
		ballSize.setBackground(Color.white);
		puntajes.setBackground(Color.white);
		father.setStyleButton(aplicar, iconos.iconAplicar);
		father.setStylePanel(tituloConfigPanel);
		tituloConfigPanel.add(tituloConfig);
		JLabel icon1 = new JLabel(iconos.iconSpeedBall);
		JLabel icon2 = new JLabel(iconos.iconSizeBall);
		JLabel icon3 = new JLabel(iconos.iconPuntaje);
		opciones.add(icon1);
		opciones.add(ballSpeed);
		opciones.add(icon2);
		opciones.add(ballSize);
		opciones.add(icon3);
		opciones.add(puntajes);
		father.setStylePanel(opciones);
		opciones.setLayout(new GridLayout(3,1));
		father.setStyleButton(volverConfig, iconos.iconVolver);
		this.add(tituloConfigPanel);
		this.add(opciones);
		this.add(aplicar);
		this.add(volverConfig);
	}
	private void prepareAcciones() {
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			  @Override
			  public void windowClosing(WindowEvent we)
			  { 
			    accionVolver();
			  }
			});
		aplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				String newBallSpeed = (String) ballSpeed.getSelectedItem();
				father.setSpeedBall(newBallSpeed);
				String newBallSize = (String) ballSize.getSelectedItem();
				father.setSizeBall(newBallSize);
				Integer newScore = (Integer) puntajes.getSelectedItem();
				father.setPuntos(newScore);
				JOptionPane.showMessageDialog(null, "Cambios aplicados correctamente.");
			}
		});
		volverConfig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				accionVolver();
			}
		});
	}
	private void accionVolver() {
		this.setVisible(false);
		this.setLocation(75, 50);
	}
	
}
