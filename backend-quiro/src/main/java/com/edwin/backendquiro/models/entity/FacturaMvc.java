package com.edwin.backendquiro.models.entity;

import java.util.List;

public class FacturaMvc {
	
	private Long idCliente;

	private String descripcion;

	private String observacion;

	private List<ItemFacturaMvc> items;
	
	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}


	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<ItemFacturaMvc> getItems() {
		return items;
	}

	public void setItems(List<ItemFacturaMvc> items) {
		this.items = items;
	}

}
