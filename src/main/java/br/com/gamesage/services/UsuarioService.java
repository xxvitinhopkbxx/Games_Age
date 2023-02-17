package br.com.gamesage.services;

import br.com.gamesage.dtos.UsuarioDTO;
import br.com.gamesage.repositories.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepo repo;

    public UsuarioDTO getUsuarioById(Long id) {
        return repo.findById(id).isPresent()? new UsuarioDTO(repo.findById(id).get()) : null;
    }

}
