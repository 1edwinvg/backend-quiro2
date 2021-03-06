package com.edwin.backendquiro.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.edwin.backendquiro.models.entity.Empleado;

@CrossOrigin(origins = "http://localhost:4200" )
public interface IEmpleadoDao extends JpaRepository<Empleado,Long>{ 

}
