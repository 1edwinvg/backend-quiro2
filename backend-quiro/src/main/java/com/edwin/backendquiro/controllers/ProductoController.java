package com.edwin.backendquiro.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.edwin.backendquiro.models.entity.Producto;
import com.edwin.backendquiro.models.service.IProductoService;


@CrossOrigin(origins = "http://localhost:4200" )
@RestController
@RequestMapping("/api")
public class ProductoController {

	@Autowired
	private IProductoService productoService ;
	
	@GetMapping("/productos")
	public List<Producto> index() {
		return productoService.findAll();
	}
	@GetMapping("/productos/{id}")
	public Producto show(@PathVariable Long id) {
		return this.productoService.findById(id);
	}
	
	@PostMapping("/productos/create")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto create(@RequestBody Producto producto) {
		producto.setCreateAt(new Date());
		return productoService.save(producto);
	}
	
	@PutMapping("/productos/update/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto update(@RequestBody Producto producto, @PathVariable Long id) {
		Producto currentproducto = this.productoService.findById(id);
		currentproducto.setNombre(producto.getNombre());
		currentproducto.setPrecio(producto.getPrecio());
		this.productoService.save(producto);
		return producto;
	}
	@DeleteMapping("/productos/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		Producto currentProducto = this.productoService.findById(id);
		this.productoService.delete(currentProducto);
	}

}


