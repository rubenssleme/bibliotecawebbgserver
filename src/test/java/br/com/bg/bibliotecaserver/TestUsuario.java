package br.com.bg.bibliotecaserver;

import org.junit.Test;

import br.com.bg.bibliotecaserver.dominio.Usuario;
import br.com.bg.bibliotecaserver.repositorios.RepositorioUsuario;
import br.com.bg.bibliotecaserver.repositorios.RepositorioUsuarioBD;
import br.com.bg.bibliotecaserver.utilitarios.Registro;

public class TestUsuario {

	
	
	@Test
    public void salvar() {
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNome("Rubens Leme2");
       //usuario.setDataCadastro(dataCadastro);
       // cliente.setDataNascimento(nascto);
        RepositorioUsuario repositorioUsuario = Registro.obterRepositorioUsuario();
        repositorioUsuario.salvar(usuario);
        
    }

}
