package br.com.gamesage.dtos;

import lombok.Data;

@Data
public class ProgressoDTO {

    private Float progresso;
    private Integer conquistas;
    private JogoDTO jogo;

    public Float getProgresso() {
        return progresso;
    }

    public void setProgresso(Float progresso) {
        this.progresso = progresso;
    }

    public Integer getConquistas() {
        return conquistas;
    }

    public void setConquistas(Integer conquistas) {
        this.conquistas = conquistas;
    }

    public JogoDTO getJogo() {
        return jogo;
    }

    public void setJogo(JogoDTO jogo) {
        this.jogo = jogo;
    }
}
