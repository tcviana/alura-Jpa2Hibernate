package br.com.caelum.financas.modelo;

import java.math.BigDecimal;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

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
}
