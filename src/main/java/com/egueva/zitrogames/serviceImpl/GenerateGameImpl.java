package com.egueva.zitrogames.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.egueva.zitrogames.model.Game;
import com.egueva.zitrogames.service.GenerateGame;

@Service
public class GenerateGameImpl implements GenerateGame {

	private static List<String> Juegos = new ArrayList<String>();

	static {

		// Carga de JUEGOS
		// Juegos.add("0-SALIR");
		Juegos.add("VIDEOBINGO");
		Juegos.add("SLOT");
		Juegos.add("BLACKJACK");
		Juegos.add("POKER");
		Juegos.add("LA RULETA");

	}

	@Override
	public Game Generador() {
		int numero = (int) (Math.random() * Juegos.size());
		return new Game(Juegos.get(numero));
	}

}
