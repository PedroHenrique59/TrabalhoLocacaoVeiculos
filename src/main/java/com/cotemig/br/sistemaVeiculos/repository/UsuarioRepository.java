package com.cotemig.br.sistemaVeiculos.repository;

import org.springframework.data.repository.CrudRepository;

import com.cotemig.br.sistemaVeiculos.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String>{

	//encontrar usuário pelo login
	Usuario findByLogin(String login);
}
