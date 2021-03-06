package com.edwin.backendquiro.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	private String nombre;

	@NotEmpty
	private String apellido;

	@NotEmpty
	@Email
	private String email;

	@NotNull
	private int movil;

	@NotEmpty
	private String dolencia;

	private String foto;

	private Boolean existeCliente;

	@Column(unique = true)
	private String dni;
	
	@NotNull
	@Column(name = "edad")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	// el siguiente es el formato que se espera
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date edad;
	
	@NotNull
	@Column(name = "create_at")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createAt;

//	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
//	@JsonManagedReference
//	private List<Factura> facturas;

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Factura> facturas;

	public Cliente() {
		facturas = new ArrayList<Factura>();
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Boolean getExisteCliente() {
		return existeCliente;
	}

	public void setExisteCliente(Boolean existeCliente) {
		this.existeCliente = existeCliente;
	}

	

	public List<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	

	public Date getEdad() {
		return edad;
	}

	public void setEdad(Date edad) {
		this.edad = edad;
	}

	public int getMovil() {
		return movil;
	}

	public void setMovil(int movil) {
		this.movil = movil;
	}

	public String getDolencia() {
		return dolencia;
	}

	public void setDolencia(String dolencia) {
		this.dolencia = dolencia;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	@Override
	public String toString() {
		return nombre + " " + apellido;
	}

}
