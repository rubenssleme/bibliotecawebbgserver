package br.com.bg.bibliotecaserver.repositorios;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

public abstract class RepositorioBD<DOMINIO> {

	protected final Logger logger;
	@PersistenceContext	
	protected EntityManager em;	

	
	public RepositorioBD() {
		this.logger = Logger.getLogger(getClass());
	}
	
	@SuppressWarnings("unchecked")
	private Class<DOMINIO> obterEntidade() {
		return ((Class<DOMINIO>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0]);
	}




}
