package com.cotemig.br.sistemaVeiculos.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cotemig.br.sistemaVeiculos.model.Locacao;

public interface LocacaoRepository extends JpaRepository<Locacao, Integer>  {

	@Query(value = "DELETE from LOCACAO WHERE cliente.id = ?1", nativeQuery = true)
	Optional<Locacao> excluirLocacaoPorCliente(Integer idCliente);
	
	@Query(value = "SELECT * from LOCACAO WHERE cliente.id = ?1", nativeQuery = true)
	Optional<Locacao> buscarLocacaoDoCliente(Integer idCliente);

	@Query(value = "SELECT * from LOCACAO WHERE finalizada = ?1", nativeQuery = true)
	List<Locacao> buscarLocacoesNaoFinalizadas(String naoFinalizada);

	@Query(value = "SELECT * from LOCACAO WHERE finalizada = ?1", nativeQuery = true)
	List<Locacao> buscarLocacoesFinalizadas(String finalizada);
}
