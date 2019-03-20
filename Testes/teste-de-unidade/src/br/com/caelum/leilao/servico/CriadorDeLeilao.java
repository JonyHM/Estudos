package br.com.caelum.leilao.servico;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;

public class CriadorDeLeilao {
	
	Leilao leilao;
	
	public CriadorDeLeilao para(String descricao) {
		leilao = new Leilao(descricao);
		return this;		
	}
	
	public CriadorDeLeilao lance(Usuario usuario, double valor) {
		leilao.propoe(new Lance(usuario, valor));
		return this;
	}
	
	public Leilao constroi() {
		return leilao;
	}

}
