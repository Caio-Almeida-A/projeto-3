package com.projeto.backend.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cursoNome;

    private String certificado; // Pode ser modelo ou descrição

    @ManyToMany(mappedBy = "cursos")
    private List<Usuario> usuarios;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    private List<Certificado> certificados;

    // Construtor padrão
    public Curso() {}

    // Construtor completo
    public Curso(String cursoNome, String certificado) {
        this.cursoNome = cursoNome;
        this.certificado = certificado;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public String getCursoNome() {
        return cursoNome;
    }

    public String getCertificado() {
        return certificado;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public List<Certificado> getCertificados() {
        return certificados;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCursoNome(String cursoNome) {
        this.cursoNome = cursoNome;
    }

    public void setCertificado(String certificado) {
        this.certificado = certificado;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void setCertificados(List<Certificado> certificados) {
        this.certificados = certificados;
    }
}