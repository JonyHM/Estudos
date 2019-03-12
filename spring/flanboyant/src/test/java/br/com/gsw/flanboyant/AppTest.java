package br.com.gsw.flanboyant;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.gsw.flanboyant.controller.HomeController;

public class AppTest{

	@Test
	public void testApp() {
		HomeController hc = new HomeController();
		String result = hc.home();
		assertEquals(result, "Abrindo a aplicação");
	}
}
