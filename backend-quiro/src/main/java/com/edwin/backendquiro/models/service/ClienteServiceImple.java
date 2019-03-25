package com.edwin.backendquiro.models.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edwin.backendquiro.models.dao.IClienteDao;
import com.edwin.backendquiro.models.dao.IFacturaDao;
import com.edwin.backendquiro.models.dao.IProductoDao;
import com.edwin.backendquiro.models.entity.Cliente;
//import com.edwin.backendquiro.models.entity.Usuario;
import com.edwin.backendquiro.models.entity.Factura;
import com.edwin.backendquiro.models.entity.Producto;
import com.edwin.backendquiro.models.entity.Cliente;

@Service
public class ClienteServiceImple implements IClienteService {

	@Autowired
	private IClienteDao clienteDao;
	
	@Autowired
	private IProductoDao productoDao;
	
	@Autowired
	private IFacturaDao facturaDao;

//	@Autowired
//	private IUsuarioDao usuarioDao;

//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public List<Cliente> findAll() {
		return (List<Cliente>) clienteDao.findAll();
	}

	@Override
	@Transactional
	public Cliente save(Cliente clienteForm) {

//		Usuario user = new Usuario();

		Cliente cliente = new Cliente();
		cliente.setNombre(clienteForm.getNombre());
		cliente.setApellido(clienteForm.getApellido());
		cliente.setEdad(clienteForm.getEdad());
		cliente.setEmail(clienteForm.getEmail());
		cliente.setMovil(clienteForm.getMovil());
		// fecha actual
		cliente.setCreateAt(new Date());
		return this.clienteDao.save(clienteForm);
	};

	@Override
	public Cliente findById(Long id) {
		return clienteDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Cliente Usuario) {
		clienteDao.delete(Usuario);
	}

	@Override
	public Cliente findOne(Long id) {
		return clienteDao.findById(id).orElse(null);
	}

	@Override
	public Cliente fetchByIdWithFacturas(Long id) {
		return clienteDao.fetchByIdWithFacturas(id);
	}

	@Override
	public List<Producto> findByNombre(String term) {
		return productoDao.findByNombreLikeIgnoreCase("%"+term+"%");
	}

	@Override
	public void saveFactura(Factura factura) {
		facturaDao.save(factura);
	}

	@Override
	public Producto findProductoById(Long id) {
		return productoDao.findById(id).orElse(null);
	}


	@Override
	public Factura findFacturaById(Long id) {
		return facturaDao.findById(id).orElse(null);
	}

	@Override
	public boolean deleteFactura(Long id) {
		facturaDao.deleteById(id);
		return facturaDao.existsById(id);
	}


	@Override
	public Factura bucarFacturaItem(Long id) {
		return facturaDao.bucarFacturaClienteItem(id);
	}
	

}
