package qintess.com.Desafio.dados;

import org.springframework.data.jpa.repository.JpaRepository;
import qintess.com.Desafio.Entidades.Usuario;

public interface UsuarioR extends JpaRepository<Usuario, Integer> {

}
