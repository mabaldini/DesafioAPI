package qintess.com.Desafio.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import qintess.com.Desafio.Entidades.CasaDeShow;
import qintess.com.Desafio.dados.CasaDeShowR;

@RestController
@RequestMapping("/api")
public class CasaDeShowController {

	@Autowired
	private CasaDeShowR repo;

	@GetMapping("/casaShow")
	public List<CasaDeShow> getCasaDeShow() {
		List<CasaDeShow> casaShow = new ArrayList<CasaDeShow>();
		casaShow.add(new CasaDeShow());
		casaShow.add(new CasaDeShow());
		return casaShow;
	}

	@PostMapping("/casaShow")
	public void criarCasaDeShow(@RequestBody CasaDeShow casaShow) {

		repo.save(casaShow);
	}

	@DeleteMapping("/casaShow")
	public void deleteCasaDeShow(@RequestBody CasaDeShow casaShow) {
		repo.delete(casaShow);
	}

	@PutMapping("/casaShow")
	public void alteraCasaDeShow(@RequestBody CasaDeShow casaShow) {
		repo.save(casaShow);
	}

}
