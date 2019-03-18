package br.com.caelum.leilao.dominio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class LeilaoTest {

	@Test
	public void deveReceberUmLance() {
		Leilao leilao = new Leilao("iPhone 7 $o$");
		assertEquals(0, leilao.getLances().size());
		
		leilao.propoe(new Lance(new Usuario("Jony"), 1500.0));
		assertEquals(1, leilao.getLances().size());
		assertEquals(1500.0, leilao.getLances().get(0).getValor(), 0.00001);
	}
	
	@Test
	public void deveReceberDiversosLances() {
		Leilao leilao = new Leilao("iPhone 7 $o$");
		leilao.propoe(new Lance(new Usuario("Juliana"), 1700.0));
		leilao.propoe(new Lance(new Usuario("Jony"), 2100.0));
		
		assertEquals(2, leilao.getLances().size());
		assertEquals(1700.0, leilao.getLances().get(0).getValor(), 0.00001);
		assertEquals(2100.0, leilao.getLances().get(1).getValor(), 0.00001);
		
	}
	
	@Test
	public void naoDeveAceitarDoisSeguidosDoMesmo() {
		Leilao leilao = new Leilao("iPhone 7 $o$");
		Usuario jony = new Usuario("Jony");
		
		leilao.propoe(new Lance(jony, 2500.0));
		leilao.propoe(new Lance(jony, 2700.0));
		
		assertEquals(1, leilao.getLances().size());
		assertEquals(2500.0, leilao.getLances().get(0).getValor(), 0.00001);
	}
	
	@Test
    public void naoDeveAceitarMaisDoQue5LancesDeUmMesmoUsuario() {
        Leilao leilao = new Leilao("Macbook Pro 15");
        Usuario steveJobs = new Usuario("Steve Jobs");
        Usuario billGates = new Usuario("Bill Gates");

        leilao.propoe(new Lance(steveJobs, 2000));
        leilao.propoe(new Lance(billGates, 3000));
        leilao.propoe(new Lance(steveJobs, 4000));
        leilao.propoe(new Lance(billGates, 5000));
        leilao.propoe(new Lance(steveJobs, 6000));
        leilao.propoe(new Lance(billGates, 7000));
        leilao.propoe(new Lance(steveJobs, 8000));
        leilao.propoe(new Lance(billGates, 9000));
        leilao.propoe(new Lance(steveJobs, 10000));
        leilao.propoe(new Lance(billGates, 11000));

        // deve ser ignorado
        leilao.propoe(new Lance(steveJobs, 12000));

        assertEquals(10, leilao.getLances().size());
        int ultimo = leilao.getLances().size() - 1;
        Lance ultimoLance = leilao.getLances().get(ultimo);
        assertEquals(11000.0, ultimoLance.getValor(), 0.00001);
    }
	
	@Test
	public void deveDobrarLance() {
		Leilao leilao = new Leilao("Imposto zero");
		Usuario usuario = new Usuario("Zé");
		Usuario usuario2 = new Usuario("Jão");
		
		leilao.propoe(new Lance(usuario, 5000));
		leilao.propoe(new Lance(usuario2, 100));
		leilao.dobraLance(usuario);
		
		assertEquals(10000.0, leilao.getLances().get(2).getValor(), 0.00001);
	}
	
	@Test
    public void naoDeveDobrarCasoNaoHajaLanceAnterior() {
        Leilao leilao = new Leilao("Macbook Pro 15");
        Usuario steveJobs = new Usuario("Steve Jobs");

        leilao.dobraLance(steveJobs);

        assertEquals(0, leilao.getLances().size());
    }
}
