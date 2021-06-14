package edu.es.ies.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "cliente")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cliente extends Persona {	
	
	@Column(nullable = false)
	private String usuario;
	@Column(nullable = false)
	private String password;
	
	@OneToMany(targetEntity = Pedido.class, cascade = CascadeType.ALL)
	private List<Pedido> pedidos;
	

}
