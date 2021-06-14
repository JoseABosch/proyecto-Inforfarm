package edu.es.ies.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.es.ies.dto.EmergenciaDto;
import edu.es.ies.entity.Emergencia;
import edu.es.ies.repository.EmergenciaRepository;

@Service
public class EmergenciaService {

	@Autowired
	private EmergenciaRepository repository;
	
	@Autowired
	private ModelMapper mapper;

	public void save(EmergenciaDto emergencia) {

		this.repository.save(mapper.map(emergencia, Emergencia.class));
	}

	public EmergenciaDto findById(Integer id) {

		return mapper.map(this.repository.findById(id).get(),EmergenciaDto.class);
	}
	
	public void deleteById(Integer id) {

		this.repository.deleteById(id);
	}

}
