package Model;

public class VehiculoModel {
	private int idvehicle;
	private String nombre;
	private String marca;
	private String tipo;
	private String propieratorio;
	public VehiculoModel() {
		this.idvehicle = 0;
		this.nombre = "";
		this.marca = "";
		this.tipo = "";
		this.propieratorio = "";
	}
	
	public int getIdvehicle() {
		return idvehicle;
	}
	public void setIdvehicle(int idvehicle) {
		this.idvehicle = idvehicle;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getPropieratorio() {
		return propieratorio;
	}
	public void setPropieratorio(String propieratorio) {
		this.propieratorio = propieratorio;
	}
	

}
