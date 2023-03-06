package br.com.gamesage.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProgressoId implements Serializable {

    @ManyToOne
    @JsonIgnoreProperties({"progressos"})
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JsonIgnoreProperties({"progressos"})
    @JoinColumn(name = "id_jogo")
    private Jogo jogo;

    public ProgressoId(Usuario usuario, Jogo jogo) {
        this.usuario = usuario;
        this.jogo = jogo;
    }

    public ProgressoId() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProgressoId that)) return false;
        return usuario.equals(that.usuario) && jogo.equals(that.jogo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuario, jogo);
    }
}
