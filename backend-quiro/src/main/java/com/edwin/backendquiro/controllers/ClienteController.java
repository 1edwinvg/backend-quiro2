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

import com.edwin.backendquiro.models.entity.Cliente;
import com.edwin.backendquiro.models.service.IClienteService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ClienteController {

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

}
