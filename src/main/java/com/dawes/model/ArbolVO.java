package com.dawes.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "arboles", uniqueConstraints = @UniqueConstraint(columnNames = { "columna", "fila", "idfinca" }))
public class ArbolVO {
// cambiar string por int fila columna
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idarbol;
	private int columna;
	private int fila;
	private EstadoArbol estado;
	@ManyToOne
	@JoinColumn(name = "idfinca")
	private FincaVO finca;
	@ManyToOne
	@JoinColumn(name = "idvariedad")
	private VariedadVO variedad;
	private LocalDate fechaplantacion;

	public ArbolVO() {

	}

	public ArbolVO(int idarbol, int columna, int fila, EstadoArbol estado, FincaVO finca, VariedadVO variedad,
			LocalDate fechaplantacion) {
		super();
		this.idarbol = idarbol;
		this.columna = columna;
		this.fila = fila;
		this.estado = estado;
		this.finca = finca;
		this.variedad = variedad;
		this.fechaplantacion = fechaplantacion;
	}

	public int getIdarbol() {
		return idarbol;
	}

	public void setIdarbol(int idarbol) {
		this.idarbol = idarbol;
	}

	public int getColumna() {
		return columna;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	}

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public EstadoArbol getEstado() {
		return estado;
	}

	public void setEstado(EstadoArbol estado) {
		this.estado = estado;
	}

	public FincaVO getFinca() {
		return finca;
	}

	public void setFinca(FincaVO finca) {
		this.finca = finca;
	}

	public VariedadVO getVariedad() {
		return variedad;
	}

	public void setVariedad(VariedadVO variedad) {
		this.variedad = variedad;
	}

	public LocalDate getFechaplantacion() {
		return fechaplantacion;
	}

	public void setFechaplantacion(LocalDate fechaplantacion) {
		this.fechaplantacion = fechaplantacion;
	}

	

}
