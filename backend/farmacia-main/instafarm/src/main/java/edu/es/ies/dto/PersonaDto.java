package edu.es.ies.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonaDto {	
	
	private int id;			

	private String nombre;	

	private Date fechaNacimiento;

	private String sip;

	private String direccion;
	
	private String telefono;
	
	private String email;

}
