package com.dawes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="fincas")
public class FincaVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idfinca;
	//@Column(unique=true)
	private String nombre;
	private double superficie;
	
	public FincaVO(int idfinca, String nombre, double superficie) {
		super();
		this.idfinca = idfinca;
		this.nombre = nombre;
		this.superficie = superficie;
	}

	public FincaVO() {
		
	}

	public int getIdfinca() {
		return idfinca;
	}

	public void setIdfinca(int idfinca) {
		this.idfinca = idfinca;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getSuperficie() {
		return superficie;
	}

	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}

}
