package br.com.caelum.financas.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TestaJpqlAvancada {

	public static void main(String[] args) {
		EntityManager entityManager = new JPAUtil().getEntityManager();
		
		Conta conta = new Conta();
        conta.setId(3);

        String jpql = "select sum(m.valor) from Movimentacao m where m.conta=:pConta "
                + "and m.tipoMovimentacao=:pTipo";

        String jpql2 = "select avg(m.valor) from Movimentacao m where m.conta=:pConta "
                + "and m.tipoMovimentacao=:pTipo";

        TypedQuery<BigDecimal> query = entityManager.createQuery(jpql, BigDecimal.class);
        TypedQuery<Double> query2 = entityManager.createQuery(jpql2, Double.class);
        
        query.setParameter("pConta", conta);
        query.setParameter("pTipo", TipoMovimentacao.SAIDA);
        
        query2.setParameter("pConta", conta);
        query2.setParameter("pTipo", TipoMovimentacao.ENTRADA);
        
        BigDecimal resultado = query.getSingleResult();
        Double media = query2.getSingleResult();

        System.out.println("Total movimentado ..: R$ " + resultado);
        System.out.println("Média movimentado ..: R$ " + media);
	}

}
