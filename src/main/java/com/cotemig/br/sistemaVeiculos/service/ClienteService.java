package com.cotemig.br.sistemaVeiculos.service;

import java.util.List;
import java.util.Optional;

import com.cotemig.br.sistemaVeiculos.model.Cliente;

public interface ClienteService {

	List<Cliente> buscarTodosOsClientesCadastrados();
	Optional<Cliente> buscarClientePorCpf(Long cpf);
	List<Cliente> buscarClientesComLocacao();	
	Optional<Cliente> buscarClientePorId(Integer idCliente);
	
	void salvarCliente(Cliente cliente) throws Exception;
	void excluirTodosClientes() throws Exception;
	void excluirClientePorId(Integer idCliente) throws Exception;
	void atualizarClientePorCpf(Long cpf, Cliente clienteAtual) throws Exception; 

}
