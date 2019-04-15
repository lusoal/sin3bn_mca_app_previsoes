package br.skynet.previsaotempo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.skynet.previsaotempo.bean.DiaDaSemana;
import br.skynet.previsaotempo.repository.DiaDaSemanaRepository;

@Service
public class DiaDaSemanaService {
	
	@Autowired
	private DiaDaSemanaRepository diaRepo;
	
	public List<DiaDaSemana> getAllDias() {
		System.out.println("Estou buscando todos os dias da semana");
		return diaRepo.findAll();
	}
	

}
