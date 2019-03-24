package br.skynet.previsaotempo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.skynet.previsaotempo.bean.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	//Baseado no nome do metodo ele sabe o que ele tem que buscar
	public Usuario findOneByLoginAndSenha(String login, String senha);

}
