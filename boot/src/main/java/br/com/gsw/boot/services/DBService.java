package br.com.gsw.boot.services;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.gsw.boot.models.Bicicleta;

@Component
public class DBService implements CommandLineRunner {

	@Autowired
	BicicletaServiceImpl service;
	
	//Separar os itens do pedido da bicicleta futuramente	
	@Override
	public void run(String... strings) throws Exception {
		
		Bicicleta b1 = new Bicicleta("Jeff Miller","jeff@bikes.com", "3952-6115", "Globo MTB 29 Full Suspension", 
				"6543215", new BigDecimal(2100.56), new Date(886862122000L), true);
		
		Bicicleta b2 = new Bicicleta("Samantha Davis","samantha@bikes.com", "3927-6532", "Globo Carbon Fiber Race Series", 
				"7655416", new BigDecimal(1995.36), new Date(1435240532000L), false);
		
		Bicicleta b3 = new Bicicleta("Dave Warren","dave@bikes.com", "3672-1495", "Globo Time Trial Blade", 
				"9564123", new BigDecimal(2150.96), new Date(1564231041000L), true);
	
		service.criarBicicleta(b1);
		service.criarBicicleta(b2);
		service.criarBicicleta(b3);
	}
}
