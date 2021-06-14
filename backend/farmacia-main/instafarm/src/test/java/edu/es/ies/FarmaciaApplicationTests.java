package edu.es.ies;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import edu.es.ies.entity.Cliente;
import edu.es.ies.entity.Farmacia;
import edu.es.ies.entity.Pedido;
import edu.es.ies.entity.Producto;
import edu.es.ies.repository.FarmaciaRepository;
import edu.es.ies.repository.PedidoRepository;
import edu.es.ies.repository.PersonaRepository;
import edu.es.ies.repository.ProductoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest()	
class FarmaciaApplicationTests {

	
	@Autowired
	FarmaciaRepository farmaciaRepository;
	@Autowired
	PersonaRepository personaRepository;
	@Autowired
	ProductoRepository productoRepository;
	@Autowired
	PedidoRepository pedidoRepository;
	
//	********************
//	Test de farmacia.
//	********************
		
	@Test
	void createFarmacia() {
		
		Farmacia farmacia = this.farmaciaRepository.save(Farmacia.builder()
				.nombre("FARMACIA1")
				.direccion("CALLE CALLE")
				.telefono("600112233")
				.descripcion("FARMACIA DESRIPCION")
				.ciudad("CIUDAD")
				.codigoPostal("04692")
				.linkGoogleMaps("LINK GOOGLE").build());
		
		assertNotNull(farmacia.getId());
	}
	
	@Test
	void findFarmaciaById() {
		
		Farmacia farmacia = this.farmaciaRepository.save(Farmacia.builder()
				.nombre("FARMACIA2")
				.direccion("CALLE CALLE")
				.telefono("600112233")
				.descripcion("FARMACIA DESRIPCION")
				.ciudad("CIUDAD")
				.codigoPostal("04692")
				.linkGoogleMaps("LINK GOOGLE").build());
		
		assertNotNull(farmaciaRepository.findById(farmacia.getId()));
	}
	
	@Test
	void farmaciaUpdate(){
		
		Farmacia farmacia =this.farmaciaRepository.save(Farmacia.builder()
				.nombre("FARMACIA3")
				.direccion("CALLE CALLE")
				.telefono("600112233")
				.descripcion("FARMACIA DESRIPCION")
				.ciudad("CIUDAD")
				.codigoPostal("04692")
				.linkGoogleMaps("LINK GOOGLE").build());
		
		farmacia.setCiudad("ALICANTE");
		
		farmacia = this.farmaciaRepository.save(farmacia);
		
		assertEquals("ALICANTE", farmacia.getCiudad());
	}
	
	@Test
	void deleteFarmaciaById() {
				
		Farmacia farmacia =this.farmaciaRepository.save(Farmacia.builder()
				.nombre("FARMACIA4")
				.direccion("CALLE CALLE")
				.telefono("600112233")
				.descripcion("FARMACIA DESRIPCION")
				.ciudad("CIUDAD")
				.codigoPostal("04692")
				.linkGoogleMaps("LINK GOOGLE").build());
		
				
		this.farmaciaRepository.deleteById(farmacia.getId());
		
		assertEquals(Optional.empty() ,this.farmaciaRepository.findById(farmacia.getId()));
	}
	
//	********************
//	Test de cliente.
//	********************
	
	@Test
	void createCliente() {
		
		Cliente cliente=this.personaRepository.save(Cliente.builder().usuario("PRUEBA").build());
		
		assertNotNull(cliente.getId());
				
	}
	
	@Test
	@Transactional
	void createPedido() {
		
		Farmacia farmacia=this.farmaciaRepository.save(Farmacia.builder().nombre("FARMACIA").build());
		Cliente cliente=this.personaRepository.save(Cliente.builder().usuario("PEPE").build());
		Producto producto1=this.productoRepository.save(Producto.builder().codigo("PRODUCTO 1").build());
		Producto producto2=this.productoRepository.save(Producto.builder().codigo("PRODUCTO 2").build());
		
		
		List<Producto> productos=new ArrayList<Producto>();
		productos.add(producto1);
		productos.add(producto2);
		
		Pedido pedido= Pedido.builder()
				       .cliente(cliente)
				       .codigo("CODIGO PEDIDO")
				       .farmacia(farmacia)
				       .productos(productos)
				       .build();
		
		List<Pedido> pedidosFarmacia=new ArrayList<Pedido>();
		pedidosFarmacia.add(pedido);
		farmacia.setPedidos(pedidosFarmacia);
		
		this.pedidoRepository.save(pedido);
		
		assertEquals(1,this.pedidoRepository.count());
		
	}
	
}
