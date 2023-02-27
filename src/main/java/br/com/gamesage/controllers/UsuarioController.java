package br.com.gamesage.controllers;

import br.com.gamesage.dtos.UsuarioDTO;
import br.com.gamesage.entities.Usuario;
import br.com.gamesage.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public List<UsuarioDTO> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/getUsuario/{id}")
    public UsuarioDTO getUsuarioById(@PathVariable Long id) {
        return service.getUsuarioById(id);
    }

    @PostMapping(value = "/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody Usuario usuario) {
        return service.cadastrarAlterar(usuario, "cadastrar");
    }

    @PutMapping(value = "/alterar")
    public ResponseEntity<?> alterar(@RequestBody Usuario usuario) {
        return service.cadastrarAlterar(usuario, "alterar");
    }

    @DeleteMapping(value = "/remover/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        return service.remover(id);
    }

}
