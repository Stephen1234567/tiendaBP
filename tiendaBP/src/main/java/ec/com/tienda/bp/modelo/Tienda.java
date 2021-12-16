package ec.com.tienda.bp.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table ( name = "tienda" )
public class Tienda {
	
	@Id
	@Column ( name = "id" )
	private int idTienda;
	@Column ( name = "nombre" )
	private String nombreTienda;
	@Column ( name = "idproducto" )
	private int idProducto;
	
	public int getIdTienda() {
		return idTienda;
	}
	public void setIdTienda(int idTienda) {
		this.idTienda = idTienda;
	}
	public String getNombreTienda() {
		return nombreTienda;
	}
	public void setNombreTienda(String nombreTienda) {
		this.nombreTienda = nombreTienda;
	}
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

}
