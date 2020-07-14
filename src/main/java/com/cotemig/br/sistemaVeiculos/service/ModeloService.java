package com.cotemig.br.sistemaVeiculos.service;

import java.util.List;
import java.util.Optional;

import com.cotemig.br.sistemaVeiculos.enums.TipoModeloEnum;
import com.cotemig.br.sistemaVeiculos.model.Modelo;

public interface ModeloService {

	List<Modelo> buscarTodosOsModelos();
	Optional<Modelo> buscarModeloPorNome(String nome);
	Optional<Modelo> buscarModeloPorTipo(TipoModeloEnum tipo);
	Optional<Modelo> buscarModeloPorMarca(String nomeMarca);
	List<TipoModeloEnum> buscarTiposModelo();
	Optional<Modelo> buscarModeloPorId(Integer idModelo);
	
	void salvarModelo(Modelo modelo) throws Exception;
	void excluirTodosModelos() throws Exception;
	void excluirModeloPorId(Integer idModelo) throws Exception;
	void atualizarModeloPorNome(String nome, Modelo modeloAtual) throws Exception; 
}
