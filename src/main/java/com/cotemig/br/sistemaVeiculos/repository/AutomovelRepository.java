package com.cotemig.br.sistemaVeiculos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cotemig.br.sistemaVeiculos.enums.TipoModeloEnum;
import com.cotemig.br.sistemaVeiculos.model.Automovel;

@Repository("automovelRepository")
public interface AutomovelRepository extends JpaRepository<Automovel, Integer> {

	@Query(value = "SELECT * FROM AUTOMOVEL WHERE modelo.tipo = ?1", nativeQuery = true)
	List<Automovel> buscarVeiculosPorTipoModelo(TipoModeloEnum tipoModelo);
	
	@Query(value = "SELECT * FROM AUTOMOVEL WHERE modelo.nome = ?1", nativeQuery = true)
	List<Automovel> buscarVeiculosPorModelo(String modeloVeiculo);
	
	@Query(value = "SELECT * FROM AUTOMOVEL WHERE modelo.marca = ?1", nativeQuery = true)
	List<Automovel> buscarVeiculosPorMarca(String marca);

	@Query(value = "SELECT * FROM AUTOMOVEL WHERE disponivel = ?1", nativeQuery = true)
	List<Automovel> buscarVeiculosDisponiveis(String disponivel);
	
}
