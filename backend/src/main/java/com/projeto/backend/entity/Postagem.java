package com.projeto.backend.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Postagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String conteudo;

    private LocalDate dataPostagem;

    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    private Usuario autor;

    @ManyToOne
    @JoinColumn(name = "forum_id", nullable = false)
    private Forum forum;

    // Construtor padrão
    public Postagem() {}

    // Construtor completo
    public Postagem(String conteudo, LocalDate dataPostagem, Usuario autor, Forum forum) {
        this.conteudo = conteudo;
        this.dataPostagem = dataPostagem;
        this.autor = autor;
        this.forum = forum;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public String getConteudo() {
        return conteudo;
    }

    public LocalDate getDataPostagem() {
        return dataPostagem;
    }

    public Usuario getAutor() {
        return autor;
    }

    public Forum getForum() {
        return forum;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public void setDataPostagem(LocalDate dataPostagem) {
        this.dataPostagem = dataPostagem;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public void setForum(Forum forum) {
        this.forum = forum;
    }
}
