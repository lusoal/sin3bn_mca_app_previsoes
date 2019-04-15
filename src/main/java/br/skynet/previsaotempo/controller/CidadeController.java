package br.skynet.previsaotempo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.skynet.previsaotempo.bean.Cidade;
import br.skynet.previsaotempo.service.CidadeService;

@Controller
public class CidadeController {
	@Autowired
	private CidadeService cidadeServ;
	
	@GetMapping("/cidade/")
	public ModelAndView mostrarCidades() {
		ModelAndView mv = new ModelAndView("cidades");
		
		List <Cidade> cidades = cidadeServ.getAllCidades();
		
		mv.addObject(new Cidade());
		mv.addObject("cidades", cidades);
		return mv;
		
	}
	
	//Uma requisição para cidades vai persistir uma cidadade na base
	@PostMapping("/cidade/")
	public String salvarPrevisao(Cidade cidade) {
		cidadeServ.cadastrarCidade(cidade);
		return "redirect:/cidade/";

	}
}
