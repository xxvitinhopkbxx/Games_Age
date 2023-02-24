package br.com.gamesage.services;

import br.com.gamesage.dtos.UsuarioDTO;
import br.com.gamesage.entities.Resposta;
import br.com.gamesage.entities.Usuario;
import br.com.gamesage.repositories.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepo repo;
    @Autowired
    private Resposta resposta;

    public List<UsuarioDTO> findAll() {
        List<UsuarioDTO> usuarioDTOs = new ArrayList<>();
        for (Usuario usuario : repo.findAll()) {
            usuarioDTOs.add(new UsuarioDTO(usuario));
        }
        return usuarioDTOs;
    }

    public UsuarioDTO getUsuarioById(Long id) {
        return repo.findById(id).isPresent() ? new UsuarioDTO(repo.findById(id).get()) : null;
    }

    public ResponseEntity<?> cadastrar(Usuario usuario) {
        if (usuario.getNome().equals("")) {
            resposta.setMensagem("O nome do usuário é obrigatório");
            return new ResponseEntity<>(resposta, HttpStatus.BAD_REQUEST);
        } else if (usuario.getSobrenome().equals("")) {
            resposta.setMensagem("O sobrenome do usuário é obrigatorio");
            return new ResponseEntity<>(resposta, HttpStatus.BAD_REQUEST);
        } else if (usuario.getApelido().equals("")) {
            resposta.setMensagem("O nickname do usuário é obrigatório");
            return new ResponseEntity<>(resposta, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(repo.save(usuario), HttpStatus.CREATED);
        }
    }

    //Cadastrar ou Alterar usuários
    public ResponseEntity<?> cadastrarAlterar(Usuario usuario, String acao) {
        if (usuario.getNome().equals("")) {
            resposta.setMensagem("O nome do usuário é obrigatório");
            return new ResponseEntity<>(resposta, HttpStatus.BAD_REQUEST);
        } else if (usuario.getSobrenome().equals("")) {
            resposta.setMensagem("O sobrenome do usuário é obrigatorio");
            return new ResponseEntity<>(resposta, HttpStatus.BAD_REQUEST);
        } else if (usuario.getApelido().equals("")) {
            resposta.setMensagem("O nickname do usuário é obrigatório");
            return new ResponseEntity<>(resposta, HttpStatus.BAD_REQUEST);
        } else {
            if (acao.equals("cadastrar")) {
                return new ResponseEntity<>(repo.save(usuario), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(repo.save(usuario), HttpStatus.OK);
            }
        }
    }

    public ResponseEntity<?> remover(Long id) {
        repo.deleteById(id);
        resposta.setMensagem("O Usuário foi Removido com Sucesso!");
        return new ResponseEntity<>(resposta, HttpStatus.OK);
    }

}
