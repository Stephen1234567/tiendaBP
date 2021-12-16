package ec.com.tienda.bp.dao;

import java.util.List;

import ec.com.tienda.bp.modelo.Cliente;

public interface ClienteServicio {
	
	List<Cliente> obtenerClientes();
	Cliente obtenerCliente(int idCliente);
	Cliente agregarCliente(Cliente c);
	void eliminarCliente(int idCliente);
	Cliente actualizarCliente(Cliente c);

}
