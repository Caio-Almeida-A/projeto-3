package com.projeto.backend.repository;

import com.projeto.backend.entity.Certificado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface CertificadoRepository extends JpaRepository<Certificado, Long> {

    // Buscar todos os certificados emitidos por um usuário específico (usando o ID do usuário)
    List<Certificado> findByUsuarioId(Long usuarioId);

    // Buscar todos os certificados emitidos para um curso específico (usando o ID do curso)
    List<Certificado> findByCursoId(Long cursoId);

    // Buscar todos os certificados emitidos em uma data específica
    List<Certificado> findByDataEmissao(LocalDate dataEmissao);

    // Buscar certificados emitidos após uma certa data
    List<Certificado> findByDataEmissaoAfter(LocalDate data);

    // Buscar certificados emitidos entre duas datas
    List<Certificado> findByDataEmissaoBetween(LocalDate inicio, LocalDate fim);
}