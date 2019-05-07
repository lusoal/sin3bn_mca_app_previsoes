package br.skynet.previsaotempo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import br.skynet.previsaotempo.bean.Cidade;
import br.skynet.previsaotempo.service.CidadeService;

@RestController
@RequestMapping("/api")
public class CidadeResource {
	@Autowired
	CidadeService cidServ;

	@GetMapping("/cidades/")
	public ResponseEntity<List<Cidade>> listAllCities() {
		List<Cidade> listaCity = cidServ.getAllCidades();
		return ResponseEntity.status(HttpStatus.OK).body(listaCity);
	}

	@PostMapping("/cidades/")
	public ResponseEntity<?> cadastrarCidade(@RequestBody Cidade cidade) {
		cidServ.cadastrarCidade(cidade);
		ObjectMapper mapper = new ObjectMapper();

		ObjectNode objectNode1 = mapper.createObjectNode();
		objectNode1.put("nome", cidade.getNome());
		objectNode1.put("Status","Cadastrada");
		
		return ResponseEntity.status(HttpStatus.OK).body(objectNode1);
	}

	@GetMapping("/cidades/{letter}")
	public ResponseEntity<List<Cidade>> listCityByLetter(@PathVariable("letter") String letra) {
		List<Cidade> listaCity = cidServ.getCidadesLetra(letra);
		return ResponseEntity.status(HttpStatus.OK).body(listaCity);
	}

	@GetMapping("/cidades/latitude/")
	public ResponseEntity<Cidade> listCityByLatitudeAndLongitude(@RequestParam("latitude") String latitude,
			@RequestParam("longitude") String longitude) {
		Cidade cidadeObj = cidServ.getCidadesLatitudeLongitude(latitude, longitude);
		return ResponseEntity.status(HttpStatus.OK).body(cidadeObj);
	}

}
