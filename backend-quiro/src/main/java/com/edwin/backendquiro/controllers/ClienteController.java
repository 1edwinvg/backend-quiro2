package com.edwin.backendquiro.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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

import com.edwin.backendquiro.models.entity.Cliente;
import com.edwin.backendquiro.models.entity.ClienteEdad;
import com.edwin.backendquiro.models.service.IClienteService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ClienteController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IClienteService clienteService;

	@GetMapping("/clientes")
	public List<Cliente> index() {

		List<Cliente> listaClien = new ArrayList<Cliente>();

		for (Cliente cliente : clienteService.findAll()) {

			if (cliente.getExisteCliente()) {
				listaClien.add(cliente);
			}
		}
		return listaClien;
	}

	@GetMapping("/clientes/{id}")
	public Cliente show(@PathVariable Long id) {

		return this.clienteService.findById(id);
	}

	@PostMapping("/clientes/create")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente create(@RequestBody Cliente cliente) {

		cliente.setCreateAt(new Date());
		cliente.setExisteCliente(true);
		return clienteService.save(cliente);
	}

	@PutMapping("/clientes/update/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente update(@RequestBody Cliente cliente, @PathVariable Long id) {

		Cliente currentUsuario = this.clienteService.findById(id);

		currentUsuario.setNombre(cliente.getNombre());
		currentUsuario.setApellido(cliente.getApellido());
		currentUsuario.setEmail(cliente.getEmail());
		currentUsuario.setMovil(cliente.getMovil());
		currentUsuario.setEdad(cliente.getEdad());
		currentUsuario.setDolencia(cliente.getDolencia());

		this.clienteService.save(currentUsuario);

		return currentUsuario;
	}

	@PutMapping("/clientes/desactivarcliente/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public void activarCliente(@PathVariable Long id) {
		Cliente currentUsuario = this.clienteService.findById(id);
		currentUsuario.setExisteCliente(false);
		this.clienteService.save(currentUsuario);
	}

	@DeleteMapping("/clientes/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		Cliente currentUsuario = this.clienteService.findById(id);
		this.clienteService.delete(currentUsuario);
	}
	
	@GetMapping("/clientesdetalle/{id}")
	public ClienteEdad obtenerEdad(@PathVariable Long id, ClienteEdad clienteEdad, Cliente cliente) {

		cliente = this.clienteService.findById(id);
		clienteEdad.setDni(cliente.getDni());
		clienteEdad.setNombre(cliente.getNombre());
		clienteEdad.setApellido(cliente.getApellido());
		clienteEdad.setEmail(cliente.getEmail());
		clienteEdad.setMovil(cliente.getMovil());
		clienteEdad.setDolencia(cliente.getDolencia());
		// transforma tipo Date a String
		String date = new SimpleDateFormat("yyyy-MM-dd").format(cliente.getEdad());
		// seteamos la edad a partir de la funcion
		logger.info("\n FECHA STRING : " + date);
		clienteEdad.setEdad(this.calcularEdadCliente(date));
		return clienteEdad;
	}
	
	
	public int calcularEdadCliente(Calendar fechaNac) {
		Calendar fechaActual = Calendar.getInstance();

		// Cálculo de las diferencias.
		int anios = fechaActual.get(Calendar.YEAR) - fechaNac.get(Calendar.YEAR);
		int months = fechaActual.get(Calendar.MONTH) - fechaNac.get(Calendar.MONTH);
		int days = fechaActual.get(Calendar.DAY_OF_MONTH) - fechaNac.get(Calendar.DAY_OF_MONTH);

		// Si aun no ha sido su cumpleaños, hay que restar 1 o es el mes pero no ha
		// llegado el día.

		if (months < 0 || (months == 0 && days < 0)) {
			anios--;
		}
		return anios;
	}

	public int calcularEdadCliente(String fecha) {
		Calendar fechaActual = Calendar.getInstance();
		Calendar fechaNacimiento = Calendar.getInstance();
		// String date = new
		// SimpleDateFormat("yyyy/MM/dd").format(cliente.getCreateAt());
		String[] fechaArray = fecha.split("-");
		// solo para probar el split
		for (int i = 0; i < fechaArray.length; i++) {
			System.out.println((fechaArray[i]));
		}
		int anio = Integer.parseInt(fechaArray[0]);
		int mes = Integer.parseInt(fechaArray[1]);
		int dia = Integer.parseInt(fechaArray[2]);

		// asignamos valores a Calendar de acuerdo al formato que teniamos en le Entity
		// cliente.createAt
		fechaNacimiento.set(anio, mes, dia);
		// Cálculo de las diferencias.
		int years = fechaActual.get(Calendar.YEAR) - fechaNacimiento.get(Calendar.YEAR);
		int months = fechaActual.get(Calendar.MONTH) - fechaNacimiento.get(Calendar.MONTH);
		int days = fechaActual.get(Calendar.DAY_OF_MONTH) - fechaNacimiento.get(Calendar.DAY_OF_MONTH);

		// Si aun no ha sido su cumpleaños, hay que restar 1 o es el mes pero no ha
		// llegado el día.

		if (months < 0 || (months == 0 && days < 0)) {
			years--;
		}
		return years;
	}

}
