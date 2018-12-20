package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Categoria;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TestaRelacionamentoMovimentacaoCategoria {
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		
		Categoria c1 = new Categoria("Café");
		Categoria c2 = new Categoria("Jantar");
		
		Movimentacao movimentacao = new Movimentacao();		
		movimentacao.setCategoria(Arrays.asList(c1,c2));
		movimentacao.setConta(em.find(Conta.class, 3));
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Viagem à São Paulo");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.CREDITO);
		movimentacao.setValor(new BigDecimal("354.77"));

		em.getTransaction().begin();
		// grava as categorias
		em.persist(c1);
		em.persist(c2);		
		// coloca as caterias em transação
		c1 = em.find(Categoria.class, c1.getId());
		c2 = em.find(Categoria.class, c2.getId());
		// grava a movimentação
		em.persist(movimentacao);
		em.getTransaction().commit();
		
		em.close();
	}
}
