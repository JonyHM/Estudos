package br.com.gsw.financas.teste;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.gsw.financas.modelo.Categoria;
import br.com.gsw.financas.modelo.Conta;
import br.com.gsw.financas.modelo.Movimentacao;
import br.com.gsw.financas.modelo.TipoMovimentacao;
import br.com.gsw.financas.util.JPAUtil;

public class TesteMovimentacaoComCategoria {
	
	public static void main(String[] args) {
		
		Categoria cat1 = new Categoria("Viagem");
		Categoria cat2 = new Categoria("Negocios");
		
		Conta conta = new Conta();
		conta.setId(2);
		
		Movimentacao m1 = new Movimentacao();
		m1.setData(Calendar.getInstance());
		m1.setDescricao("Viagem à SP");
		m1.setTipo(TipoMovimentacao.SAIDA);
		m1.setValor(new BigDecimal("100.0"));
		m1.setCategorias(Arrays.asList(cat1, cat2));
		m1.setConta(conta);
		
		Movimentacao m2 = new Movimentacao();
		m2.setData(Calendar.getInstance());
		m2.setDescricao("Viagem ao RJ");
		m2.setTipo(TipoMovimentacao.SAIDA);
		m2.setValor(new BigDecimal("300.0"));
		m2.setCategorias(Arrays.asList(cat1, cat2));
		m2.setConta(conta);
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		em.persist(cat1);
		em.persist(cat2);
		
		em.persist(m1);
		em.persist(m2);
		
		em.getTransaction().commit();
		em.close();
	}
}
