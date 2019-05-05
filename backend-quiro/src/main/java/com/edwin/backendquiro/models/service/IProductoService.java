package com.edwin.backendquiro.models.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.edwin.backendquiro.models.entity.Producto;

public interface IProductoService {

	public List<Producto> findAll();

	public Producto save(Producto producto);

	public Producto findById(Long id);

	public void delete(Producto producto);

	public List<Producto> findByNombre(String term);

	public List<Producto> findByNombreCrear(String term);

	public List<Producto> findByNombreLikeIgnoreCase(String term);

}
