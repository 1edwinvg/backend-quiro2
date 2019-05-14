package com.edwin.backendquiro.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.edwin.backendquiro.models.entity.Factura;

public interface IFacturaDao extends JpaRepository<Factura, Long> {

	@Query("select f from Factura f join fetch f.cliente c join fetch f.items l join fetch l.producto where f.id=?1")
	public Factura fetchByIdWithClienteWhithItemFacturaWithProducto(Long id);
	

	@Query(value="SELECT * FROM facturas where cliente_id = ?1",nativeQuery=true)
	public List<Factura> FacturaCliente(Long id);
}
