package br.com.bg.bibliotecaserver.dominio;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "usuario")
public class Usuario extends Validavel{
	public static final String SEQUENCIA = "usuario_id_seq";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name= "nome_usuario", length = TamanhoMaximoGenerico.NOME)
	private String  nome;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_cadastro", nullable = false)
	private Calendar dataCadastro;
	
	
	

}
