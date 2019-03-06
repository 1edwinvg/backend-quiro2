package com.edwin.backendquiro.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edwin.backendquiro.models.entity.Usuario;

public interface IUsuarioDao extends JpaRepository<Usuario, Long>{

	public Usuario findByUsername(String username);


}
