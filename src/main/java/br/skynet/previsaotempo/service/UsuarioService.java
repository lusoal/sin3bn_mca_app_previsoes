package br.skynet.previsaotempo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.skynet.previsaotempo.bean.Usuario;
import br.skynet.previsaotempo.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository userRepo;

	public boolean validarLogin(Usuario user) {
		//!null serve para converter para um valor booleano
		boolean usuarioRetorno = userRepo.findOneByLoginAndSenha(user.getLogin(), user.getSenha()) != null;
		
		System.out.println(usuarioRetorno);
		
		if (usuarioRetorno) {
			return true;
		}else {
			return false;
		}
	}

}
