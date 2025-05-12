package com.projeto.backend.repository;

import com.projeto.backend.entity.Certificado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface CertificadoRepository extends JpaRepository<Certificado, Long> {

    // Buscar todos os certificados emitidos para um determinado usuário (pelo ID do usuário)
    List<Certificado> findByUsuarioId(Long usuarioId);

    // Buscar todos os certificados emitidos para um determinado curso (pelo ID do curso)
    List<Certificado> findByCursoId(Long cursoId);

    // Buscar certificados emitidos em uma data específica
    List<Certificado> findByDataEmissao(LocalDate dataEmissao);

    // Buscar certificados emitidos após uma data específica
    List<Certificado> findByDataEmissaoAfter(LocalDate data);

    // Buscar certificados emitidos entre duas datas
    List<Certificado> findByDataEmissaoBetween(LocalDate inicio, LocalDate fim);

    // Buscar certificados por curso e usuário (caso precise verificar se um usuário já tem certificado de um curso)
    List<Certificado> findByCursoIdAndUsuarioId(Long cursoId, Long usuarioId);
}
