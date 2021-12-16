package ec.com.tienda.bp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ec.com.tienda.bp.modelo.Tienda;

@Repository
public interface TiendaRepositorio extends JpaRepository<Tienda, Integer> {
	
	@Query(nativeQuery = true, value = "SELECT * FROM tienda c WHERE c.nombre = :CODIGO1 AND c.idproducto = :CODIGO")
	Tienda obtenerTiendaByProducto(@Param("CODIGO1") String nombreTienda, @Param("CODIGO") int idProducto);

}
