package com.dawes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;


@Entity
@Table(name = "variedades",uniqueConstraints = @UniqueConstraint(columnNames = "nombre"))
public class VariedadVO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idvariedad;
	private String nombre;
	
	
	public VariedadVO() {
	}


	public VariedadVO(int idvariedad, String nombre) {
		super();
		this.idvariedad = idvariedad;
		this.nombre = nombre;
	}


	public int getIdvariedad() {
		return idvariedad;
	}


	public void setIdvariedad(int idvariedad) {
		this.idvariedad = idvariedad;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
