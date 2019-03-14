package br.com.gsw.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.gsw.financas.modelo.Conta;
import br.com.gsw.financas.util.JPAUtil;

public class TesteConsultaFuncaoCount {

	public static void main(String[] args) {

		EntityManager em = new JPAUtil().getEntityManager();
		Conta conta = em.find(Conta.class, 2);
		
		Query query = em.createQuery("select count(m) from Movimentacao m where m.conta = :pConta");
		query.setParameter("pConta", conta);
		
		Long result = (Long) query.getSingleResult();
		
		System.out.println("Esta conta possui " + result + " movimentações");
	}

}
