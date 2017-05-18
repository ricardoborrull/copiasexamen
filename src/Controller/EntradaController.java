package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import Inicio.Principal;
import Controller.ConsultasController;
public class EntradaController {

	public EntradaController() {
		
	}
	
	
	public static void calcular(JButton calcular,JTextField idvehicle,JTextField litres,JTextField preu){
		ConsultasController cc = new ConsultasController();
		calcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = idvehicle.getText();
				String litr = litres.getText();
				String x = preu.getText();
				if(id != null && litr != null && x!=null){
					cc.insertarEntradas(id,litr,x);
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
