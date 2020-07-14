package com.cotemig.br.sistemaVeiculos.service;

import java.util.List;
import java.util.Optional;

import com.cotemig.br.sistemaVeiculos.model.Marca;

public interface MarcaService {

	List<Marca> buscarTodasAsMarcas();
	Optional<Marca> buscarMarcaPorNome(String nomeMarca);
	Optional<Marca> buscarMarcaPorId(Integer idMarca);
	
	void salvarMarca(Marca marca) throws Exception;
	void excluirTodasMarcas() throws Exception;
	void excluirMarcaPorId(Integer idMarca) throws Exception;
	void atualizarMarcaPorNome(String nome, Marca marcaAtual) throws Exception; 
}
