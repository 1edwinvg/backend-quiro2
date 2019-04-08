package com.edwin.backendquiro.controllers;

import java.util.ArrayList;
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

import com.edwin.backendquiro.models.dao.IItemFacturaDao;
import com.edwin.backendquiro.models.entity.Producto;
import com.edwin.backendquiro.models.service.IClienteService;
import com.edwin.backendquiro.models.service.IProductoService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ProductoController {

	@Autowired
	private IProductoService productoService;

	@Autowired
	private IClienteService clienteService;

	@Autowired
	private IItemFacturaDao itemFacturaDao;

	@GetMapping("/productos")
	public List<Producto> index() {
		List<Producto> lista = new ArrayList<Producto>();
		for (Producto pro : productoService.findAll()) {
			if(pro.getExiste()) {
				lista.add(pro);
			}
		}
		return lista;
	}

	@GetMapping("/productos/{id}")
	public Producto show(@PathVariable Long id) {
		return this.productoService.findById(id);
	}

	@GetMapping("/cargar-productos/{term}")
	public List<Producto> cargarProductos(@PathVariable String term) {
		return clienteService.findByNombre(term);
	}
	//

	@PostMapping("/productos/create")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto create(@RequestBody Producto producto) {
		producto.setCreateAt(new Date());
		producto.setExiste(true);
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
		this.itemFacturaDao.deleteByProductoId(id);
		this.productoService.delete(currentProducto);

	}

	@PutMapping("/productos/desactivarPro/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public void activarDesactivarProducto(@PathVariable Long id) {
		Producto currentProducto = this.productoService.findById(id);
		currentProducto.setExiste(false);
		this.productoService.save(currentProducto);
		

	}
}
