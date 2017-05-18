package Inicio;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JList;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Font;
import Controller.ConsultasController;
import Model.VehiculoModel;
import View.EntradaVista;
import View.VehiculoVista;

import javax.swing.JButton;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


public class Principal extends JFrame {

	public JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		ConsultasController pc = new ConsultasController();
		setTitle("Examen 3 av");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 392);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {30, 0, 30, 30, 0, 30, 30, 30, 30, 6};
		gbl_contentPane.rowHeights = new int[] {30, 0, 30, 30, 0, 30, 30, 30, 30, 6};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JButton btnAfegirVehicle = new JButton("Afegir Vehicle");
		GridBagConstraints gbc_btnAfegirVehicle = new GridBagConstraints();
		gbc_btnAfegirVehicle.insets = new Insets(0, 0, 5, 5);
		gbc_btnAfegirVehicle.gridx = 1;
		gbc_btnAfegirVehicle.gridy = 1;
		contentPane.add(btnAfegirVehicle, gbc_btnAfegirVehicle);
		btnAfegirVehicle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VehiculoVista window = new VehiculoVista();
				window.frame.setVisible(true);
			}
		});
	
		
		JLabel lblVehicle = new JLabel("Vehicle:");
		lblVehicle.setFont(new Font("Times New Roman", Font.BOLD, 13));
		GridBagConstraints gbc_lblVehicle = new GridBagConstraints();
		gbc_lblVehicle.insets = new Insets(0, 0, 5, 5);
		gbc_lblVehicle.gridx = 4;
		gbc_lblVehicle.gridy = 1;
		contentPane.add(lblVehicle, gbc_lblVehicle);
		
		JList list = new JList();
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.gridheight = 5;
		gbc_list.gridwidth = 4;
		gbc_list.insets = new Insets(0, 0, 5, 5);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 4;
		gbc_list.gridy = 2;

		list.setModel(pc.cogerVehiculos());
		contentPane.add(list, gbc_list);
		
		
		JButton btnExportarDades = new JButton("Exportar Dades");
		GridBagConstraints gbc_btnExportarDades = new GridBagConstraints();
		gbc_btnExportarDades.gridwidth = 2;
		gbc_btnExportarDades.gridheight = 2;
		gbc_btnExportarDades.insets = new Insets(0, 0, 5, 0);
		gbc_btnExportarDades.gridx = 9;
		gbc_btnExportarDades.gridy = 4;
		contentPane.add(btnExportarDades, gbc_btnExportarDades);
		btnExportarDades.addActionListener(new ActionListener() {
			int contador = 0;
			public void actionPerformed(ActionEvent e) {
				contador++;
				exportar(list,contador);
			}
		});
		
		JButton btnAfegirEntrada = new JButton("Afegir Entrada");
		GridBagConstraints gbc_btnAfegirEntrada = new GridBagConstraints();
		gbc_btnAfegirEntrada.gridheight = 2;
		gbc_btnAfegirEntrada.fill = GridBagConstraints.BOTH;
		gbc_btnAfegirEntrada.insets = new Insets(0, 0, 5, 5);
		gbc_btnAfegirEntrada.gridx = 1;
		gbc_btnAfegirEntrada.gridy = 5;
		contentPane.add(btnAfegirEntrada, gbc_btnAfegirEntrada);
		btnAfegirEntrada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EntradaVista window = new EntradaVista();
				window.frame.setVisible(true);
			}
		});
		
		JButton btnRecarregar = new JButton("Recarregar");
		GridBagConstraints gbc_btnRecarregar = new GridBagConstraints();
		gbc_btnRecarregar.insets = new Insets(0, 0, 5, 5);
		gbc_btnRecarregar.gridx = 7;
		gbc_btnRecarregar.gridy = 7;
		contentPane.add(btnRecarregar, gbc_btnRecarregar);
	    Image img = null;
		try {
			img = ImageIO.read(getClass().getResource("../refresh.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    btnRecarregar.setIcon(new ImageIcon(img.getScaledInstance(20, 20,10)));
		btnRecarregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list.setModel(pc.cogerVehiculos());
			}
		});
	}
	
	public static void exportar(JList list,int contador){
		ConsultasController pc = new ConsultasController();
		int opcionUsuario = list.getSelectedIndex();
		ArrayList<VehiculoModel> vehiculos =  pc.exportarVehiculos();
		String fichero = "vehiculo"+contador+".txt";
		File x = new File(fichero);
		if(!x.exists()){
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter(fichero));
				bw.write(
						"ID DEL VEHICULO: "+vehiculos.get(opcionUsuario).getIdvehicle()+ "\n" +
						"NOMBRE DEL VEHICULO: "+vehiculos.get(opcionUsuario).getNombre()+ "\n"+
						"MARCA DEL VEHICULO: "+vehiculos.get(opcionUsuario).getMarca()+"\n"+
						"TIPO DEL VEHICULO: "+vehiculos.get(opcionUsuario).getTipo()+"\n"+
						"PROPIETARIO DEL VEHICULO: "+vehiculos.get(opcionUsuario).getPropieratorio()
				);
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("ese fichero ya existe");
		}
	}

}
