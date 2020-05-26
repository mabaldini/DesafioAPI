package qintess.com.Desafio.dados;

import org.springframework.data.jpa.repository.JpaRepository;

import qintess.com.Desafio.Entidades.Evento;

public interface EventoR extends JpaRepository<Evento, Integer> {

	
	
}
