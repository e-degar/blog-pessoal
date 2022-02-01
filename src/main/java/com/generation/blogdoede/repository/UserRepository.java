package com.generation.blogdoede.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.blogdoede.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
		
	public Optional<Usuario> findByLoginUsuario (String loginUsuario);
}
