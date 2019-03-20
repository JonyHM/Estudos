package br.com.caelum.leilao.dominio;

import org.junit.Before;
import org.junit.Test;

public class LanceTest {
	
	Usuario jao;
	Usuario ze;
	Lance lance;
	
	@Before
	public void instanciador() {
		this.jao = new Usuario("João");
		this.ze = new Usuario("José");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void deveNegarLanceNulo() {
		lance = new Lance(jao, 0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void deveNegarLanceNegativo() {
		lance = new Lance(ze, -1052);
	}

}
