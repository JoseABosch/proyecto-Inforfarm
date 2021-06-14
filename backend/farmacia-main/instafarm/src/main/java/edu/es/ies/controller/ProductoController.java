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

import edu.es.ies.dto.ProductoDto;
import edu.es.ies.service.ProductoService;

@RestController
@CrossOrigin
public class ProductoController {

	@Autowired
	private ProductoService service;	
	
	@GetMapping("/producto/{id}")
	private ResponseEntity<ProductoDto> findById(@PathVariable Integer id){
		
		return ResponseEntity.ok(this.service.findById(id));
		
	}
	
	@GetMapping("/producto")
	public ResponseEntity<List<ProductoDto>> findAll() {

		return ResponseEntity.ok(this.service.findAll());
	}
	
	@GetMapping("/producto/codigo/{codigo}")
	private ResponseEntity<ProductoDto> findByCodigo(@PathVariable String codigo){
		
		return ResponseEntity.ok(this.service.findByCodigo(codigo));
		
	}
	
	@PostMapping("/producto")
	private ResponseEntity<?> saveProducto(@RequestBody ProductoDto producto){
		
		this.service.save(producto);
		
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	@DeleteMapping("/producto/{id}")
	private ResponseEntity<?> deleteById(@PathVariable Integer id){
		
		this.service.deleteById(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	
	
}
