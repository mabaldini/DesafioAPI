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

import qintess.com.Desafio.Entidades.Usuario;
import qintess.com.Desafio.dados.UsuarioR;

@RestController
@RequestMapping("/api")
public class UsuarioController {

	@Autowired
	private UsuarioR repo;

	@GetMapping("/usuario")
	public List<Usuario> getUsuarios() {
		List<Usuario> usuario = new ArrayList<Usuario>();
		usuario.add(new Usuario());
		usuario.add(new Usuario());
		return usuario;
	}

	@PostMapping("/usuario")
	public void criarUsuario(@RequestBody Usuario usuario) {

		repo.save(usuario);
	}

	@DeleteMapping("/usuario")
	public void deleteUsuario(@RequestBody Usuario usuario) {
		repo.delete(usuario);
	}

	@PutMapping("/usuario")
	public void alteraUsuario(@RequestBody Usuario usuario) {
		repo.save(usuario);
	}

}
