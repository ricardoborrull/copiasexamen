package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import Inicio.Principal;
import View.VehiculoVista;

public class VehiculoController {

	public VehiculoController() {
	}
	
	public static void subirVehiculo(JButton subir,JTextField nom,JTextField marca,JTextField tipus,JTextField propietari){
		ConsultasController cc = new ConsultasController();
		subir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = nom.getText().toUpperCase();
				String marc = marca.getText().toUpperCase();
				String tipo = tipus.getText().toUpperCase();
				String propietario = propietari.getText().toUpperCase();
				if(!nombre.equals("") && !marc.equals("") && !tipo.equals("") && !propietario.equals("")){
					cc.subirVehiculos(nombre,marc,tipo,propietario);
					marca.setText("");
					nom.setText("");
					tipus.setText("");
					propietari.setText("Hecho! Ve atrás");
				}else{
					propietari.setText("Error falta algún campo! ");
				}
			}
		});
	}
	
	public static void volverAtras(JButton back,JFrame frame){
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
	}
}
