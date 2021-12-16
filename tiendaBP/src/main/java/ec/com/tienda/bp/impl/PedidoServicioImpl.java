package ec.com.tienda.bp.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.com.tienda.bp.dao.PedidoRepositorio;
import ec.com.tienda.bp.dao.PedidoServicio;
import ec.com.tienda.bp.modelo.Pedido;

@Service
public class PedidoServicioImpl implements PedidoServicio{
	
	@Autowired
	PedidoRepositorio repositorio;

	@Override
	public List<Pedido> obtenerPedidos() {
		return repositorio.findAll();
	}

	@Override
	public List<Pedido> obtenerPedidosByTiendaByFecha(String nombreTienda, Date fecha) {
		return repositorio.obtenerPedidoByTiendaByFecha(nombreTienda, fecha);
	}

	@Override
	public List<Pedido> obtenerPedidosByTienda(String nombreTienda) {
		return repositorio.obtenerPedidoByTienda(nombreTienda);
	}

	@Override
	public List<Pedido> obtenerPedidosByClienteByFechas(int idCliente, Date fechaIni, Date fechaFin) {
		return repositorio.obtenerPedidoByCliente(idCliente, fechaIni, fechaFin);
	}

	@Override
	public Pedido agregarPedido(Pedido p) {
		return repositorio.save(p);
	}

}
