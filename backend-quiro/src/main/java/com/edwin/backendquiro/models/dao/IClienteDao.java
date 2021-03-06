package com.edwin.backendquiro.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.edwin.backendquiro.models.entity.Cliente;


@CrossOrigin(origins = "http://localhost:4200" )
public interface IClienteDao extends JpaRepository<Cliente, Long> {
	
	@Query("select c from Cliente c left join fetch c.facturas f where c.id=?1")
	public Cliente fetchByIdWithFacturas(Long id);
	
	@Query("select c from Cliente c where c.nombre=?1")
	public Cliente findByName(String nombre);
	
	
	
}
