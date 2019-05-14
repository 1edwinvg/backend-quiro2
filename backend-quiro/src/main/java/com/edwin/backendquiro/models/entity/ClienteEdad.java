package com.edwin.backendquiro.models.entity;

public class ClienteEdad {

	private String dni;
	private String nombre;
	private String apellido;
	private String email;
	private int edad;
	private int movil;
	
	private String dolencia;
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
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
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
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	
}
