package br.skynet.previsaotempo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.skynet.previsaotempo.bean.DiaDaSemana;
import br.skynet.previsaotempo.bean.Tempo;
import br.skynet.previsaotempo.service.DiaDaSemanaService;
import br.skynet.previsaotempo.service.PrevisaoService;

@Controller
public class PrevisaoController {
	// Ingestao de dependencias do Springboot
	@Autowired
	private PrevisaoService prevServ;
	@Autowired
	private DiaDaSemanaService diaServ;
	

	@GetMapping("/previsao/")
	public ModelAndView mostrarPrevisao() {
		// Nome da pagina HTML para renderizao
		ModelAndView mv = new ModelAndView("mostrar_previsao");

		List<Tempo> previsao = prevServ.listarTodos();
		List<DiaDaSemana> diasSemana = diaServ.getAllDias();
		
		//Adicionando objetos para poder persistir no Post
		mv.addObject(new Tempo());
		
		mv.addObject("diasSemana", diasSemana);
		mv.addObject("previsoes", previsao);
		return mv;
	}

	//Recebe uma previsao que foi instanciada acima, o objeto vai vir do HTML diretamente
	@PostMapping
	public String salvarPrevisao(Tempo tempo) {
		//Realizar o Save da previsao e o redirect
		System.out.println(tempo.getDiaDaSemana());
		prevServ.salvar(tempo);
		return "redirect:/previsao/";

	}

}
