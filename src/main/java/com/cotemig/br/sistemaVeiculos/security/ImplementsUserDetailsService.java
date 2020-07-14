package com.cotemig.br.sistemaVeiculos.security;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.cotemig.br.sistemaVeiculos.model.Usuario;
import com.cotemig.br.sistemaVeiculos.repository.UsuarioRepository;

@Repository
@Transactional
public class ImplementsUserDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioRepository ur;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		
		//tenta recuperar o usuario do banco a partir do username(login) passado na tela de login
		Usuario usuario = ur.findByLogin(login);
		
		if(usuario == null){
			throw new UsernameNotFoundException("Usuario não encontrado!!");
		}
		
		//passa os parametros do login para o construtor User - Usuario, senha, demais metodos true, lista de authorities
		return new User(usuario.getUsername(), usuario.getPassword(), true, true, true, true, usuario.getAuthorities());	
	}
}
