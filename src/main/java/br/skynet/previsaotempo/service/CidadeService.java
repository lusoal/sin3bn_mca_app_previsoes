package br.skynet.previsaotempo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.skynet.previsaotempo.bean.Cidade;
import br.skynet.previsaotempo.repository.CidadeRepository;

@Service
public class CidadeService {
	@Autowired
	private CidadeRepository cidadeRepo;

	public void cadastrarCidade(Cidade cidade) {
		cidadeRepo.save(cidade);
	}
	
	public List<Cidade> getAllCidades(){
		return cidadeRepo.findAll();
	}
}
