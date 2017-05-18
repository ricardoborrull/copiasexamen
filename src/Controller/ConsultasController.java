package Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import javax.swing.DefaultListModel;

import Model.BD;
import Model.VehiculoModel;

public class ConsultasController {

	public ConsultasController() {

	}
	
	public DefaultListModel cogerVehiculos(){
    	    ResultSet rs = null;
    		BD cn = new BD();
    		DefaultListModel model = new DefaultListModel();
	    	Statement stmt;
			try {
				stmt = cn.getConexion().createStatement();
				rs = stmt.executeQuery("SELECT * FROM vehicles");
				while (rs.next()) {
		        	VehiculoModel vh = new VehiculoModel();
		            vh.setIdvehicle(rs.getInt("idvehicle"));
		            vh.setNombre(rs.getString("nom"));
		            vh.setMarca(rs.getString("marca"));
		            vh.setTipo(rs.getString("tipus"));
		            vh.setPropieratorio(rs.getString("propietari"));
		            model.addElement(vh.getNombre()+" ,"+vh.getMarca());
		       }
			} catch (SQLException e) {
				e.printStackTrace();
			}		
	    return model;
	}
	public ArrayList exportarVehiculos(){
		ArrayList<VehiculoModel> list = new ArrayList<VehiculoModel>();
	    ResultSet rs = null;
		BD cn = new BD();
    	Statement stmt;
		try {
			stmt = cn.getConexion().createStatement();
			rs = stmt.executeQuery("SELECT * FROM vehicles");
			while (rs.next()) {
	        	VehiculoModel vh = new VehiculoModel();
	            vh.setIdvehicle(rs.getInt("idvehicle"));
	            vh.setNombre(rs.getString("nom"));
	            vh.setMarca(rs.getString("marca"));
	            vh.setTipo(rs.getString("tipus"));
	            vh.setPropieratorio(rs.getString("propietari"));
	            list.add(vh);
	       }
		} catch (SQLException e) {
			e.printStackTrace();
		}		
    return list;
}
	public static void insertarEntradas(String idvehicle,String litres, String preu){
		ResultSet rs = null;
		BD cn = new BD();
    	Statement stmt;
    	int idVehiculo = Integer.parseInt(idvehicle);
    	double litros = Double.parseDouble(litres);
    	double precio = Double.parseDouble(preu);
    	double total = litros*precio;
		try {
			String sql = "INSERT INTO entrades (idvehicle, litres, preu, totalEuros)" +
			        "VALUES (?, ?, ?, ?)";
			PreparedStatement preparedStatement = cn.getConexion().prepareStatement(sql);
			preparedStatement.setInt(1, idVehiculo);
			preparedStatement.setDouble(2, litros);
			preparedStatement.setDouble(3, precio);
			preparedStatement.setDouble(4, total);
			preparedStatement.executeUpdate(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public static void subirVehiculos(String nom,String marca, String tipus,String propietari){
		ResultSet rs = null;
		BD cn = new BD();
    	Statement stmt;
		try {
			String sql = "INSERT INTO vehicles (nom, marca, tipus, propietari)" +
			        "VALUES (?, ?, ?, ?)";
			PreparedStatement preparedStatement = cn.getConexion().prepareStatement(sql);
			preparedStatement.setString(1, nom);
			preparedStatement.setString(2, marca);
			preparedStatement.setString(3, tipus);
			preparedStatement.setString(4, propietari);
			preparedStatement.executeUpdate(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

}
