package ec.com.tienda.bp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.com.tienda.bp.modelo.Cliente;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Integer>{

}
