package com.cotemig.br.sistemaVeiculos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cotemig.br.sistemaVeiculos.model.Cliente;

@Repository("clienteRepository")
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

	@Query(value = "SELECT * CLIENTE WHERE cpf = ?1", nativeQuery = true)
	Optional<Cliente> buscarClientePorCpf(Long cpf);
}
