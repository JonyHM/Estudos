package br.com.caelum.leilao;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;

public class TemLance extends TypeSafeMatcher<Leilao>{

	private Lance lance;
	
	public TemLance(Lance lance) {
		this.lance = lance;
	}
	
	@Override
	public void describeTo(Description desc) {
		desc.appendText("Leilão com lance")
				.appendValue(lance.getValor());
	}

	@Override
	protected boolean matchesSafely(Leilao item) {
		return item.getLances().contains(lance);
	}

	public static Matcher<Leilao> temLance(Lance lance){
		return new TemLance(lance);
	}
}
