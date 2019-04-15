package br.skynet.previsaotempo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.skynet.previsaotempo.bean.DiaDaSemana;

@Repository
public interface DiaDaSemanaRepository extends JpaRepository<DiaDaSemana, Long> {

}
