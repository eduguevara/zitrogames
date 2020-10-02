package com.egueva.zitrogames.model;

import java.io.Serializable;

public class Configuration implements Serializable {
	private static final long serialVersionUID = 1453L;

	private int id;
	private String tipo;
	private Rule instrucciones;
	private Boolean probabilidad;

	public Configuration() {
		// TODO Auto-generated constructor stub
	}

	public Configuration(int id, String tipo, Rule instrucciones, Boolean probabilidad) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.instrucciones = instrucciones;
		this.probabilidad = probabilidad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Rule getInstrucciones() {
		return instrucciones;
	}

	public void setApuesta(Rule instrucciones) {
		this.instrucciones = instrucciones;
	}

	public Boolean getProbabilidad() {
		return probabilidad;
	}

	public void setProbabilidad(Boolean probabilidad) {
		this.probabilidad = probabilidad;
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", tipo=" + tipo + ", apuesta=" + instrucciones + ", probabilidad=" + probabilidad
				+ "]";
	}

}
