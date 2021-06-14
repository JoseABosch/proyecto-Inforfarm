package edu.es.ies.dto;

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
public class ProductoDto {
	
	private int id;

	private String codigo;
	
	private String nombre;

	private String marca;

	private Double precio;
	
	private String descripcion;
	
	private String peso;
	
	private Integer cantidad;
	
	private String imagen;
}
