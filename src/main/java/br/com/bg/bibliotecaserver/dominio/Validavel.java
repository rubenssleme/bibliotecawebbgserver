package br.com.bg.bibliotecaserver.dominio;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Transient;

public abstract class Validavel {
	@Transient
	protected boolean validado;
	@Transient
	protected Set<String>erros;

	protected Validavel() {
		validado = true;
		erros = new LinkedHashSet<>(); 
	}

	public boolean validado() {
		return validado;
	}

	public List<String> obeterErros(){
		return new ArrayList<>(erros);
	}

	public String obterDescricaoErros() {
		String textoErros = "";
		for (String erro : erros) {
			textoErros += erro + "\n";
		}
		return textoErros;
	}
	
	public int obterNumeroErros() {
		return erros.size();
	}
	
	public void adicionarErros(String erro) {
		erros.add(erro);
		marcarComoInvalido();
	}
	protected void adicionarErro(List<String> erros) {
		this.erros.addAll(erros);
		marcarComoInvalido();
	}

	private void marcarComoInvalido() {
		validado = false;
	}
}
