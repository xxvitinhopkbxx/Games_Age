package br.com.gamesage.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Component
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "pk")
@Table(name = "tb_progresso")
@AssociationOverrides({
        @AssociationOverride(name = "pk.usuario", joinColumns = @JoinColumn(name = "id_usuario")),
        @AssociationOverride(name = "pk.jogo", joinColumns = @JoinColumn(name = "id_jogo"))})
public class Progresso {

    @EmbeddedId
    private ProgressoId pk = new ProgressoId();
    @Column(name = "progresso")
    private Float progresso;
    @Column(name = "conquistas")
    private Integer conquistas;

    public ProgressoId getPk() {
        return pk;
    }

    public void setPk(ProgressoId pk) {
        this.pk = pk;
    }

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

    @Transient
    public Usuario getUsuario() {
        return getPk().getUsuario();
    }

    public void setUsuario(Usuario usuario) {
        getPk().setUsuario(usuario);
    }

    @Transient
    public Jogo getJogo() {
        return getPk().getJogo();
    }

    public void setJogo(Jogo jogo) {
        getPk().setJogo(jogo);
    }
}
