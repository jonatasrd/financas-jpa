package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.util.JPAUtil;

public class TesteContaMovimentacoes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManager manager = new JPAUtil().getEntityManager();
	}

}
