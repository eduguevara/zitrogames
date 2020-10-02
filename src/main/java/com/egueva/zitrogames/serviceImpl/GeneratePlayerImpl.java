package com.egueva.zitrogames.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.egueva.zitrogames.model.Player;
import com.egueva.zitrogames.service.GeneratePlayer;

@Service
public class GeneratePlayerImpl implements GeneratePlayer {

	private static List<String> Nombres = new ArrayList<String>();
	private static List<String> Proveedores = new ArrayList<String>();

	static {

		// Carga de Nombres
		Nombres.add("CARLOS");
		Nombres.add("SOFIA");
		Nombres.add("ANA");

		// Carga de Proveedores
		Proveedores.add("BET365");
		Proveedores.add("BWIN");
		Proveedores.add("POKER STAR");

	}

	@Override
	public Player Generador() {

		// Generamos un número al azar del 0 al 2 para coger los datos de las dos listas
		int numero = (int) (Math.random() * 3);

		String nombre = Nombres.get(numero);
		String proveedor = Proveedores.get(numero);

		// Generamos el importe del que dispondrá para jugar
		int balance = (int) (Math.random() * (50 - 35 + 1) + 35);

		// Creamos al nuevo jugador con los datos generados
		return new Player(nombre, balance, 1.5, proveedor);
	}
}
