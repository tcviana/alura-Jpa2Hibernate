package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Cliente;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaContaCliente {

	public static void main(String[] args) {		
		// seleciona conta de ID 2
		Conta conta = new Conta();
		conta.setId(2);
		// cria cliente
		Cliente cliente = new Cliente();
		cliente.setConta(conta);
		cliente.setEndereco("Rua Direita");
		cliente.setNome("Tiago Viana");
		cliente.setProfissao("Pedreiro");
		// gera registro no db
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
		em.close();

	}

}
