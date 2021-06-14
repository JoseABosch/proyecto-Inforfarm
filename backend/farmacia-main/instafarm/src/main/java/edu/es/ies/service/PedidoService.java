package edu.es.ies.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.es.ies.dto.PedidoDto;
import edu.es.ies.entity.Cliente;
import edu.es.ies.entity.Farmacia;
import edu.es.ies.entity.Pedido;
import edu.es.ies.entity.Producto;
import edu.es.ies.repository.FarmaciaRepository;
import edu.es.ies.repository.PedidoRepository;
import edu.es.ies.repository.PersonaRepository;
import edu.es.ies.repository.ProductoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repository;
	
	@Autowired
	private PersonaRepository personaRepository;
	
	@Autowired
	private ProductoRepository productoRepository;
	
	@Autowired
	private FarmaciaRepository farmaciaRepository;
	
	@Autowired
	private ModelMapper mapper;

	@Transactional
	public void save(PedidoDto pedido) {

		Pedido entity=mapper.map(pedido, Pedido.class);
		entity.setFecha(new Date(Calendar.getInstance().getTimeInMillis()));	
				
		this.repository.save(entity);
	}
	
	@Transactional
	public void save(Integer clienteId,String codigoPedido,Integer farmaciaId, List<String> codigoProductos) {
		
		Cliente cliente=this.personaRepository.findById(clienteId).get();
		Farmacia farmacia=this.farmaciaRepository.findById(farmaciaId).get();
		List<Producto> productos=new ArrayList<Producto>();
		codigoProductos.forEach(c->{
			productos.add(this.productoRepository.findById(Integer.valueOf(c)).get());
		});		
		
		
		Pedido pedido = Pedido.builder()
				 .fecha(new Date(Calendar.getInstance().getTimeInMillis()))
				 .cliente(cliente)
				 .codigo(codigoPedido)
				 .farmacia(farmacia)
				 .productos(productos)
				 .build();
		
		pedido.getProductos().forEach(p-> {
			if(p.getPedidos()!= null) {
				p.getPedidos().add(pedido);
			} else {
				List<Pedido> pedidos = new ArrayList<Pedido>();
				pedidos.add(pedido);
				p.setPedidos(pedidos);
			}
		});
		
		this.repository.save(pedido);
	}
	
	public PedidoDto findById(Integer id) {

		return mapper.map(this.repository.findById(id).get(),PedidoDto.class);
	}	

	public PedidoDto findByCodigo(String codigo) {

		return mapper.map(this.repository.findByCodigo(codigo),PedidoDto.class);
	}
	
	@Transactional
	public void deleteById(Integer id) {

		this.repository.deleteById(id);
	}

}
