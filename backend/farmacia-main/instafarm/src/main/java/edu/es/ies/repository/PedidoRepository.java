package edu.es.ies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.es.ies.entity.Pedido;
import edu.es.ies.entity.Producto;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
	
	public Producto findByCodigo(String codigo);

}
