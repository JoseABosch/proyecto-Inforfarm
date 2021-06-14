package edu.es.ies.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.es.ies.dto.ClienteDto;
import edu.es.ies.dto.LoginDto;
import edu.es.ies.service.PersonaService;

@RestController
@CrossOrigin
public class LoginController {

	@Autowired
	private PersonaService personaService;

	@PostMapping("/login")
	public ResponseEntity<ClienteDto> login(@RequestBody LoginDto usuario) {

		ClienteDto cliente = personaService.findByUsuario(usuario.getUsuario());

		if (cliente != null) {
			if (usuario.getPassword().equals(cliente.getPassword())) {
				return ResponseEntity.ok(cliente);
			} else {
				return new ResponseEntity<ClienteDto>(HttpStatus.UNAUTHORIZED);
			}
		} else {
			return new ResponseEntity<ClienteDto>(HttpStatus.UNAUTHORIZED);
		}
	}
}