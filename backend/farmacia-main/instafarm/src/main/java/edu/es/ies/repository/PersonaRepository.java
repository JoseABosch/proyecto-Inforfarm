package edu.es.ies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.google.common.base.Optional;

import edu.es.ies.entity.Cliente;

@Repository
public interface PersonaRepository extends JpaRepository<Cliente, Integer> {
	
	public Optional<Cliente> findByUsuario(String usuario);
}
