package br.com.gsw.boot.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.gsw.boot.models.Bicicleta;
import br.com.gsw.boot.services.BicicletaServiceImpl;

@RestController
@RequestMapping("/api/v1/bicicletas")
public class BicicletasController {
	
	BicicletaServiceImpl biciclietaService;
	
	public BicicletasController() {
		biciclietaService = new BicicletaServiceImpl();
	}

	@GetMapping
	public List<Bicicleta> lista() {
		return biciclietaService.getTodasBicicletas();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody Bicicleta bicicleta) {
		
	}
	
	@GetMapping("/{id}") // Funciona em conjunto com o @Input do front, onde podemos passar um valor na url e usá-lo
	public Bicicleta get(@PathVariable("id") long id) {
		return new Bicicleta();
	}
	
	
}
