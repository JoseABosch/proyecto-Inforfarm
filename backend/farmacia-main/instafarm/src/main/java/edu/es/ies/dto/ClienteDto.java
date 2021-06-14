package edu.es.ies.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import edu.es.ies.entity.Pedido;
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
public class ClienteDto extends PersonaDto {
	
	private String usuario;

	private String password;
	
	@JsonIgnore
	private List<Pedido> pedidos;
	
	
}
