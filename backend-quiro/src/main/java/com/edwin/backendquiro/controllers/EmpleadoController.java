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

import com.edwin.backendquiro.models.entity.Empleado;
import com.edwin.backendquiro.models.service.IEmpleadoService;

@CrossOrigin(origins = "http://localhost:4200" )
@RestController
@RequestMapping("/api")
public class EmpleadoController {
	
	@Autowired
	private IEmpleadoService empleadoService;
	
	@GetMapping("/empleados")
	public List<Empleado> index() {
		return empleadoService.findAll();
	}
	@GetMapping("/empleados/{id}")
	public Empleado show(@PathVariable Long id) {
		return this.empleadoService.findById(id);
	}
	
	@PostMapping("/empleados/create")
	@ResponseStatus(HttpStatus.CREATED)
	public Empleado create(@RequestBody Empleado Usuario) {
		Usuario.setCreateAt(new Date());
		return empleadoService.save(Usuario);
	}
	
	@PutMapping("/empleados/update/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Empleado update(@RequestBody Empleado empleado, @PathVariable Long id) {
		Empleado currentUsuario = this.empleadoService.findById(id);
		currentUsuario.setNombre(empleado.getNombre());
		currentUsuario.setApellido(empleado.getApellido());
		currentUsuario.setEmail(empleado.getEmail());
		currentUsuario.setTelefono(empleado.getTelefono());
		currentUsuario.setTipoEmpleado(empleado.getTipoEmpleado());
		this.empleadoService.save(currentUsuario);
		return currentUsuario;
	}
	@DeleteMapping("/empleados/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		Empleado currentUsuario = this.empleadoService.findById(id);
		this.empleadoService.delete(currentUsuario);
	}

}
