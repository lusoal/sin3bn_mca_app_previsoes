package br.skynet.previsaotempo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.skynet.previsaotempo.model.Tempo;


//Classe o qual e o tipo da variavel de ID
public interface PrevisaoRepository extends JpaRepository<Tempo, Long>{

}
