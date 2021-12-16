package ec.com.tienda.bp.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ec.com.tienda.bp.modelo.Pedido;


@Repository
public interface PedidoRepositorio extends JpaRepository<Pedido, Integer>{
	
	@Query(nativeQuery = true, value = "SELECT * FROM pedido c WHERE c.nombreTienda = :CODIGO1 AND c.fecha = :CODIGO")
	List<Pedido> obtenerPedidoByTiendaByFecha(@Param("CODIGO1") String nombreTienda, 
			@Param("CODIGO") Date fecha);
	
	@Query(nativeQuery = true, value = "SELECT * FROM pedido c WHERE c.nombreTienda = :CODIGO1)")
	List<Pedido> obtenerPedidoByTienda(@Param("CODIGO1") String nombreTienda);
	
	@Query(nativeQuery = true, value = "SELECT * FROM pedido c WHERE c.idcliente = :CODIGO1 AND c.fecha BETWEEN :INI AND :FIN")
	List<Pedido> obtenerPedidoByCliente(@Param("CODIGO1") int idCliente, @Param("INI") Date fIni, @Param("FIN") Date fFin);

}
