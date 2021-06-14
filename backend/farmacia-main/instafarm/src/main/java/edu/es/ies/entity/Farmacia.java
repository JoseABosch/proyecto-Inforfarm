package edu.es.ies.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "farmacia")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Farmacia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;			
	@Column(nullable = false)
	private String nombre;	
	@Column(nullable = false)
	private String direccion;
	@Column(nullable = false)
	private String telefono;
	@Column
	private String descripcion;
	@Column(nullable = false)
	private String ciudad;
	@Column
	private String codigoPostal;
	@Column
	private String linkGoogleMaps;
	
	@OneToMany(targetEntity = Pedido.class, fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	private List<Pedido> pedidos;
	
	

}
