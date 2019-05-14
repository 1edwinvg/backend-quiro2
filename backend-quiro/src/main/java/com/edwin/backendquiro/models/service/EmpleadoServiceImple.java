package com.edwin.backendquiro.models.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.edwin.backendquiro.models.dao.IEmpleadoDao;
import com.edwin.backendquiro.security.repository.IUsuarioDao;
import com.edwin.backendquiro.models.entity.Empleado;
import com.edwin.backendquiro.models.entity.Role;
import com.edwin.backendquiro.models.entity.Usuario;

@Service
public class EmpleadoServiceImple implements IEmpleadoService{

	@Autowired
	private IEmpleadoDao empleadoDao;
	
//	@Autowired
//	private IUsuarioDao usuarioDao;
	
//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public List<Empleado> findAll() {
		
		return (List<Empleado>) empleadoDao.findAll() ;
	}

	@Override
	@Transactional
	public Empleado save(Empleado usuario) {
		Usuario user = new Usuario();
		Empleado Usuario = new Empleado();
		Usuario.setDni(usuario.getDni());
		Usuario.setApellido(usuario.getApellido());
		Usuario.setCreateAt(new Date());
		Usuario.setEmail(usuario.getEmail());
		Usuario.setNombre(usuario.getNombre());
		Usuario.setTelefono(usuario.getTelefono());
		Usuario.setTipoEmpleado(usuario.getTipoEmpleado());
		Usuario = empleadoDao.save(Usuario);
		
//		user.setEnabled(true);
//		user.setId(Usuario.getId());
//		user.setPassword(passwordEncoder.encode(Usuario.getPassword()));
//		List<Role> roles= new ArrayList<>();
//		roles.add(new Role(user.getId(),"ROLE_USER"));
//		user.setRoles(roles);
//		user.setUsername(Usuario.getNombre());
//		usuarioDao.save(user);
		return Usuario;
	}

	@Override
	
	public Empleado findById(Long id) {

		return empleadoDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Empleado Usuario) {
		empleadoDao.delete(Usuario);
		
	}
}
