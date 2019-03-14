package br.com.gsw.financas.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.gsw.financas.modelo.Conta;
import br.com.gsw.financas.util.JPAUtil;

public class TesteConsultaFuncaoMax {

	public static void main(String[] args) {

		EntityManager em = new JPAUtil().getEntityManager();
		
		Conta conta = new Conta();
		conta.setId(5);
		
		Query query = em.createQuery("select max(m.valor) from Movimentacao m where m.conta = :pConta");
		query.setParameter("pConta", conta);
		
		BigDecimal maiorGasto = (BigDecimal) query.getSingleResult();
		
		System.out.println("O maior gasto foi de: " + maiorGasto);
	}

}
