package com.egueva.zitrogames.model;

import java.io.Serializable;

public class Game implements Serializable {
	private static final long serialVersionUID = 1453L;

	private String nombre;

	public Game() {
		// TODO Auto-generated constructor stub
	}

	public Game(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Game [nombre=" + nombre + "]";
	}

}
