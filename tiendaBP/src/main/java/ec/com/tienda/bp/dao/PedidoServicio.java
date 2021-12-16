package ec.com.tienda.bp.dao;

import java.util.Date;
import java.util.List;

import ec.com.tienda.bp.modelo.Pedido;

public interface PedidoServicio {
	
	List<Pedido> obtenerPedidos();
	List<Pedido> obtenerPedidosByTiendaByFecha(String nombreTienda, Date fecha);
	List<Pedido> obtenerPedidosByTienda(String nombreTienda);
	List<Pedido> obtenerPedidosByClienteByFechas(int idCliente, Date fechaIni, Date fechaFin);
	Pedido agregarPedido(Pedido p);

}
