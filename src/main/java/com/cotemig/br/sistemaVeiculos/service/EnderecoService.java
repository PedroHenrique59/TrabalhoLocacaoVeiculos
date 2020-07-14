package com.cotemig.br.sistemaVeiculos.service;

import java.util.List;
import java.util.Optional;

import com.cotemig.br.sistemaVeiculos.model.Endereco;

public interface EnderecoService {

	List<Endereco> buscarTodosEnderecos() throws Exception;
	Optional<Endereco> buscarEnderecoDoCliente(Integer idEndereco) throws Exception;
	
	void salvarEndereco(Endereco endereco) throws Exception;
	void excluirEndereco(Endereco endereco) throws Exception;
}
