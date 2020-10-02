package com.egueva.zitrogames.service;

import com.egueva.zitrogames.model.Configuration;
import com.egueva.zitrogames.model.Rule;

public interface GenerateConfiguration {

	public Configuration Generador(String juego, Rule regla);

}
