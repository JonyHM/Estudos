package br.com.caelum.leilao.dominio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class AnoBissextoTest {

	@Test
	public void deveTestarMultiplosDe400() {
		AnoBissexto test = new AnoBissexto();
		List<Integer> anos = new ArrayList<>();
		
		anos.add(1600);
		anos.add(2000);
		anos.add(2400);
		anos.add(2800);
		
		for (Integer ano : anos) {
			assertEquals(true, test.ehBissexto(ano));
		}
	}
	
	@Test
	public void deveTestarMultiplosDe4() {
		AnoBissexto test = new AnoBissexto();
		List<Integer> anos = new ArrayList<>();
		
		anos.add(1996); //[0] true
		anos.add(2100); //[1] false
		anos.add(2020); //[2] true
		
		assertEquals(true, test.ehBissexto(anos.get(0)));
		assertEquals(false, test.ehBissexto(anos.get(1)));
		assertEquals(true, test.ehBissexto(anos.get(2)));
		
	}
	
	public void deveTestarMultiplosDe100() {
		
	}
}
