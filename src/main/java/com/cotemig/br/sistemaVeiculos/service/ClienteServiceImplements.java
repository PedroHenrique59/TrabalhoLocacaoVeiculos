package com.cotemig.br.sistemaVeiculos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cotemig.br.sistemaVeiculos.model.Cliente;
import com.cotemig.br.sistemaVeiculos.repository.ClienteRepository;

@Service("clienteService")
public class ClienteServiceImplements implements ClienteService{

	@Autowired
	ClienteRepository clienteRepository;
	
	@Override
	public List<Cliente> buscarTodosOsClientesCadastrados() {
		return clienteRepository.findAll();
	}

	@Override
	public Optional<Cliente> buscarClientePorCpf(Long cpf) {
		return clienteRepository.buscarClientePorCpf(cpf);	
	}

	@Override
	public List<Cliente> buscarClientesComLocacao() {
		//pensar em como será essa consulta
		return null;
	}

	@Override
	public void salvarCliente(Cliente cliente) throws Exception {
		try {
			clienteRepository.save(cliente);	
		} catch (Exception e) {
			throw new Exception("Erro ao salvar cliente!");
		}
	}

	@Override
	public void excluirTodosClientes() throws Exception {
		try {
			clienteRepository.deleteAll();
		} catch (Exception e) {
			throw new Exception("Erro ao excluir todos os clientes!");
		}
	}

	@Override
	public void excluirClientePorId(Integer idCliente) throws Exception {
		try {
			clienteRepository.deleteById(idCliente);
		} catch (Exception e) {
			throw new Exception("Erro ao excluir o cliente!");
		}
	}

	@Override
	public void atualizarClientePorCpf(Long cpf, Cliente clienteAtual) throws Exception {
		try {
			
			Optional<Cliente> clienteRetornado = clienteRepository.buscarClientePorCpf(cpf);
			
			clienteRetornado.get().setNome(clienteAtual.getNome());
			clienteRetornado.get().setEmail(clienteAtual.getEmail());
			clienteRetornado.get().setCelular(clienteAtual.getCelular());

			//lista de automoveis? 
			//endereco?
			
			clienteRepository.save(clienteRetornado.get());
			
		} catch (Exception e) {
			throw new Exception("Erro ao atualizar o cliente!");
		}
	}

	@Override
	public Optional<Cliente> buscarClientePorId(Integer idCliente) {
		return clienteRepository.findById(idCliente);
	}	
}
