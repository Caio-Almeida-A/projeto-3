package com.projeto.backend.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Forum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    private Usuario autor;

    @OneToMany(mappedBy = "forum", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Postagem> postagens;

    // Construtor padrão
    public Forum() {}

    // Construtor completo
    public Forum(String titulo, Usuario autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public Usuario getAutor() {
        return autor;
    }

    public List<Postagem> getPostagens() {
        return postagens;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public void setPostagens(List<Postagem> postagens) {
        this.postagens = postagens;
    }
}
