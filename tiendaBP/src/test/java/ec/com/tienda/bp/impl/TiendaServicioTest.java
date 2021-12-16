package ec.com.tienda.bp.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ec.com.tienda.bp.dao.TiendaRepositorio;
import ec.com.tienda.bp.dao.TiendaServicio;
import ec.com.tienda.bp.modelo.Producto;
import ec.com.tienda.bp.modelo.Tienda;

@RunWith(SpringRunner.class)
@SpringBootTest
class TiendaServicioTest {

	@Autowired
	TiendaServicio servicioTienda;
	@Autowired
	TiendaRepositorio repositorioTienda;
	
	@Test
	public void testObtenerTiendas() {
		Producto producto = createTestProducto();
		Tienda tienda = new Tienda();
		tienda.setIdProducto(producto.getIdProducto());
		tienda.setIdTienda(999);
		tienda.setNombreTienda("tienda prueba");
		
		Tienda t = servicioTienda.agregarTienda(tienda);
		
		assertThat("La tienda no debe ser null", t, notNullValue());
		
	}
	
	private Producto createTestProducto() {
		Producto p = new Producto();
		p.setCodigoProducto("prueba");
		p.setExistentesProducto(10);
		p.setIdProducto(999);
		p.setNombreProducto("nombre de prueba");
		p.setPrecioProducto(2.2);
		return p;
	}

}
