package com.cotemig.br.sistemaVeiculos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cotemig.br.sistemaVeiculos.enums.TipoModeloEnum;
import com.cotemig.br.sistemaVeiculos.model.Modelo;

public interface ModeloRepository extends JpaRepository<Modelo, Integer> {

	@Query(value = "SELECT * MODELO WHERE nome = ?1", nativeQuery = true)
	Optional<Modelo> buscarModeloPorNome(String nomeModelo);
	
	@Query(value = "SELECT * MODELO WHERE tipo = ?1", nativeQuery = true)
	Optional<Modelo> buscarModeloPorTipo(TipoModeloEnum nomeModelo);
	
	@Query(value = "SELECT * MODELO WHERE marca.nome = ?1", nativeQuery = true)
	Optional<Modelo> buscarModeloPorMarca(String nomeMarca);

}
