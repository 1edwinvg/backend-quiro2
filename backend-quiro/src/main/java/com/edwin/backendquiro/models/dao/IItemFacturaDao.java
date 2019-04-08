package com.edwin.backendquiro.models.dao;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edwin.backendquiro.models.entity.ItemFactura;



public interface IItemFacturaDao extends JpaRepository<ItemFactura,Long>{  

	@Transactional
	Long deleteByProductoId(Long id);
}
