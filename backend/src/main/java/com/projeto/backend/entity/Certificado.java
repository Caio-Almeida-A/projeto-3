package com.projeto.backend.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Certificado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataEmissao;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;

    // Construtor padrão (necessário para JPA)
    public Certificado() {}

    // Construtor completo
    public Certificado(LocalDate dataEmissao, Usuario usuario, Curso curso) {
        this.dataEmissao = dataEmissao;
        this.usuario = usuario;
        this.curso = curso;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDataEmissao(LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
