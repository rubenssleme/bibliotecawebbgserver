package br.com.bg.bibliotecaserver;



import javax.annotation.PostConstruct;
import javax.inject.Inject;
import org.apache.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import br.com.bg.bibliotecaserver.utilitarios.Configuracao;
import br.com.bg.bibliotecaserver.utilitarios.Registro;


@SpringBootApplication
@ImportResource("classpath:applicationContext.xml")
public class AplicacaoBibliotecaServer implements CommandLineRunner{
	private static final Logger logger = Logger.getLogger(AplicacaoBibliotecaServer.class);
	
	public static void main(String[] args) {
	new SpringApplication(AplicacaoBibliotecaServer.class).run(args);
	}
	
	@Inject
	ApplicationContext contexto;

	@PostConstruct
	public void inicializar() {
	Registro.setContexto(contexto);
	}

	@Override
	public void run(String... args) throws Exception {
		Registro.inicializarContexto();
		Registro.inicializarCaches();
		new Configuracao().atualizarRelatoriosEImagens();
		logger.warn("Serviço do Biblioteca iniciado.");
	}

}
