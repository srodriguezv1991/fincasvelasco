package com.dawes.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "tratamientosarboles")
public class TratamientoArbolVO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idtratamientoarbol;
	
	private LocalDate fechatratamiento;
	@ManyToOne
	@JoinColumn(name = "idarbol")
	private ArbolVO arbol;
	@ManyToOne
	@JoinColumn(name = "idtratamiento")
	private TratamientoVO tratamiento;
	
	
	public TratamientoArbolVO() {
		
	}


	public TratamientoArbolVO(int idtratamientoarbol, LocalDate fechatratamiento, ArbolVO arbol,
			TratamientoVO tratamiento) {
		super();
		this.idtratamientoarbol = idtratamientoarbol;
		this.fechatratamiento = fechatratamiento;
		this.arbol = arbol;
		this.tratamiento = tratamiento;
	}


	public int getIdtratamientoarbol() {
		return idtratamientoarbol;
	}


	public void setIdtratamientoarbol(int idtratamientoarbol) {
		this.idtratamientoarbol = idtratamientoarbol;
	}


	public LocalDate getFechatratamiento() {
		return fechatratamiento;
	}


	public void setFechatratamiento(LocalDate fechatratamiento) {
		this.fechatratamiento = fechatratamiento;
	}


	public ArbolVO getArbol() {
		return arbol;
	}


	public void setArbol(ArbolVO arbol) {
		this.arbol = arbol;
	}


	public TratamientoVO getTratamiento() {
		return tratamiento;
	}


	public void setTratamiento(TratamientoVO tratamiento) {
		this.tratamiento = tratamiento;
	}
	
	
}
