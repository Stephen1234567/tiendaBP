package ec.com.tienda.bp.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.com.tienda.bp.dao.ClienteServicio;
import ec.com.tienda.bp.modelo.Cliente;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/cliente"})
public class ClienteControlador {

	@Autowired
	ClienteServicio servicioCliente;
	
	@GetMapping("/obtenerClientes")
	public List<Cliente> obtenerClientes(){
		return servicioCliente.obtenerClientes();
	}
	
	@GetMapping("/obtenerCliente/{idCliente}")
	public Cliente obtenerCliente(@PathVariable("idCliente")int idCliente){
		return servicioCliente.obtenerCliente(idCliente);
	}
	
	@DeleteMapping("/borrar/{idCliente}")  
	public void deleteBook(@PathVariable("idCliente") int idCliente){  
		servicioCliente.eliminarCliente(idCliente);  
	}  
	
	@PostMapping("/agregarCliente")
	public Cliente agregarCliente(@RequestBody Cliente c) {
		return servicioCliente.agregarCliente(c);
	}
	
	@PutMapping("/actualizarCliente")  
	public Cliente actualizarCliente(@RequestBody Cliente c){  
		return servicioCliente.actualizarCliente(c);
	}
	
}
