package br.com.gsw.boot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.gsw.boot.models.Bicicleta;
import br.com.gsw.boot.repository.BicicletaRepository;

@Service
public class BicicletaServiceImpl implements BicicletaService {
	
	@Autowired
	private BicicletaRepository bicicletaRepository;

	@Override
	public Bicicleta criarBicicleta(Bicicleta bicicleta) {
		return bicicletaRepository.save(bicicleta);
	}

	@Override
	public Optional<Bicicleta> getBicicleta(Long id) {
		return bicicletaRepository.findById(id);
	}

	@Override
	public Bicicleta editaBicicleta(Bicicleta bicicleta) {
		return bicicletaRepository.save(bicicleta);
	}

	@Override
	public void apagaBicicleta(Bicicleta bicicleta) {
		bicicletaRepository.delete(bicicleta);
	}

	@Override
	public void apagaBicicleta(Long id) {
		bicicletaRepository.deleteById(id);
	}

	@Override
	public List<Bicicleta> getTodasBicicletas(int numeroPagina, int tamanhoPagina) {
		return bicicletaRepository.findAll(PageRequest.of(numeroPagina, tamanhoPagina)).getContent();
	}

	@Override
	public List<Bicicleta> getTodasBicicletas() {
		return bicicletaRepository.findAll();
	}

	@Override
	public long contaBicicletas() {
		return bicicletaRepository.count();
	}

}
