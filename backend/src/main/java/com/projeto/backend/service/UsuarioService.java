package com.projeto.backend.service;

import com.projeto.backend.entity.Certificado;
import com.projeto.backend.entity.Usuario;
import com.projeto.backend.repository.CertificadoRepository;
import com.projeto.backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CertificadoRepository certificadoRepository;

    public void salvarCertificado(Long idUsuario, Certificado certificado) {
        // Buscar o usuário pelo ID
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        // Associar o certificado ao usuário
        certificado.setUsuario(usuario);

        // Salvar o certificado
        certificadoRepository.save(certificado);

        // (Opcional) Salvar o usuário, caso necessário
        usuario.getCertificados().add(certificado);
        usuarioRepository.save(usuario);
    }

    // Adicione outros métodos de serviço relacionados a "Usuario" conforme necessário
}
