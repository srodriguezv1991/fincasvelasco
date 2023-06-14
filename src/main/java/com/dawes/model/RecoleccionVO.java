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
@Table(name = "recolecciones")
public class RecoleccionVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idrecoleccion;

	private LocalDate fecharecoleccion;
	private float kilosrecogidos;
	@ManyToOne
	@JoinColumn(name = "idvariedad")
	private VariedadVO variedad;
	@ManyToOne
	@JoinColumn(name = "idfinca")
	private FincaVO finca;

	public RecoleccionVO() {
	}

	public RecoleccionVO(int idrecoleccion, LocalDate fecharecoleccion, float kilosrecogidos, VariedadVO variedad,
			FincaVO finca) {
		super();
		this.idrecoleccion = idrecoleccion;
		this.fecharecoleccion = fecharecoleccion;
		this.kilosrecogidos = kilosrecogidos;
		this.variedad = variedad;
		this.finca = finca;
	}

	public int getIdrecoleccion() {
		return idrecoleccion;
	}

	public void setIdrecoleccion(int idrecoleccion) {
		this.idrecoleccion = idrecoleccion;
	}

	public LocalDate getFecharecoleccion() {
		return fecharecoleccion;
	}

	public void setFecharecoleccion(LocalDate fecharecoleccion) {
		this.fecharecoleccion = fecharecoleccion;
	}

	public float getKilosrecogidos() {
		return kilosrecogidos;
	}

	public void setKilosrecogidos(float kilosrecogidos) {
		this.kilosrecogidos = kilosrecogidos;
	}

	public VariedadVO getVariedad() {
		return variedad;
	}

	public void setVariedad(VariedadVO variedad) {
		this.variedad = variedad;
	}

	public FincaVO getFinca() {
		return finca;
	}

	public void setFinca(FincaVO finca) {
		this.finca = finca;
	}

}
