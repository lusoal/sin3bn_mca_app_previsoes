package br.skynet.previsaotempo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.skynet.previsaotempo.model.Tempo;
import br.skynet.previsaotempo.repository.PrevisaoRepository;

@Controller
public class PrevisaoController {
	//Ingestao de dependencias do Springboot
	@Autowired
	private PrevisaoRepository prevRepo;
	
	@GetMapping ("/previsao")
	public ModelAndView mostrarPrevisao () {
		//Nome da pagina HTML para renderizao
		ModelAndView mv = new ModelAndView("mostrar_previsao");
		
		//Cria uma lista com os valores coletados do banco utilizando a interface implementada o JPA
		List <Tempo> previsao = prevRepo.findAll();
		
		mv.addObject("previsoes", previsao);
		
		return mv;
	}

}
