package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TestaMovimentacao {
	public static void main(String[] args) {
		// cria conta
		Conta c1 = new Conta();
		c1.setAgencia("63975");
		c1.setBanco("Crefisa");
		c1.setNumero("80969875");
		c1.setTitular("Silvio Santos");
		
		// cria movimentações
		Movimentacao mov1 = new Movimentacao();
		Movimentacao mov2 = new Movimentacao();
		Movimentacao mov3 = new Movimentacao();
		
		mov1.setConta(c1);
		mov1.setData(Calendar.getInstance());
		mov1.setDescricao("Luz 12/2012");
		mov1.setTipoMovimentacao(TipoMovimentacao.DEBITO);
		mov1.setValor(new BigDecimal(99.85));
		
		mov2.setConta(c1);
		mov2.setData(Calendar.getInstance());
		mov2.setDescricao("Vendas Avon 12/2012");
		mov2.setTipoMovimentacao(TipoMovimentacao.CREDITO);
		mov2.setValor(new BigDecimal(225.15));
		
		mov3.setConta(c1);
		mov3.setData(Calendar.getInstance());
		mov3.setDescricao("Água 12/2012");
		mov3.setTipoMovimentacao(TipoMovimentacao.DEBITO);
		mov3.setValor(new BigDecimal(40.19));		
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		em.persist(c1);
		em.persist(mov1);
		em.persist(mov2);
		em.persist(mov3);
		em.getTransaction().commit();
		
		em.close();
	}
}
