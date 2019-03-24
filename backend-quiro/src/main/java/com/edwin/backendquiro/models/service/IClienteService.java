package com.edwin.backendquiro.models.service;

import java.util.List;

import com.edwin.backendquiro.models.entity.Cliente;
import com.edwin.backendquiro.models.entity.Factura;
import com.edwin.backendquiro.models.entity.Producto;

public interface IClienteService {

	public List<Cliente> findAll();

	public Cliente save(Cliente cliente);

	public Cliente findById(Long id);

	public void delete(Cliente cliente);

	public Cliente findOne(Long id);

	public Cliente fetchByIdWithFacturas(Long id);

//	public void delete(Long id);

	public List<Producto> findByNombre(String term);

	public void saveFactura(Factura factura);

	public Producto findProductoById(Long id);

	public Factura findFacturaById(Long id);

	public boolean deleteFactura(Long id);

	public Factura bucarFacturaClienteItem(Long id);
}
