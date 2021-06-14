package edu.es.ies.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.es.ies.dto.ProductoDto;
import edu.es.ies.entity.Producto;
import edu.es.ies.repository.ProductoRepository;

@Service
public class ProductoService {

	@Autowired
	private ProductoRepository repository;

	@Autowired
	private ModelMapper mapper;

	@Transactional
	public void save(ProductoDto producto) {

		this.repository.save(mapper.map(producto, Producto.class));
	}

	public ProductoDto findById(Integer id) {

		return mapper.map(this.repository.findById(id).get(), ProductoDto.class);
	}

	public ProductoDto findByCodigo(String codigo) {

		return mapper.map(this.repository.findByCodigo(codigo), ProductoDto.class);
	}

	public List<ProductoDto> findAll() {

		return this.repository.findAll().stream().map(p -> mapper.map(p, ProductoDto.class)).collect(Collectors.toList());
	}

	@Transactional
	public void deleteById(Integer id) {

		this.repository.deleteById(id);
	}

}
