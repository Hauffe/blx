package com.brq.blx.services;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("api")
public class ApplicationConfig extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		final Set<Class<?>> classes = new HashSet<Class<?>>();

		classes.add(UsuarioRest.class);
		classes.add(AvaliacaoRest.class);
		classes.add(AnuncioRest.class);
		classes.add(CategoriaRest.class);
		classes.add(ChatRest.class);
		
		return classes;
	}
}
