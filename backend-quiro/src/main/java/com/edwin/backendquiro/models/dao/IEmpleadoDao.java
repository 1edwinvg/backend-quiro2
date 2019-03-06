package com.edwin.backendquiro.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.edwin.backendquiro.models.entity.Empleado;


public interface IEmpleadoDao extends JpaRepository<Empleado,Long>{ 

}
