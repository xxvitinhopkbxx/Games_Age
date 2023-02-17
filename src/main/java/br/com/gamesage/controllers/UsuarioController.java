package br.com.gamesage.controllers;

import br.com.gamesage.dtos.UsuarioDTO;
import br.com.gamesage.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping(value = "/getUsuario/{id}")
    public UsuarioDTO getUsuarioById(@PathVariable Long id) {
        return service.getUsuarioById(id);
    }

}
