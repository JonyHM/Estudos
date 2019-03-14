package br.com.gsw.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.gsw.financas.modelo.Conta;
import br.com.gsw.financas.modelo.TipoMovimentacao;
import br.com.gsw.financas.util.JPAUtil;

public class TesteFuncoesJPQL {

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = new Conta();
	    conta.setId(2);
		
	    TypedQuery<Double> typedQuery = em.createNamedQuery("MediaPorDiasETipo", Double.class);
	    typedQuery.setParameter("pConta", conta);
	    typedQuery.setParameter("pTipo", TipoMovimentacao.SAIDA);
	    
	    List<Double> valores = typedQuery.getResultList();
	    	
	    for (Double valor : valores) {
	    	System.out.println("Média : " + valor);
		}
	    
	    em.getTransaction().commit();
	    em.close();

	}
}
