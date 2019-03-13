package br.com.gsw.financas.teste;

import javax.persistence.EntityManager;

import br.com.gsw.financas.modelo.Conta;
import br.com.gsw.financas.util.JPAUtil;

public class TesteBuscaConta {

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = em.find(Conta.class, 1);
		
		System.out.println("\n\n" + conta.getTitular());
		
		em.getTransaction().commit();
		
		
	}
}
