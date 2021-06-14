package edu.es.ies.dto;

import javax.persistence.Column;

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
public class FarmaciaDto {
	
	private int id;			
	@Column
	private String nombre;	

	private String direccion;

	private String telefono;

	private String descripcion;
	
	private String ciudad;

	private String codigoPostal;

	private String linkGoogleMaps;
	

}
