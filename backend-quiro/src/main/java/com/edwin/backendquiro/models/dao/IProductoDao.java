package com.edwin.backendquiro.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.edwin.backendquiro.models.entity.Producto;

public interface IProductoDao extends JpaRepository<Producto, Long>{ 

	// el filtro de producto, al generar factura
	@Query("select p from Producto p where p.nombre like %?1%")
	public List<Producto> findByNombre(String term);
	
	public List<Producto> findByNombreLikeIgnoreCase(String term);
}
