package br.com.caelum.financas.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConsultaFuncaoMax {

	public static void main(String[] args) {
		EntityManager entityManager = new JPAUtil().getEntityManager();
		Conta conta = entityManager.find(Conta.class, 2);
		
		//Query query = entityManager.createQuery("select max(m.valor) from Movimentacao m where m.conta = :pConta");
		TypedQuery<BigDecimal> query = entityManager.createQuery("select max(m.valor) from Movimentacao m where m.conta = :pConta", BigDecimal.class);
		
		query.setParameter("pConta", conta);
		BigDecimal valor = query.getSingleResult();
		System.out.println("O maximo valor movimentado foi de: " + valor);
	}
	

}
