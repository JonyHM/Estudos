package br.com.gsw.maven;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TesteProduto {

	@Test
	public void verificaPrecoComImposto() {
		Produto moto = new Produto("HaoJue Chopper Road", 7300.00);
		assertEquals(8030.00, moto.getPrecoComImposto(), 0.0001);
	}
}
