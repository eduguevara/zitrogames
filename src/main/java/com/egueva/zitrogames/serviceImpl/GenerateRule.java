package com.egueva.zitrogames.serviceImpl;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.egueva.zitrogames.model.Rule;

@Service
public class GenerateRule {

	// Generamos las reglas del juego de manera aleatoria
	public Rule Generador() {

		Random rand = new Random();
		double valorMinimo = 1.1;
		double valorMaximo = 2.5;

		int min = (int) (Math.random() * (10 - 5 + 1) + 5);
		int max = (int) (Math.random() * (30 - 15 + 1) + 15);
		double premio = valorMinimo + (valorMaximo - valorMinimo) * rand.nextDouble();

		return new Rule(premio, min, max);
	}

}
