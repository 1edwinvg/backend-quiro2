package com.edwin.backendquiro.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/productos")
	public List<Producto> index() {

		List<Producto> lista = new ArrayList<>();
		for (Producto temp_producto : this.productoService.findAll()) {
			if (temp_producto.getExiste()) {
				lista.add(temp_producto);
			}
		}
		logger.info("la lista tiene " + lista.size() + " elementos.");
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

	@PostMapping("/productos/create")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto create(@RequestBody Producto producto) {
		// throws ConstraintViolationException
		// asigna una lista a la lista que busca el nombre de un producto
		List<Producto> lista = this.productoService.findByNombre(producto.getNombre());
		// recogemos el nombre del requestBody
		logger.info("\nEL METODO lista llena o no DEVUELVE : " + existeMismoNombre(producto.getNombre()));

		// LISTA LLENA, busqueda por el nombre del producto
		if (existeMismoNombre(producto.getNombre())) {
			// si el nombre introducido esta repetido y es FALSE
			if (!lista.get(0).getExiste()) {
				// asignamos el elemento de la lista
				producto = this.productoService.findById(lista.get(0).getId());
				logger.info("\nENTRA EN EXISTE Y ES FALSE, SETEA A TRUE");
				// lo activamos de nuevo
				producto.setPrecio(producto.getPrecio());
				producto.setExiste(true);
				// RECOGEMOS LA EXCEPCION EN EL CAMPO error DEL JSON DE LA PETICION
				logger.info("\nTenemos " + lista.size() + " elementos en la lista.Nombre: " + lista.get(0).getNombre()
						+ ". ID: " + lista.get(0).getId());

			} else {
				producto.setNombre(producto.getNombre());
				// asignamos nombre de la peticion del front para que guarde y arroje el error
				// ConstraintViolationException, si no, inserta prod todo a null
				// prod.setNombre(producto.getNombre());
				logger.info("\nENTRA EN LA EXCEPCION ConstraintViolationException POR DUPLICADO DE CAMPO UNIQUE");
			}

			// SI LA LISTA NO ESTA LLENA, insertamos normal
		} else {
			logger.info("\nLA LISTA DE NOMBRES NO ESTA LLENA");
			producto.setCreateAt(new Date());
			producto.setExiste(true);
		}
		// DEVOLVEMOS EL PRODUCTO
		return this.productoService.save(producto);
	}

//	@PostMapping("/productos/create")
//	@ResponseStatus(HttpStatus.CREATED)
//	public Producto create(@RequestBody Producto producto) {
//		// throws ConstraintViolationException{
//		List<Producto> lista = this.productoService.findByNombre(producto.getNombre());
//		// recogemos el nombre del requestBody
//		System.out.println("\nEL METODO DEVUELVE : " + existeMismoNombre(producto.getNombre(), producto));
//		if (existeMismoNombre(producto.getNombre(), producto)) {
//
//			System.out.println("\nTenemos " + lista.size() + " elementos en la lista.Nombre: " + lista.get(0).getNombre()
//					+ ". ID: " + lista.get(0).getId());
//		} else {
//			System.out.println("\nENTRA EN EL ELSE");
//			producto.setExiste(true);
//			producto.setCreateAt(new Date());
//
//		}
//		return this.productoService.save(producto);
//	}

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

	public boolean existeMismoNombre(String nombre) {

		List<Producto> lista = this.productoService.findByNombre(nombre);
		// inserta o actualiza a true
		if (!lista.isEmpty()) {
			logger.info("\nTenemos " + lista.size() + " elementos en la lista.Nombre: " + lista.get(0).getNombre()
					+ ". ID: " + lista.get(0).getId());
			return true;
		}
		// si no hay nada en la lista es que el nombre no existe en bdd
		return false;
	}
}
