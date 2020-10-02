package com.egueva.zitrogames.serviceImpl;

import org.springframework.stereotype.Service;

import com.egueva.zitrogames.model.Configuration;
import com.egueva.zitrogames.model.Rule;
import com.egueva.zitrogames.service.GenerateConfiguration;

@Service
public class GenerateConfigurationImpl implements GenerateConfiguration {

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

	@Override
	public Configuration Generador(String game, Rule regla) {

		// Generamos el Codigo de la configuracion
		int codigo = (int) (Math.random() * 1000);

		// Guardamos la probalidad
		boolean resultado = probabilidad();

		return new Configuration(codigo, game, regla, resultado);

	}

}
