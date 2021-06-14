package edu.es.ies.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDto {

	private String codigo;	
	
	private List<ProductoDto> productos;
	
	private FarmaciaDto farmacia;
	
	private ClienteDto cliente;

}
