package edu.es.ies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.es.ies.entity.Farmacia;

@Repository
public interface FarmaciaRepository extends JpaRepository<Farmacia, Integer> {

}
