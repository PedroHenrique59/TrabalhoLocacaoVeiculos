package com.cotemig.br.sistemaVeiculos.service;

import java.util.List;
import java.util.Optional;

import com.cotemig.br.sistemaVeiculos.model.Cliente;
import com.cotemig.br.sistemaVeiculos.model.Locacao;

public interface LocacaoService {

	List<Locacao> buscarTodasLocacoes();
	Optional<Locacao> buscarLocacaoPorId(Integer idLocacao);
	List<Locacao> buscarTodasLocacoesNaoFinalizadas(String finalizada);
	List<Locacao> buscarTodasLocacoesFinalizadas(String finalizada);
	
	void salvarLocacao(Locacao locacao) throws Exception;
	void excluirLocacaoPorCliente(Cliente cliente) throws Exception;
	void atualizarInformacoesLocacao(Integer idCliente, Locacao locacao) throws Exception; 

}
