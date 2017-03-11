package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConsultaFuncaoCount {

	public static void main(String[] args) {
		EntityManager entityManager = new JPAUtil().getEntityManager();
		Conta conta = entityManager.find(Conta.class, 2);
		
		Query query = entityManager.createQuery("select count(m) from Movimentacao m where m.conta = :pConta");
		
		query.setParameter("pConta", conta);
		Long quantidade =  (Long) query.getSingleResult();
		System.out.println("Total de movimentações: " + quantidade);
	}

}
