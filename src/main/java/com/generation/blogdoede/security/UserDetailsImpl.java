package com.generation.blogdoede.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.generation.blogdoede.domain.model.User;

/**
 * Implementação do UserDetails do spring security
 * 
 * @author Edgar Soares Marinho
 * @date 03/02/2022
 * @version 0.1.1-SNAPSHOT
 * @see UserDetails
 * @see UserModel
 * @see UserDetailsImplements
 * @see UserDetailsServiceImplement
 * 
 */

public class UserDetailsImpl implements UserDetails{

	private static final long serialVersionUID = 1L;
	private String email;
	private String passwd;
	private List<GrantedAuthority> authorities;
	
	public UserDetailsImpl(User user) {
		this.email = user.getEmail();
		this.passwd = user.getPasswd();
	}
	
	public UserDetailsImpl() {}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	
	@Override
	public String getPassword() {
		return passwd;
	}
	
	@Override
	public String getUsername() {
		return email;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	@Override
	public boolean isEnabled() {
		return true;
	}
	
}
