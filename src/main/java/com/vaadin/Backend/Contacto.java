package com.vaadin.Backend;

import java.io.Serializable;

public class Contacto implements Serializable, Cloneable {

	private Long id;
	private String nombre;
	private String apellidos;
	private String empresa;
	private String email;
	private String telefonoContacto;
	private String direccion;

	public Contacto() {
		this.id = new Long(-1);
		this.nombre = "";
		this.apellidos = "";
		this.empresa = "";
		this.email = "";
		this.telefonoContacto = "";
		this.direccion = "";
	}

	public Contacto(Long id, String nombre, String apellidos, String empresa, String email, String telefonoContacto,
			String direccion) {
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.empresa = empresa;
		this.email = email;
		this.telefonoContacto = telefonoContacto;
		this.direccion = direccion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contacto other = (Contacto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
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

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefonoContacto() {
		return telefonoContacto;
	}

	public void setTelefonoContacto(String telefonoContacto) {
		this.telefonoContacto = telefonoContacto;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public Contacto clone() {
		try {
			return (Contacto) super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}

	@Override
	public String toString() {
		return "Contacto [nombre=" + nombre + ", apellidos=" + apellidos + ", empresa=" + empresa + ", email=" + email
				+ ", telefonoContacto=" + telefonoContacto + ", direccion=" + direccion + "]";
	}
	
	

}
