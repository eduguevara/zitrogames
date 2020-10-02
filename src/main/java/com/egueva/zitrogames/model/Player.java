package com.egueva.zitrogames.model;

import java.io.Serializable;

public class Player implements Serializable {
	private static final long serialVersionUID = 1453L;

	private String id;
	private double balance;
	private double tiempo;
	private String proveedor;

	public Player() {

	}

	public Player(String id, double balance, double tiempo, String proveedor) {
		super();
		this.id = id;
		this.balance = balance;
		this.tiempo = tiempo;
		this.proveedor = proveedor;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getTiempo() {
		return tiempo;
	}

	public void setTiempo(double tiempo) {
		this.tiempo = tiempo;
	}

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", balance=" + balance + ", tiempo=" + tiempo + ", proveedor=" + proveedor + "]";
	}

}
