package br.com.caelum.financas.util;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;

public class PopulaBanco {

	public static void main(String[] args) {
	
		// cria contatos
		Conta c1 = new Conta();
		Conta c2 = new Conta();
		Conta c3 = new Conta();
		Conta c4 = new Conta();
		Conta c5 = new Conta();		
		
		c1.setAgencia("781351");
		c1.setBanco("Bradesco");
		c1.setNumero("6841");
		c1.setTitular("Frank Aguiar");
		
		c2.setAgencia("72456");
		c2.setBanco("Itaú");
		c2.setNumero("764");
		c2.setTitular("Jota Neto");
		
		c3.setAgencia("542347");
		c3.setBanco("Caixa Econômica Federal");
		c3.setNumero("55134");
		c3.setTitular("Lula Livre");
		
		c4.setAgencia("684050");
		c4.setBanco("Sicoob");
		c4.setNumero("846546");
		c4.setTitular("Bolsonaro 2018");
		
		c5.setAgencia("684164");
		c5.setBanco("Banco do Brasil");
		c5.setNumero("540348");
		c5.setTitular("Dilmãe");
		
		// instancia classe de gerenciamento de conexão
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		em.persist(c1);
		em.persist(c2);
		em.persist(c3);
		em.persist(c4);
		em.persist(c5);
		em.getTransaction().commit();
		em.close();
		
		
		
		

	}

}
