package com.edwin.backendquiro.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edwin.backendquiro.models.dao.IProductoDao;
import com.edwin.backendquiro.models.entity.Producto;

@Service
public class ProductoServiceImple implements IProductoService {
	
	@Autowired
	private IProductoDao productoDao;
	
	@Override
	public List<Producto> findAll() {
		
		return (List<Producto>) productoDao.findAll() ;
	}

	@Override
	public Producto save(Producto form) {
		return productoDao.save(form);
	}

	@Override
	public Producto findById(Long id) {
		return productoDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Producto producto) {
		productoDao.delete(producto);
		
	}

}
