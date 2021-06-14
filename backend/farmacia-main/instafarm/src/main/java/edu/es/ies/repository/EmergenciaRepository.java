package edu.es.ies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.es.ies.entity.Emergencia;

@Repository
public interface EmergenciaRepository extends JpaRepository<Emergencia, Integer> {
	
}
