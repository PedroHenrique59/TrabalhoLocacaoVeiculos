package com.cotemig.br.sistemaVeiculos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cotemig.br.sistemaVeiculos.model.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Integer> {

	@Query(value = "SELECT * MARCA WHERE nome = ?1", nativeQuery = true)
	Optional<Marca> buscarMarcaPorNome(String nomeMarca);
	
}
