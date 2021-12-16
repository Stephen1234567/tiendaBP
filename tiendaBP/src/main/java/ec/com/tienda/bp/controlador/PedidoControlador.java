package ec.com.tienda.bp.controlador;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

import ec.com.tienda.bp.dao.ClienteServicio;
import ec.com.tienda.bp.dao.PedidoServicio;
import ec.com.tienda.bp.dao.ProductoServicio;
import ec.com.tienda.bp.dao.TiendaServicio;
import ec.com.tienda.bp.modelo.Cliente;
import ec.com.tienda.bp.modelo.Pedido;
import ec.com.tienda.bp.modelo.Producto;
import ec.com.tienda.bp.modelo.Tienda;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/pedido"})
public class PedidoControlador {
	
	@Autowired
	PedidoServicio servicioPedido;
	
	@Autowired
	TiendaServicio servicioTienda;
	
	@Autowired
	ClienteServicio servicioCliente;
	
	@Autowired
	ProductoServicio servicioProducto;
	
	@Autowired
    RestTemplate restTemplate;
	
	public Producto ingresarStock(Producto p){
        ResponseEntity<Producto> response =
                  restTemplate.getForEntity(
                  "https://mocki.io/v1/93b2a7e1-3287-4563-b73c-1514dd5be963",
                  Producto.class);
        Producto prod = response.getBody();
        p.setExistentesProducto(p.getExistentesProducto() + prod.getExistentesProducto());
		servicioProducto.agregarProducto(p);
		return p;
    }
	
	public Producto ingresarStock2(Producto p){
        ResponseEntity<Producto> response =
                  restTemplate.getForEntity(
                  "https://mocki.io/v1/8043a52e-4f7e-47ad-89f8-bc4ab17b1c48",
                  Producto.class);
        Producto prod = response.getBody();
        p.setExistentesProducto(p.getExistentesProducto() + prod.getExistentesProducto());
		servicioProducto.agregarProducto(p);
		return p;
    }
	
	@Autowired
	public PedidoControlador(RestTemplate restTemplate, ProductoServicio servicioProducto){
		this.restTemplate = restTemplate;
		this.servicioProducto = servicioProducto;
	}
	
	@PostMapping("/realizarPedido")
	public String realizarPedido(@RequestBody Pedido p) {
		String respuesta = "";
		Producto prod = servicioProducto.obtenerProducto(p.getIdProducto());
		Cliente cli = servicioCliente.obtenerCliente(p.getIdCliente());
		List<Producto> listaProductos = new ArrayList<Producto>();
		if(cli != null) {
			if(prod != null) {
				listaProductos.add(prod);
				int stockFaltante = p.getCantidad() - prod.getExistentesProducto();
				if(stockFaltante > 10) {
					respuesta = "Unidades no disponibles >10";
				} else if(stockFaltante > 5 && stockFaltante <= 10) {
					prod = this.ingresarStock(prod);
				} else {
					Tienda tienda = servicioTienda.obtenerTiendaByProd(p.getNombreTienda(), prod.getIdProducto());
					if(tienda != null) {
						servicioTienda.venderProducto(listaProductos);
						this.ingresarStock2(prod);
					} else {
						respuesta = respuesta + " | El producto no existe en la tienda";
					}
				}
			} else {
				respuesta = respuesta + " | Producto no existe";
			}
		} else {
			respuesta = "Cliente no existe";
		}
		return respuesta;
	}
	
	@GetMapping("/obtenerPedidosByFecha")
	public List<Pedido> obtenerPedidosByTiendaByFecha(String nombreTienda, String fecha){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date f = new Date(fecha);
		return servicioPedido.obtenerPedidosByTiendaByFecha(nombreTienda, f);
	}
	
	@GetMapping("/obtenerMontos")
	public List<Pedido> obtenerMontos(String nombreTienda, int idProducto){
		return servicioPedido.obtenerPedidosByTienda(nombreTienda);
	}
	

}
