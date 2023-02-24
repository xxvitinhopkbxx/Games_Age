package br.com.gamesage.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idUsuario")
@Table(name = "tb_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;
    @Column(name = "nome")
    private String nome;
    @Column(name = "sobrenome")
    private String sobrenome;
    @Column(name = "apelido")
    private String apelido;
    @Column(name = "email")
    private String email;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.usuario", cascade = CascadeType.ALL)
    private Set<Progresso> progressos;

    public Usuario() {
        progressos = new HashSet<>(0);
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

    public Set<Progresso> getProgressos() {
        return progressos;
    }

    public void setProgressos(Set<Progresso> progressos) {
        this.progressos = progressos;
    }
}
