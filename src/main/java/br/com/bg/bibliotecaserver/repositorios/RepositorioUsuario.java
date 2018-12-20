package br.com.bg.bibliotecaserver.repositorios;

import br.com.bg.bibliotecaserver.dominio.Usuario;

public interface RepositorioUsuario {

	Usuario salvar(Usuario usuario);
	Usuario obterPorId(Long id);
	
}
