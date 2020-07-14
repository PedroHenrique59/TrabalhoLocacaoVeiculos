package com.cotemig.br.sistemaVeiculos.service;

import java.util.List;
import java.util.Optional;

import com.cotemig.br.sistemaVeiculos.enums.TipoModeloEnum;
import com.cotemig.br.sistemaVeiculos.model.Automovel;

public interface AutomovelService {

	List<Automovel> buscarTodosOsVeiculos();
	List<Automovel> buscarVeiculoPorModelo(String modeloVeiculo);
	List<Automovel> buscarVeiculosPorTipoDeModelo(TipoModeloEnum tipoModelo);
	List<Automovel> buscarVeiculosPorMarca(String nomeMarca);
	List<Automovel> buscarVeiculosDisponiveis();
	Optional<Automovel> buscarVeiculoPorId(Integer id);
	
	void salvarAutomovel(Automovel automovel) throws Exception;
	void excluirTodosAutomoveis() throws Exception;
	void excluirAutomovelPorId(Integer idAutomovel) throws Exception;
	void atualizarAutomovelPorId(Integer idAutomovel, Automovel automovelAtual) throws Exception; 
	
}
