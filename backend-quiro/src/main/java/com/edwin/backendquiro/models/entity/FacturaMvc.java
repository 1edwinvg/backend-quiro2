package com.edwin.backendquiro.models.entity;

import java.util.List;

public class FacturaMvc {

	private String descripcion;

	private String observacion;

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	private List<ItemFacturaMvc> items;

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
