package br.com.caelum.leilao.servico;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;

public class AvaliadorTest {
	
	private Usuario jao;
	private Usuario ze;
	private Usuario jony;
	private Avaliador avaliador;

	@Before
	public void criaAvaliador() {
		this.jao = new Usuario("João");
		this.ze = new Usuario("Jouser");
		this.jony = new Usuario("Jony");
		this.avaliador = new Avaliador();
	}
	
	@Test
	public void deveEntenderMaiorEMenorValor() {
		Leilao leilao = new CriadorDeLeilao().para("Teste sem criatividade")
				.lance(jao, 150.0)
				.lance(ze, 300.0)
				.lance(jony, 500.0)
				.constroi();
		
		avaliador.avalia(leilao);
		
		double menorEsperado = 150;
		double maiorEsperado = 500;
		double mediaEsperada = 316.6;
		
		assertThat(avaliador.getMaiorLance(), equalTo(maiorEsperado));
		assertThat(avaliador.getMenorLance(), equalTo(menorEsperado));
		assertThat(Math.round(avaliador.getMedia()), equalTo(Math.round(mediaEsperada)));
	}
	
	@Test
	public void deveEntenderLeilaoComUmLance() {
		Leilao leilao = new CriadorDeLeilao().para("PsOne")
				.lance(jao, 150.0)
				.constroi();
		
		avaliador.avalia(leilao);
		
		assertThat(avaliador.getMaiorLance(), equalTo(150.0));
		assertThat(avaliador.getMenorLance(), equalTo(150.0));
		assertThat(avaliador.getMedia(), equalTo(150.0));
	}
	
	@Test
	public void deveAcharOsTresMaioresLances() {
		Leilao leilao = new CriadorDeLeilao().para("Mota")
				.lance(jao, 5000.0)
				.lance(ze, 8000.0)
				.lance(jao, 9000.0)
				.lance(ze, 9500.0)
				.constroi();
		
		avaliador.avalia(leilao);
		
		List<Lance> maiores = avaliador.getTresMaiores();
		
		assertThat(maiores.size(), equalTo(3));
		assertThat(maiores, hasItems(
				new Lance(ze, 9500.0),
				new Lance(jao, 9000.0),
				new Lance(ze, 8000.0)				
				));
	}
	
	@Test(expected=RuntimeException.class)
	public void naoDeveAvaliarLeiloesVazios() {
		Leilao leilao = new CriadorDeLeilao().para("iPhone 7, em Julho")
				.constroi();
		
		avaliador.avalia(leilao);
	}
}
