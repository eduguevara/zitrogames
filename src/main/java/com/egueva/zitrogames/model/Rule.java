package com.egueva.zitrogames.model;

import java.io.Serializable;

public class Rule implements Serializable {
	private static final long serialVersionUID = 1453L;

	private double premio;
	private int min;
	private int max;

	public Rule() {

	}

	public Rule(double premio, int min, int max) {
		super();
		this.premio = premio;
		this.min = min;
		this.max = max;
	}

	public double getPremio() {
		return premio;
	}

	public void setPremio(double premio) {
		this.premio = premio;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	@Override
	public String toString() {
		return "Rules [premio=" + premio + ", min=" + min + ", max=" + max + "]";
	}

}
