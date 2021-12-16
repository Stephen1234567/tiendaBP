package ec.com.tienda.bp.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.com.tienda.bp.dao.ProductoRepositorio;
import ec.com.tienda.bp.dao.ProductoServicio;
import ec.com.tienda.bp.modelo.Producto;

@Service
public class ProductoServicioImpl implements ProductoServicio{

	@Autowired
	ProductoRepositorio repositorio;
	
	@Override
	public List<Producto> obtenerProductos() {
		return repositorio.findAll();
	}

	@Override
	public Producto actualizarProducto(Producto p) {
		return repositorio.save(p);
	}

	@Override
	public Producto agregarProducto(Producto p) {
		return repositorio.save(p);
	}

	@Override
	public Producto obtenerProducto(int idProducto) {
		return repositorio.findById(idProducto).get();
	}

}
