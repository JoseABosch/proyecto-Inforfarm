package edu.es.ies.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "emergencias")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Emergencia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;			
	@Column(nullable = false)
	private String nombre;
	@Column(nullable = false)
	private String telefono;
	

}
