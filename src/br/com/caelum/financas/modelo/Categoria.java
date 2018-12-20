package br.com.caelum.financas.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity 
public class Categoria {
	
	@Deprecated
	public Categoria() {
	}
	
	public Categoria(String nome) {
		super();
		this.nome = nome;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter @Setter
	private Integer Id;
	@Getter @Setter
	private String nome;
}
