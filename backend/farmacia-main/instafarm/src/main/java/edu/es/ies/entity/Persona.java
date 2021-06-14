package edu.es.ies.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="persona")
@Inheritance
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;			
	@Column(nullable = false)
	private String nombre;	
	@Column
	private Date fechaNacimiento;
	@Column(nullable = false)
	private String sip;
	@Column(nullable = false)
	private String direccion;
	@Column
	private String telefono;
	@Column(nullable = false)
	private String email;

}
