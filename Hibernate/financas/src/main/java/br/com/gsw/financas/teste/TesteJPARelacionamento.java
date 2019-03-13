package br.com.gsw.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.gsw.financas.modelo.Conta;
import br.com.gsw.financas.modelo.Movimentacao;
import br.com.gsw.financas.modelo.TipoMovimentacao;
import br.com.gsw.financas.util.JPAUtil;

public class TesteJPARelacionamento {

	public static void main(String[] args) {
		
		//Instanciando a conta e definindo um ID existente no BD
		Conta conta = new Conta();
		conta.setId(4);
		
		Movimentacao mov = new Movimentacao();
		
		mov.setData(Calendar.getInstance());
	    mov.setDescricao("Churrascaria");
	    mov.setTipo(TipoMovimentacao.SAIDA);
	    mov.setValor(new BigDecimal("200.0"));

	    mov.setConta(conta);
	    
	    EntityManager em = new JPAUtil().getEntityManager();
	    em.getTransaction().begin();
	    
	    em.persist(mov);
	    
	    em.getTransaction().commit();
	    
	    em.close();
	}
}
