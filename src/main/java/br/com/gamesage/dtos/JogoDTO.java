package br.com.gamesage.dtos;

import br.com.gamesage.entities.Jogo;
import lombok.Data;

@Data
public class JogoDTO {

    private Long idJogo;
    private String nome;
    private String descricao;

    public JogoDTO() {
    }

    public JogoDTO(Jogo jogo) {
        this.idJogo = jogo.getIdJogo();
        this.nome = jogo.getNome();
        this.descricao = jogo.getDescricao();
    }

    public Long getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(Long idJogo) {
        this.idJogo = idJogo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
