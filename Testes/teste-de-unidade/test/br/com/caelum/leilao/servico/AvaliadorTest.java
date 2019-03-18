package br.com.caelum.leilao.servico;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;

public class AvaliadorTest {
	
	@Test
	public void deveEntenderMaiorEMenorValor() {
		
		Usuario usuario1 = new Usuario("João");
		Usuario usuario2 = new Usuario("Jouser");
		Usuario usuario3 = new Usuario("Joanderson");
		
		Leilao leilao = new Leilao("Teste sem criatividade");
		
		leilao.propoe(new Lance(usuario1, 150.0));
		leilao.propoe(new Lance(usuario2, 300.0));
		leilao.propoe(new Lance(usuario3, 500.0));
		
		Avaliador avaliador = new Avaliador();
		avaliador.avalia(leilao);
		
		double menorEsperado = 150;
		double maiorEsperado = 500;
		double mediaEsperada = 316.7;
		
		assertEquals(maiorEsperado, avaliador.getMaiorLance(), 0.00001);
		assertEquals(menorEsperado, avaliador.getMenorLance(), 0.00001);
		assertEquals(mediaEsperada, avaliador.getMedia(), 0.1);
	}
	
	@Test
	public void deveEntenderLeilaoComUmLance() {
		Usuario jao = new Usuario("jão");
		Leilao leilao = new Leilao("PsOne");
		
		leilao.propoe(new Lance(jao, 150.0));

		Avaliador avaliador = new Avaliador();
		avaliador.avalia(leilao);
		
		assertEquals(150.0, avaliador.getMaiorLance(), 0.00001);
		assertEquals(150.0, avaliador.getMenorLance(), 0.00001);
		assertEquals(150.0, avaliador.getMedia(), 0.00001);
	}
	
	@Test
	public void deveAcharOsTresMaioresLances() {
		Usuario joao = new Usuario("joão");
		Usuario maria = new Usuario("maria");
		Leilao leilao = new Leilao("Mota");
		
		leilao.propoe(new Lance(joao, 5000.0));
		leilao.propoe(new Lance(maria, 8000.0));
		leilao.propoe(new Lance(joao, 9000.0));
		leilao.propoe(new Lance(maria, 9500.0));
		
		Avaliador avaliador = new Avaliador();
		avaliador.avalia(leilao);
		
		List<Lance> maiores = avaliador.getTresMaiores();
		
		assertEquals(3, maiores.size());
		assertEquals(9500.0, maiores.get(0).getValor(), 0.00001);
		assertEquals(9000.0, maiores.get(1).getValor(), 0.00001);
		assertEquals(8000.0, maiores.get(2).getValor(), 0.00001);
	}
}
