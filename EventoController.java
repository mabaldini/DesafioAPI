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

import qintess.com.Desafio.Entidades.Evento;
import qintess.com.Desafio.dados.EventoR;

@RestController
@RequestMapping("/api")
public class EventoController {

	@Autowired
	private EventoR repo;

	@GetMapping("/evento")
	public List<Evento> getEvento() {
		List<Evento> evento = new ArrayList<Evento>();
		evento.add(new Evento());
		evento.add(new Evento());
		return evento;
	}

	@PostMapping("/evento")
	public void criarEvento(@RequestBody Evento evento) {

		repo.save(evento);
	}

	@DeleteMapping("/evento")
	public void deleteEvento(@RequestBody Evento evento) {
		repo.delete(evento);
	}

	@PutMapping("/evento")
	public void alteraEvento(@RequestBody Evento evento) {
		repo.save(evento);
	}

}
