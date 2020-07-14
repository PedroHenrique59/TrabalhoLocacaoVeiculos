package com.cotemig.br.sistemaVeiculos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cotemig.br.sistemaVeiculos.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

	@Query(value = "SELECT * FROM ENDERECO WHERE id_endereco = ?1", nativeQuery = true)
	Optional<Endereco> buscarEnderecoPorId(Integer idEndereco);
}
