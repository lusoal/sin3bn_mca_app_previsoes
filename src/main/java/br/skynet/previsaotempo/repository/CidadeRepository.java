package br.skynet.previsaotempo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.skynet.previsaotempo.bean.Cidade;
@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

}
