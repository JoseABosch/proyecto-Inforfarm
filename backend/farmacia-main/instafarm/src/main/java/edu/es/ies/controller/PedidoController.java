package edu.es.ies.controller;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.es.ies.dto.ClienteDto;
import edu.es.ies.dto.FarmaciaDto;
import edu.es.ies.dto.PedidoAltaDto;
import edu.es.ies.dto.PedidoDto;
import edu.es.ies.service.FarmaciaService;
import edu.es.ies.service.PedidoService;
import edu.es.ies.service.PersonaService;

@RestController
@CrossOrigin
public class PedidoController {
	
	@Autowired
	private FarmaciaService farmaciaService;

	@Autowired
	private PedidoService pedidoService;

	@Autowired
	private PersonaService personaService;

	@GetMapping("/pedido/{id}")
	private ResponseEntity<PedidoDto> findById(@PathVariable Integer id) {

		return ResponseEntity.ok(this.pedidoService.findById(id));

	}

	@GetMapping("/pedido/codigo/{codigo}")
	private ResponseEntity<PedidoDto> findByCodigo(@PathVariable String codigo) {

		return ResponseEntity.ok(this.pedidoService.findByCodigo(codigo));

	}

	@PostMapping("/pedido")
	@Transactional
	private ResponseEntity<?> comprar(@RequestBody PedidoAltaDto pedido) {

		ClienteDto clienteDto = this.personaService.findClienteByIdPersona(pedido.getIdCliente());

		FarmaciaDto farmacia = this.farmaciaService.findById(1);
		if (clienteDto != null) {

			String codigo =String.valueOf(pedido.getIdCliente())  + Calendar.getInstance().getTimeInMillis();
			this.pedidoService.save(pedido.getIdCliente(), codigo, farmacia.getId(),
					pedido.getProductos());

		} else {
			return ResponseEntity.badRequest().body("Usuario no existente");
		}

		return new ResponseEntity<>(HttpStatus.OK);

	}

	@DeleteMapping("/pedido/{id}")
	private ResponseEntity<?> deleteById(@PathVariable Integer id) {

		this.pedidoService.deleteById(id);

		return new ResponseEntity<>(HttpStatus.OK);

	}

}
