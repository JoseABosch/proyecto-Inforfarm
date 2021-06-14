package edu.es.ies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.es.ies.dto.ClienteDto;
import edu.es.ies.dto.PersonaDto;
import edu.es.ies.service.PersonaService;

@RestController
@CrossOrigin
public class PersonaController {

	@Autowired
	private PersonaService service;
	
	@PostMapping("/persona/{id}")
	public ResponseEntity<?> updateByUsuario(@PathVariable Integer id, @RequestBody ClienteDto clienteFront) {
		ClienteDto cliente = this.service.findByUsuario(clienteFront.getUsuario());

		cliente.setUsuario(clienteFront.getUsuario());
		cliente.setNombre(clienteFront.getNombre());
		cliente.setEmail(clienteFront.getEmail());
		cliente.setFechaNacimiento((java.sql.Date) clienteFront.getFechaNacimiento());
		cliente.setDireccion(clienteFront.getDireccion());
		cliente.setPassword(clienteFront.getPassword());
		cliente.setTelefono(clienteFront.getTelefono());
		cliente.setSip(clienteFront.getSip());

		//this.service.deleteById(id);
		this.service.save(cliente);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/persona/{id}")
	public ResponseEntity<PersonaDto> findById(@PathVariable Integer id) {

		return ResponseEntity.ok(this.service.findClienteByIdPersona(id));

	}

	@GetMapping("/persona")
	public ResponseEntity<List<PersonaDto>> findAll() {

		return ResponseEntity.ok(this.service.findAll());

	}

	@PostMapping("/persona")
	public ResponseEntity<?> saveCliente(@RequestBody ClienteDto persona) {

		if (!persona.getEmail().contains("@")) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		this.service.save(persona);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/persona/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Integer id) {

		if (this.service.findById(id) != null) {
			this.service.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
