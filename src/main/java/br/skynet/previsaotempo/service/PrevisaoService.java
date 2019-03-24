package br.skynet.previsaotempo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.skynet.previsaotempo.bean.Tempo;
import br.skynet.previsaotempo.repository.PrevisaoRepository;

//Classe resposavel por realizar a interacao com o banco
@Service
public class PrevisaoService {

	// Injecao de dependencia
	@Autowired
	private PrevisaoRepository previsaoRepo;

	public void salvar(Tempo tempo) {
		previsaoRepo.save(tempo);
	}

	public List<Tempo> listarTodos() {
		// Retorna uma lista de Tempos
		return previsaoRepo.findAll();
	}

}
