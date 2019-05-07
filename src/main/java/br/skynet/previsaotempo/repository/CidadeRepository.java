package br.skynet.previsaotempo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.skynet.previsaotempo.bean.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {
	
	public static final String FIND_CIDADES_LETTER = "SELECT * FROM cidades where nome LIKE :letter%";
	@Query(value = FIND_CIDADES_LETTER, nativeQuery = true)
	public List<Cidade> findCityByLetter(@Param("letter") String letter);
	
	public static final String FIND_CIDADE_LA_LO = "SELECT * FROM cidades where latitude LIKE :latitude% "
			+ "AND longitude LIKE :longitude%";
	@Query(value = FIND_CIDADE_LA_LO, nativeQuery = true)
	public Cidade findCityLaLo(@Param("latitude") String latitude, @Param("longitude") String longitude);
}
