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

import com.generation.blogdoede.domain.model.User;
import com.generation.blogdoede.domain.repository.UserRepository;
import com.generation.blogdoede.dto.UserCredentialsDTO;
import com.generation.blogdoede.dto.UserLoginDTO;

/**
 * Implementação do UserService com os métodos relacionados com a model User
 * 
 * @author Edgar Soares Marinho
 * @date 03/02/2022
 * @version 0.1.1-SNAPSHOT
 * 
 */

@Service
public class UserService {
	
	private UserCredentialsDTO credentialsDTO;
	private @Autowired UserRepository repo;
	
	public ResponseEntity<User> registrarUsuario (User newUser) {
		Optional<User> optional = repo.findByEmail(newUser.getEmail());
		
		if (optional.isEmpty()) {
			newUser.setPasswd(encryptPasswd(newUser.getPasswd()));
			return ResponseEntity.status(201).body(repo.save(newUser));
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nome de usuário já existe!");
		}
	}
	
	private static String encryptPasswd (String passwd) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(passwd);
	}
	
	public ResponseEntity<UserCredentialsDTO> getCredentials (@Valid UserLoginDTO dto){
		return repo.findByEmail(dto.getEmail()).map(resp -> {
			BCryptPasswordEncoder encoder =  new BCryptPasswordEncoder();
			
			if (encoder.matches(dto.getPasswd(), resp.getPasswd())) {
				credentialsDTO = new UserCredentialsDTO(
						basicTokenGenerator(dto.getEmail(), dto.getPasswd()),
						resp.getName(),
						resp.getUsername(),
						resp.getId(),
						resp.getEmail(),
						resp.getPicture(),
						resp.getUser_role());

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
	
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> list = repo.findAll();
		
		if (list.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(list); 
		}
	}
	
	public ResponseEntity<User> findById(Long id){
		return repo.findById(id)
				.map(resp -> ResponseEntity.status(200).body(resp))
				.orElseGet(() -> {
					throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id Não encontrado");
				});		
	}

	public ResponseEntity<User> updateUser(@Valid User user) {
		Optional<User> opt = repo.findById(user.getId());

		if (opt.isPresent()) {
			user.setPasswd(encryptPasswd(user.getPasswd()));
			return ResponseEntity.status(200).body(repo.save(user));
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id não encontrado");
		}
	}

	@SuppressWarnings("rawtypes")
	public ResponseEntity deleteUser(Long id) {
		Optional<User> optional = repo.findById(id);
		
		if (optional.isPresent()) {
			repo.deleteById(id);
			return ResponseEntity.status(200).build();
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id não encontrado");
		}
		
	}

}
