package com.generation.blogdoede.service;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.generation.blogdoede.dto.UserCredentialsDTO;
import com.generation.blogdoede.dto.UserLoginDTO;
import com.generation.blogdoede.model.Usuario;
import com.generation.blogdoede.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	
	private UserCredentialsDTO credentialsDTO;
	private @Autowired UsuarioRepository repo;
	
	public ResponseEntity<Usuario> registrarUsuario (Usuario novoUsuario) {
		Optional<Usuario> optional = repo.findByLoginUsuario(novoUsuario.getLoginUsuario());
		
		if (optional.isEmpty()) {
			novoUsuario.setSenhaUsuario(encryptPasswd(novoUsuario.getSenhaUsuario()));
			return ResponseEntity.status(201).body(repo.save(novoUsuario));
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nome de usuário já existe!");
		}
	}
	
	private static String encryptPasswd (String passwd) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(passwd);
	}
	
	public ResponseEntity<UserCredentialsDTO> getCredentials (@Valid UserLoginDTO dto){
		return repo.findByLoginUsuario(dto.getUsername()).map(resp -> {
			BCryptPasswordEncoder encoder =  new BCryptPasswordEncoder();
			
			if (encoder.matches(dto.getPasswd(), resp.getSenhaUsuario())) {
				credentialsDTO = new UserCredentialsDTO(
						basicTokenGenerator(dto.getUsername(), dto.getPasswd()),
						resp.getIdUsuario(),
						resp.getLoginUsuario());
				return ResponseEntity.status(200).body(credentialsDTO);
			} else {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Senha inválida");
			}
		}).orElseThrow(() -> {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário não existe!");
		});
	}
	
	private static String basicTokenGenerator(String username, String passwd) {
		String structure = username + ":" + passwd;
		byte[] structureBase64 = Base64.encodeBase64(structure.getBytes(Charset.forName("US-ASCII")));
		return "Basic " + new String(structureBase64);
	}
	
	public ResponseEntity<List<Usuario>> getAllUsers(){
		List<Usuario> list = repo.findAll();
		
		if (list.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(list); 
		}
	}
	
	public ResponseEntity<Usuario> findById(Long id){
		return repo.findById(id)
				.map(resp -> ResponseEntity.status(200).body(resp))
				.orElseGet(() -> {
					throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id Não encontrado");
				});		
	}

	public ResponseEntity<Usuario> updateUser(@Valid Usuario user) {
		return repo.findById(user.getIdUsuario())
				.map(resp -> ResponseEntity.status(200).body(repo.save(user)))
				.orElseGet(() -> {
					throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id não encontrado");
				});
	}

	@SuppressWarnings("rawtypes")
	public ResponseEntity deleteUser(Long id) {
		Optional<Usuario> optional = repo.findById(id);
		
		if (optional.isPresent()) {
			repo.deleteById(id);
			return ResponseEntity.status(200).build();
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id não encontrado");
		}
		
	}

}
