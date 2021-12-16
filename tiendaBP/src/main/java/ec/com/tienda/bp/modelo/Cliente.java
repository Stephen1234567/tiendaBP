package ec.com.tienda.bp.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table ( name = "cliente" )
public class Cliente {
	
	@Id
	@Column ( name = "id" )
	private int idCliente;
	@Column ( name = "identificacion" )
	private String identificacionCliente;
	@Column ( name = "nombre" )
	private String nombreCliente;
	@Column ( name = "foto" )
	private String fotoCliente;
	
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getIdentificacionCliente() {
		return identificacionCliente;
	}
	public void setIdentificacionCliente(String identificacionCliente) {
		this.identificacionCliente = identificacionCliente;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getFotoCliente() {
		return fotoCliente;
	}
	public void setFotoCliente(String fotoCliente) {
		this.fotoCliente = fotoCliente;
	}
	
}
