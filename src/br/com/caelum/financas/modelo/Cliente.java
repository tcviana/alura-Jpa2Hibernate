package br.com.caelum.financas.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter @Setter
	private Integer Id;
	@Getter @Setter
	private String nome;
	@Getter @Setter
	private String profissao;
	@Getter @Setter
	private String endereco;
	@Getter @Setter
	@OneToOne
	@JoinColumn(unique=true)
	private Conta conta;
	
}
