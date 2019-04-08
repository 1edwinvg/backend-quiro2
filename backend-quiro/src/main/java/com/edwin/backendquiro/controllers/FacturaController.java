package com.edwin.backendquiro.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
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

import com.edwin.backendquiro.models.dao.IFacturaDao;
import com.edwin.backendquiro.models.dao.IItemFacturaDao;
import com.edwin.backendquiro.models.dao.IProductoDao;
import com.edwin.backendquiro.models.entity.Cliente;
import com.edwin.backendquiro.models.entity.Factura;
import com.edwin.backendquiro.models.entity.FacturaMvc;
import com.edwin.backendquiro.models.entity.ItemFactura;
import com.edwin.backendquiro.models.entity.ItemFacturaMvc;
import com.edwin.backendquiro.models.entity.Producto;
import com.edwin.backendquiro.models.service.ClienteServiceImple;

import ch.qos.logback.classic.Logger;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class FacturaController {

	
	@Autowired
	private IFacturaDao facturaDao;

	@Autowired
	private ClienteServiceImple clienteService;

	@Autowired
	private IItemFacturaDao itemFacturaDao;

	@Autowired
	private IProductoDao productoDao;

	
	@GetMapping(value = "/facturas")
	public List<Factura> listaFacturas() {
		return this.facturaDao.findAll();
	}

	
	@GetMapping(value = "/unafacturas/{id}")
	public Factura buscarFacturaUnitaria(@PathVariable Long id) {
		return this.facturaDao.findById(id).get();
	}

	@GetMapping("/facturas/{id}")
	public Factura buscarUnaFactura(@PathVariable Long id) {
		Factura factura = this.clienteService.fetchFacturaByIdWithClienteWhithItemFacturaWithProducto(id);
		return factura;
	}

	/*
	 * necesitamos asignar a un cliente una factura. Lo identificamos por el id de
	 * la url
	 */
	@PostMapping("/facturas/create/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Factura create(@RequestBody FacturaMvc facturaMvc, @PathVariable Long id) {
		Factura factura = new Factura();
		// busca el cliente al que vamos a asignar la factura
		Cliente cliente = this.clienteService.findById(id);
		factura.setDescripcion(facturaMvc.getDescripcion());
		factura.setObservacion(facturaMvc.getObservacion());
		factura.setCliente(cliente);
		factura.setCreateAt(new Date());
		// insertamos y tenemos el objeto de nuevo
		factura = this.facturaDao.save(factura);

		List<ItemFactura> itemFacturas = new ArrayList();
		for (ItemFacturaMvc ifm : facturaMvc.getItems()) {
			ItemFactura itemFactura = new ItemFactura();
			itemFactura.setFactura(factura);
			itemFactura.setCantidad(ifm.getCantidad());
			itemFactura.setProducto(productoDao.findById(ifm.getIdProducto()).get());
			itemFacturas.add(itemFactura);
		}
		// saveAll guarda una lista
		factura.setItems(itemFacturaDao.saveAll(itemFacturas));
		
		return factura;
	}

	/**
	 * ACTUALIZA SOLO LOS DATOS DE UNA FACTURA, NO LOS ITEMS
	 * se necesita el id de la factura
	 * 
	 * @param facturaFormulario
	 * @param id
	 * @return
	 */
	@PutMapping("/facturas/update/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Factura updateFactura(@RequestBody Factura facturaFormulario, @PathVariable Long id) {
		// busca la factura a modificar
		Factura factura = this.facturaDao.findById(id).get();
		// modificamos
		factura.setDescripcion(facturaFormulario.getDescripcion());
		factura.setObservacion(facturaFormulario.getObservacion());
		// si queremos cambiar el propietario de la factura tambien se puede, solo
		// necesitamos el id
		return this.facturaDao.save(factura);
	}

	/**
	 * MODIFICA UN ITEM EN CONCRETO -- FALTA ELIMINAR UNO
	 * necesitamos el id de la factura se modifica solo la cantidad nota: el delete
	 * sera por el id del item
	 * 
	 * @param facturaFormulario
	 * @param id
	 * @return itemFactura de una factura existente
	 */
	@PutMapping("/facturas/update-item/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ItemFactura updateItemFactura(@RequestBody ItemFactura itemFormulario, @PathVariable Long id) {
		// busca la factura a modificar
		ItemFactura itemFactura = this.itemFacturaDao.findById(id).get();
		itemFactura.setCantidad(itemFormulario.getCantidad());
		// si queremos cambiar el propietario de la factura tambien se puede, solo
		// necesitamos el id del cliente, esto podria suceder en caso de fallo del
		// usuario, al asignar la factura a la persona equivocada
		return this.itemFacturaDao.save(itemFactura);
	}
	/**
	 * FUNCIONA
	 * borra los items de una factura y luego la factura en si
	 * @param id
	 */
	@DeleteMapping("/facturas/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		// primero borramos las listas de items pertenecientes a la factura, luego la factura en si
		Factura factura = this.facturaDao.findById(id).get();
		this.facturaDao.delete(factura);
	}
	
	/**
	 * FUNCIONA
	 * borra los items de una factura y luego la factura en si
	 * @param id del item a borrar
	 */
	@DeleteMapping("/facturas-item/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteItem(@PathVariable Long id) {
		// primero borramos las listas de items pertenecientes a la factura, luego la factura en si
		ItemFactura itemFactura = this.itemFacturaDao.findById(id).get();
		this.itemFacturaDao.delete(itemFactura);

	}
}
