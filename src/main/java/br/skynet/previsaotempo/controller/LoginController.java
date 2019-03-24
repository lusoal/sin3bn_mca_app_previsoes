package br.skynet.previsaotempo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.skynet.previsaotempo.bean.Usuario;
import br.skynet.previsaotempo.service.UsuarioService;

@Controller
public class LoginController {

	@Autowired
	private UsuarioService userServ;

	@GetMapping(value = { "/login", "/" })
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("login");
		//Ja deixa previamente instanciado um usuario
		mv.addObject(new Usuario());

		return mv;
	}
	
	@PostMapping("/fazerLogin")
	public String fazerLogin(HttpServletRequest request, Usuario user) {
		
		if (userServ.validarLogin(user)) {
			request.getSession().setAttribute("usuarioLogado", user);
			return "redirect:/previsao";
		}else {
			return "/";
		}
	}
	
}
