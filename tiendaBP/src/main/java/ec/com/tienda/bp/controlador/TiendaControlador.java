package ec.com.tienda.bp.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.com.tienda.bp.dao.ProductoServicio;
import ec.com.tienda.bp.dao.TiendaServicio;
import ec.com.tienda.bp.modelo.Producto;
import ec.com.tienda.bp.modelo.Tienda;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/tienda"})
public class TiendaControlador {
	
	@Autowired
	TiendaServicio servicio;
	@Autowired
	ProductoServicio servicioProducto;
	
	@PostMapping("/{nomTienda}/vender")
	public String venderProductos(@PathVariable("nomTienda")String nomTienda, @RequestBody List<Integer> idProductos) {
		String respuesta = "";
		List<Producto> listaProductos = new ArrayList<Producto>();
		for (int integer : idProductos) {
			Tienda t = servicio.obtenerTiendaByProd(nomTienda, integer);
			if(t != null) {
				Producto p = servicioProducto.obtenerProducto(integer);
				listaProductos.add(p);
			} else {
				respuesta = "La tienda no tiene el producto con id " + integer ;
			}
		}
		servicio.venderProducto(listaProductos);
		
		return respuesta;
	}

}
