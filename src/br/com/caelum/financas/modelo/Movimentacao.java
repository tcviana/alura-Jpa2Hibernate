package br.com.caelum.financas.modelo;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Movimentacao {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter @Setter
	private Integer Id;
	@Getter @Setter
	private BigDecimal valor;
	@Getter @Setter
	@Enumerated(EnumType.STRING)
	private TipoMovimentacao tipoMovimentacao = TipoMovimentacao.CREDITO;
	@Temporal(TemporalType.TIMESTAMP)
	@Getter @Setter
	private Calendar data;
	@Getter @Setter
	private String descricao;
	@Getter @Setter
	@ManyToOne
	private Conta conta;
	@Getter @Setter
	@ManyToMany
	private List<Categoria> categoria;

}
