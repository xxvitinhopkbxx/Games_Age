package br.com.gamesage.dtos;

import br.com.gamesage.entities.Progresso;
import br.com.gamesage.entities.Usuario;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class UsuarioDTO {

    private Long idUsuario;
    private String nome;
    private String sobrenome;
    private String apelido;
    private String email;
    private Set<ProgressoDTO> progressos = new HashSet<>();

    public UsuarioDTO() {
    }

    public UsuarioDTO(Usuario usuario) {
        this.idUsuario = usuario.getIdUsuario();
        this.nome = usuario.getNome();
        this.sobrenome = usuario.getSobrenome();
        this.apelido = usuario.getApelido();
        this.email = usuario.getEmail();
        for (Progresso progresso : usuario.getProgressos()) {
            ProgressoDTO progressoDTO = new ProgressoDTO();
            progressoDTO.setProgresso(progresso.getProgresso());
            progressoDTO.setConquistas(progresso.getConquistas());
            progressoDTO.setJogo(new JogoDTO(progresso.getJogo()));
            progressos.add(progressoDTO);
        }
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<ProgressoDTO> getProgressos() {
        return progressos;
    }

    public void setProgressos(Set<ProgressoDTO> progressos) {
        this.progressos = progressos;
    }
}
