package com.generation.blogdoede.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.blogdoede.model.Tema;
import com.generation.blogdoede.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	public List<Tema> findAllByNomeUsuarioContainingIgnoreCase (String nomeUsuario);
	
	public List<Tema> findAllByLoginUsuarioContainingIgnoreCase (String loginUsuario);
}
