package ec.com.tienda.bp.dao;

import java.util.List;

import ec.com.tienda.bp.modelo.Producto;
import ec.com.tienda.bp.modelo.Tienda;

public interface TiendaServicio {
	
	List<Tienda> obtenerTiendas();
	Tienda actualizarTienda(Tienda t);
	Tienda agregarTienda(Tienda t);
	boolean venderProducto(List<Producto> productos);
	Tienda obtenerTiendaByProd(String nombreTienda, int idProducto);

}
