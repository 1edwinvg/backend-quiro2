package com.edwin.backendquiro.models.service;

import java.util.List;

import com.edwin.backendquiro.models.entity.Empleado;

public interface IEmpleadoService {

public List<Empleado> findAll();
	
	
	public Empleado save(Empleado form);
	
	public Empleado findById(Long id);
	
	public void delete(Empleado cliente);
}
