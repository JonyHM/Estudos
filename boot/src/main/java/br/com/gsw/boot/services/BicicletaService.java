package br.com.gsw.boot.services;

import java.util.List;
import java.util.Optional;

import br.com.gsw.boot.models.Bicicleta;

public interface BicicletaService {

	Bicicleta criarBicicleta(Bicicleta bicicleta);
	Optional<Bicicleta> getBicicleta(Long id);
	Bicicleta editaBicicleta(Bicicleta bicicleta);
	void apagaBicicleta(Bicicleta bicicleta);
	void apagaBicicleta(Long id);
	List<Bicicleta> getTodasBicicletas(int numeroPagina, int tamanhoPagina);
	List<Bicicleta> getTodasBicicletas();
	long contaBicicletas();
	
}
