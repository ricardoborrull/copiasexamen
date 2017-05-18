package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Controller.EntradaController;
public class EntradaVista {

	public JFrame frame;
	private JTextField idVehicle;
	private JTextField litres;
	private JTextField preu;
	private JTextField totalEuros;


	/**
	 * Create the application.
	 */
	public EntradaVista() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		EntradaController ec = new EntradaController();
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		idVehicle = new JTextField();
		idVehicle.setBounds(17, 23, 130, 26);
		frame.getContentPane().add(idVehicle);
		idVehicle.setColumns(10);
		
		litres = new JTextField();
		litres.setBounds(17, 63, 130, 26);
		frame.getContentPane().add(litres);
		litres.setColumns(10);
		
		preu = new JTextField();
		preu.setBounds(17, 101, 130, 26);
		frame.getContentPane().add(preu);
		preu.setColumns(10);
		
		totalEuros = new JTextField();
		totalEuros.setToolTipText("Inserta automaticamente en BD");
		totalEuros.setEnabled(false);
		totalEuros.setEditable(false);
		totalEuros.setBounds(17, 139, 130, 26);
		frame.getContentPane().add(totalEuros);
		totalEuros.setColumns(10);
		
		JButton calcular = new JButton("Calcular");
		calcular.setBounds(216, 243, 117, 29);
		frame.getContentPane().add(calcular);
		
		JButton back = new JButton("Atrás");
		back.setBounds(327, 243, 117, 29);
		frame.getContentPane().add(back);
		ec.volverAtras(back,frame);
		
		JLabel lblIdDelVehiculo = new JLabel("id del vehiculo");
		lblIdDelVehiculo.setBounds(159, 28, 92, 16);
		frame.getContentPane().add(lblIdDelVehiculo);
		
		JLabel lblLitros = new JLabel("litros");
		lblLitros.setBounds(159, 68, 61, 16);
		frame.getContentPane().add(lblLitros);
		
		JLabel lblPrecio = new JLabel("precio");
		lblPrecio.setBounds(159, 106, 61, 16);
		frame.getContentPane().add(lblPrecio);
		JLabel lblTotalEuros = new JLabel("total euros");
		lblTotalEuros.setBounds(159, 144, 110, 16);
		frame.getContentPane().add(lblTotalEuros);
		
		ec.calcular(calcular,idVehicle,litres,preu);

	}
	

}
