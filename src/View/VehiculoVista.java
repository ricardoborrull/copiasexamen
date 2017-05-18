package View;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controller.VehiculoController;

public class VehiculoVista {

	public JFrame frame;
	private JTextField nombre;
	private JTextField marca;
	private JTextField tipo;
	private JTextField propietario;


	/**
	 * Create the application.
	 */
	public VehiculoVista() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		VehiculoController vc = new VehiculoController();
		frame = new JFrame();
		frame.setTitle("INSERTAR VEHICULO");
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		nombre = new JTextField();
		nombre.setBounds(50, 23, 130, 26);
		frame.getContentPane().add(nombre);
		nombre.setColumns(10);
		
		marca = new JTextField();
		marca.setBounds(50, 66, 130, 26);
		frame.getContentPane().add(marca);
		marca.setColumns(10);
		
		tipo = new JTextField();
		tipo.setBounds(50, 104, 130, 26);
		frame.getContentPane().add(tipo);
		tipo.setColumns(10);
		
		propietario = new JTextField();
		propietario.setBounds(50, 142, 130, 26);
		frame.getContentPane().add(propietario);
		propietario.setColumns(10);
		
		JLabel lblIdDelVehiculo = new JLabel("Nombre del vehiculo");
		lblIdDelVehiculo.setBounds(192, 28, 179, 16);
		frame.getContentPane().add(lblIdDelVehiculo);
		
		JLabel lblLitros = new JLabel("marca");
		lblLitros.setBounds(192, 71, 61, 16);
		frame.getContentPane().add(lblLitros);
		
		JLabel lblPrecio = new JLabel("tipo");
		lblPrecio.setBounds(192, 109, 61, 16);
		frame.getContentPane().add(lblPrecio);
		
		JLabel lblTotalEuros = new JLabel("propietario");
		lblTotalEuros.setBounds(189, 147, 110, 16);
		frame.getContentPane().add(lblTotalEuros);
		
		JButton calcular = new JButton("Subir vehiculo");
		calcular.setBounds(216, 243, 117, 29);
		frame.getContentPane().add(calcular);
		vc.subirVehiculo(calcular,nombre,marca,tipo,propietario);
		
		JButton back = new JButton("Atrás");
		back.setBounds(327, 243, 117, 29);
		frame.getContentPane().add(back);
		vc.volverAtras(back,frame);
	}

}
