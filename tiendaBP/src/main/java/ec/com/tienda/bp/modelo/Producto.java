package ec.com.tienda.bp.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table ( name = "producto" )
public class Producto {
	
	@Id
	@Column ( name = "id" )
	private int idProducto;
	@Column ( name = "codigo" )
	private String codigoProducto;
	@Column ( name = "nombre" )
	private String nombreProducto;
	@Column ( name = "precio" )
	private double precioProducto;
	@Column ( name = "existentes" )
	private int existentesProducto;
	
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public String getCodigoProducto() {
		return codigoProducto;
	}
	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public double getPrecioProducto() {
		return precioProducto;
	}
	public void setPrecioProducto(double precioProducto) {
		this.precioProducto = precioProducto;
	}
	public int getExistentesProducto() {
		return existentesProducto;
	}
	public void setExistentesProducto(int existentesProducto) {
		this.existentesProducto = existentesProducto;
	}
	
}
