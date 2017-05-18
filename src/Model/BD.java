package Model;
import java.sql.Connection;
import java.sql.DriverManager;

public class BD {

	private Connection conexion;
	
	public BD() {
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		}catch(Exception e){
			System.err.println("Error registrant el Driver mysql");
			System.err.println(e);
		}
		try{
			String cadenaDeConnexio = "jdbc:mysql://localhost/vehicles?user=root&password=";
			conexion= DriverManager.getConnection(cadenaDeConnexio);
		}catch(Exception e){
			System.err.println("Error connectant a mysql/vehicles amb user=root");
		}
	
	}

	public Connection getConexion() {
		return conexion;
	}
	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}
	
	
}