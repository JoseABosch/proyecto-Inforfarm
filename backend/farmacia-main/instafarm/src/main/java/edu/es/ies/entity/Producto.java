package edu.es.ies.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "producto")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;			
	@Column(nullable = false)
	private String codigo;
	@Column(nullable = false)
	private String nombre;
	@Column(nullable = false)
	private String marca;
	@Column(nullable = false)
	private Double precio;
	@Column
	private String descripcion;
	@Column
	private String peso;
	@Column
	private Integer cantidad;
	@Column
	private String imagen;
	
	@ManyToMany(targetEntity = Pedido.class, fetch = FetchType.LAZY)
	private List<Pedido> pedidos;
	

}
