package edu.es.ies.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.es.ies.dto.FarmaciaDto;
import edu.es.ies.entity.Farmacia;
import edu.es.ies.repository.FarmaciaRepository;

@Service
public class FarmaciaService {

	@Autowired
	private FarmaciaRepository repository;
	
	@Autowired
	private ModelMapper mapper;

	@Transactional
	public void save(FarmaciaDto farmacia) {

		this.repository.save(mapper.map(farmacia, Farmacia.class));
	}
	
	public FarmaciaDto findById(Integer id) {

		return mapper.map(this.repository.findById(id).get(),FarmaciaDto.class);
	}
	
	@Transactional
	public void deleteById(Integer id) {

		this.repository.deleteById(id);
	}

}
