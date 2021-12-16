package ec.com.tienda.bp.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.com.tienda.bp.dao.ProductoRepositorio;
import ec.com.tienda.bp.dao.TiendaRepositorio;
import ec.com.tienda.bp.dao.TiendaServicio;
import ec.com.tienda.bp.modelo.Producto;
import ec.com.tienda.bp.modelo.Tienda;

@Service
public class TiendaServicioImpl implements TiendaServicio{
	
	@Autowired
	TiendaRepositorio repositorio;
	@Autowired
	ProductoRepositorio repositorioProducto;

	@Override
	public List<Tienda> obtenerTiendas() {
		return repositorio.findAll();
	}

	@Override
	public Tienda actualizarTienda(Tienda t) {
		return repositorio.save(t);
	}

	@Override
	public Tienda agregarTienda(Tienda t) {
		return repositorio.save(t);
	}

	@Override
	public boolean venderProducto(List<Producto> productos) {
		boolean respuesta = false;
		for (Producto producto : productos) {
			producto.setExistentesProducto(producto.getExistentesProducto() - 1);
			repositorioProducto.save(producto);
			respuesta = true;
		}
		return respuesta;
	}

	@Override
	public Tienda obtenerTiendaByProd(String nombreTienda, int idProducto) {
		return repositorio.obtenerTiendaByProducto(nombreTienda, idProducto);
	}

}
