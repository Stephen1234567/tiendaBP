package ec.com.tienda.bp.controlador;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import ec.com.tienda.bp.dao.ProductoServicio;
import ec.com.tienda.bp.modelo.Producto;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/producto"})
public class ProductoControlador {

	@Autowired
	ProductoServicio servicio;
	
	@Autowired
    RestTemplate restTemplate;
	
	public void ingresarProductosPrueba(){
        ResponseEntity<Producto[]> response =
                  restTemplate.getForEntity(
                  "https://mocki.io/v1/91919bc2-627f-4594-8b60-c9ffe8d09b3c",
                  Producto[].class);
        Producto[] prods = response.getBody();
        List<Producto> productos = Arrays.asList(prods);
        for (Producto producto : productos) {
			servicio.agregarProducto(producto);
		}
    }
	
	@Autowired
	public ProductoControlador(RestTemplate restTemplate, ProductoServicio servicio){
		this.restTemplate = restTemplate;
		this.servicio = servicio;
		this.ingresarProductosPrueba();
	}
	
	@GetMapping("/obtenerProductos")
	public List<Producto> listarProductos(){
		return servicio.obtenerProductos();
	}
	
	@PostMapping("/actualizarProducto")
	public String editarProducto(@RequestBody Producto producto) {
		String respuesta = "";
		if(producto.getExistentesProducto() > 0) {			
			servicio.actualizarProducto(producto);
			respuesta = "Se actualizó el producto correctamente";
		} else {
			respuesta = "El campo existentesProducto debe ser mayor a cero ";
		}
		return respuesta;
	}
	
}
