package br.com.gsw.boot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.gsw.boot.models.Bicicleta;
import br.com.gsw.boot.services.BicicletaServiceImpl;

@RestController
@RequestMapping("/api/v1/bicicletas")
public class BicicletasController {

	@Autowired
	BicicletaServiceImpl biciclietaService;

	@GetMapping
	public List<Bicicleta> listar() {
		List<Bicicleta> bikes = biciclietaService.getTodasBicicletas();
		return bikes;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody Bicicleta bicicleta){
		biciclietaService.criarBicicleta(bicicleta);
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public void update(@RequestBody Bicicleta bicicleta) {
		biciclietaService.editaBicicleta(bicicleta);
	}
	
	@GetMapping("/{id}") // Funciona da mesma forma que o @Input do front, onde podemos passar um valor na url e usá-lo
	public ResponseEntity<Bicicleta> get(@PathVariable long id) {
		Bicicleta bike = biciclietaService.getBicicleta(id);
		
		return ResponseEntity.ok().body(bike);
	}	
	
	
}
