package edu.es.ies.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.es.ies.dto.FarmaciaDto;
import edu.es.ies.service.FarmaciaService;

@RestController()
public class FarmaciaController {

	@Autowired
	private FarmaciaService service;	
	
	@GetMapping("/farmacia/{id}")
	private ResponseEntity<FarmaciaDto> findById(@PathVariable Integer id){
		
		return ResponseEntity.ok(this.service.findById(id));
		
	}
	
	@PostMapping("/farmacia")
	private ResponseEntity<?> saveFarmacia(@RequestBody FarmaciaDto farmacia){
		
		this.service.save(farmacia);
		
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	@DeleteMapping("/farmacia/{id}")
	private ResponseEntity<?> deleteById(@PathVariable Integer id){
		
		this.service.deleteById(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	
	
}
