package br.com.gamesage.repositories;

import br.com.gamesage.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepo extends JpaRepository<Usuario, Long> {
}
