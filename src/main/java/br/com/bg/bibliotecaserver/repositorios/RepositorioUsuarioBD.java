package br.com.bg.bibliotecaserver.repositorios;

import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import br.com.bg.bibliotecaserver.dominio.Usuario;

@Repository
public class RepositorioUsuarioBD extends RepositorioBD<Usuario> implements RepositorioUsuario {

	@Transactional
	public synchronized Usuario salvar(Usuario usuario) {
		String acao;
		try {
			if(usuario.getId() == null) {
				em.persist(usuario);
				acao = "Inclusão";
			}else {
				em.merge(usuario);
				acao = "Alteração";
			}
			logger.info(acao + " do " + usuario.toString() + "realizada com sucesso.");
		}catch(Exception e) {
			logger.error("Ocorreu algum erro durante o armazenamento do " + usuario.toString() + 
					". \nDetalhe: " + e);
		}

		return usuario;
	}

	
	@Override
	public Usuario obterPorId(Long id) {
		return  null;
	}

}
