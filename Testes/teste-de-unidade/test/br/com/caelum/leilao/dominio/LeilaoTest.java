package br.com.caelum.leilao.dominio;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.leilao.servico.CriadorDeLeilao;
import br.com.caelum.leilao.TemLance;

public class LeilaoTest {
	
	private Usuario jao;
	private Usuario juliana;
	private Usuario ze;
	private Usuario billGates;
	private Usuario steveJobs;
	private Usuario jony;
	
	@Before
	public void criaUsuarios() {
		this.jao = new Usuario("João");
		this.juliana = new Usuario("Juliana");
		this.jony = new Usuario("Jony");
		this.ze = new Usuario("Jouser");
		this.billGates = new Usuario("Bill Gates");
		this.steveJobs = new Usuario("Steve Jobs");
	}

	@Test
	public void deveReceberUmLance() {
		Leilao leilao = new CriadorDeLeilao().para("iPhone 7 $o$")
				.constroi();
		assertEquals(0, leilao.getLances().size());
		
		Lance lance = new Lance(jony, 1500.0);
		leilao.propoe(lance);
		
		assertThat(leilao.getLances().size(), equalTo(1));
		assertThat(leilao, TemLance.temLance(lance));
	}
	
	@Test
	public void deveReceberDiversosLances() {
		Leilao leilao = new CriadorDeLeilao().para("iPhone 7 $o$")
				.lance(juliana, 1700.0)
				.lance(jony, 2100.0)
				.constroi();
			
		assertEquals(2, leilao.getLances().size());
		assertEquals(1700.0, leilao.getLances().get(0).getValor(), 0.00001);
		assertEquals(2100.0, leilao.getLances().get(1).getValor(), 0.00001);
		
	}
	
	@Test
	public void naoDeveAceitarDoisSeguidosDoMesmo() {
		Leilao leilao = new CriadorDeLeilao().para("iPhone 7 $o$")
				.lance(jony, 2500.0)
				.lance(jony, 2700.0)
				.constroi();
		
		assertEquals(1, leilao.getLances().size());
		assertEquals(2500.0, leilao.getLances().get(0).getValor(), 0.00001);
	}
	
	@Test
    public void naoDeveAceitarMaisDoQue5LancesDeUmMesmoUsuario() {
        Leilao leilao = new CriadorDeLeilao().para("Macbook Pro 15")
        		.lance(steveJobs, 2000)
        		.lance(billGates, 3000)
        		.lance(steveJobs, 4000)
        		.lance(billGates, 5000)
        		.lance(steveJobs, 6000)
        		.lance(billGates, 7000)
        		.lance(steveJobs, 8000)
        		.lance(billGates, 9000)
        		.lance(steveJobs, 10000)
        		.lance(billGates, 11000)
        		.lance(steveJobs, 12000) // deve ser ignorado
        		.constroi();

        assertEquals(10, leilao.getLances().size());
        int ultimo = leilao.getLances().size() - 1;
        Lance ultimoLance = leilao.getLances().get(ultimo);
        assertEquals(11000.0, ultimoLance.getValor(), 0.00001);
    }
	
	@Test
	public void deveDobrarLance() {
		Leilao leilao = new CriadorDeLeilao().para("Imposto zero")
				.lance(ze, 5000)
				.lance(jao, 100)
				.constroi();
		
		leilao.dobraLance(ze);
		
		assertEquals(10000.0, leilao.getLances().get(2).getValor(), 0.00001);
	}
	
	@Test
    public void naoDeveDobrarCasoNaoHajaLanceAnterior() {
        Leilao leilao = new CriadorDeLeilao().para("Macbook Pro 15")
        		.constroi();

        leilao.dobraLance(steveJobs);

        assertEquals(0, leilao.getLances().size());
    }
}
