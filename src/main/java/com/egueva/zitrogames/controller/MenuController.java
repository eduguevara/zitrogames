package com.egueva.zitrogames.controller;

import java.io.FileWriter;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.egueva.zitrogames.model.Configuration;
import com.egueva.zitrogames.model.Game;
import com.egueva.zitrogames.model.Player;
import com.egueva.zitrogames.model.Rule;
import com.egueva.zitrogames.service.GenerateConfiguration;
import com.egueva.zitrogames.service.GenerateGame;
import com.egueva.zitrogames.service.GeneratePlayer;
import com.egueva.zitrogames.serviceImpl.GenerateRule;

@Service
@RequestMapping("/menu")
@RestController
public class MenuController implements CommandLineRunner {

	@Autowired
	private GeneratePlayer generatePlayer;

	@Autowired
	private GenerateGame generateGame;

	@Autowired
	private GenerateConfiguration generateConfiguration;

	@Autowired
	private GenerateRule generateRule;

	@Override
	public void run(String... args) throws Exception {

		// Inicializamos
		Player jugador = generatePlayer.Generador();
		Rule reglas = generateRule.Generador();
		Game juego = generateGame.Generador();
		Configuration conf = generateConfiguration.Generador(juego.getNombre(), reglas);

		// Cogemos los doubles generados aleatoriamente y los dejamos a dos decimales
		double premio = Math.round(reglas.getPremio() * 100) / 100d;

		// Mostramos un jugador al azar
		ElegirJugador(jugador);

		// Mostramos un Juego al Azar
		ElegirGame(juego, reglas);

		// Realizamos una apuesta
		Apuesta(reglas.getMin(), reglas.getMax(), jugador.getBalance(), premio, conf.getProbabilidad(), jugador.getId(),
				juego.getNombre());

	}

	// Seleccionamos un juego al Azar
	public void ElegirGame(Game juego, Rule regla) {

		// Cogemos el double generado de la y lo acortamos a dos decimales
		double premio = Math.round(regla.getPremio() * 100) / 100d;

		System.out.println("#### " + juego.getNombre() + " ####\n" + "\nINSTRUCCIONES: ");

		System.out.println("################################" + "\n-La apuesta mínima es de: " + regla.getMin() + "€"
				+ "\n-La apuesta máxima es de: " + regla.getMax() + "€" + "\n-El premio es de: " + premio
				+ "€ por € apostado\n" + "################################\n" + "\n¡¡¡EMPECEMOS!!!\n");

	}

	// Seleccionamos un jugador al Azar
	public void ElegirJugador(Player jugador) {

		System.out.println("################################" + "\nMuy Buenas " + jugador.getId()
				+ "!\n-Tu saldo disponible es de: " + jugador.getBalance() + "€\n-Tu casa de apuesta es: "
				+ jugador.getProveedor() + "\n################################" + "\n\n**BIENVENIDO A**\n");

	}

	// Este método agrupa toda la lógica de la apuesta
	public void Apuesta(int min, int max, double saldo, double premio, boolean resultado, String nombre, String juego)
			throws IOException {

		// Cogemos el double generado de la y lo acortamos a dos decimales
		FileWriter fichero = new FileWriter("C:/Users/USUARIO/Desktop/zitrogames/Transacciones/transanción.txt");

		// Iniciamos el total
		double total = 0;

		do {

			int apuesta = (int) (Math.random() * (max - min + 1) + min);
			resultado = probabilidad();
			esperar(5);

			if (apuesta < max && saldo > apuesta) {

				System.out.println("----------------------------------\n" + "Su apuesta es de: " + apuesta + "€\n");

				if (resultado == true) {

					saldo = (apuesta * premio) + saldo;
					System.out.println("\n##¡Enhorabuena! Ha ganado## " + (apuesta * premio) + "€\n" + "Saldo: " + saldo
							+ " €\n" + "----------------------------------\n");
					fichero.write("\nTransacción: " + nombre + " GANANCIA: " + (apuesta * premio) + "€" + " JUEGO: "
							+ juego + " SALDO: " + saldo + "€\n");

				} else {

					total = saldo - apuesta;
					System.out.println("\n##OHHhhhh! Ha perdido## -" + apuesta + "€\n" + "Saldo: " + total + " €\n"
							+ "----------------------------------\n");
					fichero.write("\nTransacción: " + nombre + " PERDIDA: " + apuesta + "€" + " JUEGO: " + juego
							+ " SALDO: " + total + "€\n");
					saldo = total;

				}

			} /*
				 * else {
				 * 
				 * System.out.println("su apuesta " + apuesta + " debe ser menor que: " + max +
				 * " el máximo permitido\n"); }
				 */
		} while (saldo > min);

		// Cerramos el fichero
		fichero.close();

		System.out.println("\nNo puede seguir jugando, no dispone del saldo suficiente\n Saldo: " + saldo + "€\n");

		// Hacemos una parada de 5 min.
		esperar(5);

		// Cerramos la ejecución
		System.exit(0);

	}

	// Realizamos paradas para seguir mejor la ejecución
	public static void esperar(int segundos) {

		try {

			Thread.sleep(segundos * 1000);

		} catch (Exception e) {

			System.out.println(e);

		}
	}

	// Calculas la probabilida del juego
	public Boolean probabilidad() {

		Boolean resultado;

		int numero = (int) (Math.random() * 6 + 1);

		if (numero < 2) {

			resultado = true;

			return resultado;

		} else {

			resultado = false;

			return resultado;
		}
	}
}
