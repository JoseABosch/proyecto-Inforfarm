package edu.es.ies.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.es.ies.dto.ClienteDto;
import edu.es.ies.dto.PersonaDto;
import edu.es.ies.entity.Cliente;
import edu.es.ies.repository.PersonaRepository;

@Service
public class PersonaService {

	@Autowired
	private PersonaRepository repository;
	
	@Autowired
	private ModelMapper mapper;

	@Transactional
	public void save(PersonaDto persona) {

		this.repository.save(mapper.map(persona, Cliente.class));
	}
	
	public PersonaDto findById(Integer id) {

		return mapper.map(this.repository.findById(id).get(),PersonaDto.class);
	}
	
	public ClienteDto findClienteByIdPersona(Integer id) {

		return mapper.map(this.repository.findById(id).get(),ClienteDto.class);
	}
	
	public ClienteDto findByUsuario(String usuario) {
		
		return mapper.map(this.repository.findByUsuario(usuario).get(), ClienteDto.class);
	}
	
	public List<PersonaDto> findAll() {
		
		return this.repository.findAll().stream().map(p->mapper.map(p, PersonaDto.class)).collect(Collectors.toList());
	}
	
	@Transactional
	public void deleteById(Integer id) {

		this.repository.deleteById(id);
	}

}
