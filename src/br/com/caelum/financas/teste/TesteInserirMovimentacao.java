package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

//import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteInserirMovimentacao {

    public static void main(String[] args) {

        EntityManager em = new JPAUtil().getEntityManager();
        String jpql = "select m from Movimentacao m join m.conta c "; 
        Query qry = em.createQuery(jpql);
        //Conta conta = em.find(Conta.class, 1);

        List<Movimentacao> movimentacoes = qry.getResultList(); //conta.getMovimentacao();
        
        em.close();           

        for (Movimentacao movimentacao : movimentacoes) {
            System.out.println("Movimentação: " + movimentacao.getDescricao()+" - Titular: "+movimentacao.getConta().getTitular());
        }
            

    }
}