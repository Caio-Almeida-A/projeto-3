package com.projeto.backend.controller;

import com.projeto.backend.entity.Certificado;
import com.projeto.backend.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/{id}/certificados")
    public ResponseEntity<?> salvarCertificado(@PathVariable Long id, @RequestBody Certificado cert) {
        usuarioService.salvarCertificado(id, cert);
        return ResponseEntity.ok().build();
    }

    // outros endpoints que chamam os métodos do serviço
}