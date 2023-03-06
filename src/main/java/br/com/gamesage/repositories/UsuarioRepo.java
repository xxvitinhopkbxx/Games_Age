package br.com.gamesage.repositories;

import br.com.gamesage.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepo extends JpaRepository<Usuario, Long> {
}
