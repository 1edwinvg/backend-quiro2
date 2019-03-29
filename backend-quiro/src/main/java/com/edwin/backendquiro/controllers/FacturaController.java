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

import com.edwin.backendquiro.models.dao.IFacturaDao;
import com.edwin.backendquiro.models.dao.IProductoDao;
import com.edwin.backendquiro.models.entity.Cliente;
import com.edwin.backendquiro.models.entity.Factura;
import com.edwin.backendquiro.models.entity.ItemFactura;
import com.edwin.backendquiro.models.entity.Producto;
import com.edwin.backendquiro.models.service.ClienteServiceImple;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class FacturaController {

	@Autowired
	private IFacturaDao facturaDao;
	
	@Autowired
	private ClienteServiceImple clienteService;

	@GetMapping("/facturas")
	public List<Factura> listaFacturas() {
		return this.facturaDao.findAll();
	}

	@GetMapping("/facturas/{id}")
	public Factura buscarUnaFactura(@PathVariable Long id) {
		Factura factura = this.clienteService.fetchFacturaByIdWithClienteWhithItemFacturaWithProducto(id);						
		return factura;
	}
	
//	@PostMapping("/facturas/create-item/{idFactura}")
//	@ResponseStatus(HttpStatus.CREATED)
//	public void createItem(@RequestBody ItemFactura itemFactura, @PathVariable Long idFactura ) {
//		
//		Factura factura = this.facturaDao.findById(idFactura).get();
//		factura.getItems().add(itemFactura);
//		this.facturaDao.save(factura);
//		
//	}
	
	@PostMapping("/facturas/create/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Factura create(@RequestBody Factura factura, @PathVariable Long id) {
		// busca el cliente al que vamos a asignar la factura
		Cliente cliente = this.clienteService.findById(id);
		// insertamos el cliente en el objeto cliente
		factura.setCliente(cliente);
		factura.setCreateAt(new Date());
		return this.facturaDao.save(factura);
	}
	
	@PutMapping("/facturas/update/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Factura updateFactura(@RequestBody Factura facturaFormulario, @PathVariable Long id) {
		// busca la factura a modificar
		Factura factura = this.facturaDao.findById(id).get();
		// modificamos
		factura.setDescripcion(facturaFormulario.getDescripcion());
		// si queremos cambiar el propietario de la factura tambien se puede, solo necesitamso el id
		// del cliente
		return this.facturaDao.save(factura);
	}
	
	@DeleteMapping("/facturas/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		Factura factura = this.facturaDao.findById(id).get();
		this.facturaDao.delete(factura);
	}



}
