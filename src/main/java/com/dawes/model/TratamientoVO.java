package com.dawes.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;


@Entity
@Table(name="tratamientos",uniqueConstraints = @UniqueConstraint (columnNames = "nombre"))
public class TratamientoVO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idtratamiento;
	private String nombre;
	@Column (length = 40) 
	private TipoTratamiento tipo;
	
	public TratamientoVO() {
		
	}
	
	public TratamientoVO(String nombre, TipoTratamiento tipo) {
		this.nombre=nombre;
		this.tipo=tipo;
	}

	public int getIdtratamiento() {
		return idtratamiento;
	}

	public void setIdtratamiento(int idtratamiento) {
		this.idtratamiento = idtratamiento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoTratamiento getTipo() {
		return tipo;
	}

	public void setTipo(TipoTratamiento tipo) {
		this.tipo = tipo;
	}
	
	
}
