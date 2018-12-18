package br.com.bg.bibliotecaserver.utilitarios;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import br.com.bg.bibliotecaserver.AplicacaoBibliotecaServer;


public class Registro {
	public static final String NOME_DATA_SOURCE_BIBLIOTECABG = "dataSourceBibliotecaBG";

	private static ApplicationContext contexto;

	public static ApplicationContext getContexto() {
		return contexto;
	}
	
	public static void inicializarCaches() {
		
	}

	public static void inicializarContexto() {
		if (contexto == null) {
			contexto = (ApplicationContext) new SpringApplication(AplicacaoBibliotecaServer.class).run();
		}
	}
	public static void setContexto(ApplicationContext contexto) {
		Registro.contexto = contexto;
	}
	public static void finalizarContexto() {
		((AbstractApplicationContext) contexto).close();
	}
}
