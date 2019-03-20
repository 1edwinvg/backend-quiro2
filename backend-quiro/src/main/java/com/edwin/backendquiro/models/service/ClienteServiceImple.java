package com.edwin.backendquiro.models.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.edwin.backendquiro.models.dao.IClienteDao;
import com.edwin.backendquiro.models.entity.Cliente;
//import com.edwin.backendquiro.models.entity.Usuario;

public class ClienteServiceImple implements IClienteService {

	@Autowired
	private IClienteDao clienteDao;
	
//	@Autowired
//	private IUsuarioDao usuarioDao;
	
//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	
	public List<Cliente> findAll() {
		
		return (List<Cliente>) clienteDao.findAll() ;
	}

	@Override
	@Transactional
	public Cliente save(Cliente cliente) {
		
//		user.setEnabled(true);
//		user.setId(Usuario.getId());
//		user.setPassword(passwordEncoder.encode(Usuario.getPassword()));
//		List<Role> roles= new ArrayList<>();
//		roles.add(new Role(user.getId(),"ROLE_USER"));
//		user.setRoles(roles);
//		user.setUsername(Usuario.getNombre());
//		usuarioDao.save(user);
		return this.clienteDao.save(cliente);
	};
	

	@Override
	
	public Cliente findById(Long id) {

		return clienteDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Cliente Usuario) {
		clienteDao.delete(Usuario);
		
	}
}

	

