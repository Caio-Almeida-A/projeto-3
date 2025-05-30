package com.projeto.backend.repository;

import com.projeto.backend.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // você pode colocar métodos customizados aqui se quiser
}
