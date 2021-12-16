package ec.com.tienda.bp.dao;

import java.util.List;

import ec.com.tienda.bp.modelo.Producto;

public interface ProductoServicio {
	
	List<Producto> obtenerProductos();
	Producto obtenerProducto(int idProducto);
	Producto actualizarProducto(Producto p);
	Producto agregarProducto(Producto p);
	
}
