package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaBuscaConta {
  public static void main(String[] args) {
	EntityManager em = new JPAUtil().getEntityManager();
	
	Conta conta = em.find(Conta.class, 2);
	
	System.out.println(conta.getTitular());
	
	// se alterar atributo durante a transação hibernate executa um update
	em.getTransaction().begin();
	conta.setTitular("O cãozinho dos teclados");
	em.getTransaction().commit();
	
	em.close();
	
	System.out.println(conta.getTitular());
}
}
