package ec.com.tienda.bp.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.com.tienda.bp.dao.ClienteRepositorio;
import ec.com.tienda.bp.dao.ClienteServicio;
import ec.com.tienda.bp.modelo.Cliente;

@Service
public class ClienteServicioImpl implements ClienteServicio{
	
	@Autowired
	ClienteRepositorio repositorio;

	@Override
	public List<Cliente> obtenerClientes() {
		return repositorio.findAll();
	}

	@Override
	public Cliente agregarCliente(Cliente c) {
		return repositorio.save(c);
	}

	@Override
	public void eliminarCliente(int idCliente) {
		repositorio.deleteById(idCliente);
	}

	@Override
	public Cliente actualizarCliente(Cliente c) {
		return repositorio.save(c);
	}

	@Override
	public Cliente obtenerCliente(int idCliente) {
		return repositorio.findById(idCliente).get();
	}

}
